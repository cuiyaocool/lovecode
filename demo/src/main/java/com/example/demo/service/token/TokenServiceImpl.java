package com.example.demo.service.token;

import com.example.demo.exception.ApiException;
import com.example.demo.exception.IServiceException;
import com.example.demo.service.ITokenService;
import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * @author cuiyaocy
 */
@Service
@Qualifier("tokenServiceImpl")
public class TokenServiceImpl implements ITokenService {

    @Autowired
    private RedisService redisService;

    @Override
    public String generateToken() {
        UUID uuid = UUID.randomUUID();
        String key = uuid.toString().replace("-", "").toUpperCase();
        redisService.setValues("TOKEN" + key, key, 5);
        return key;
    }

    @Override
    public boolean checkToken(String key) throws ApiException {
        Optional<Object> gettoken = gettoken(key);
        if (!gettoken.isPresent()) {
            throw new ApiException("repeated request", IServiceException.ExceptionType.REPEAT_REQUEST);
        } else {
            boolean res = redisService.delKey("TOKEN" + key);
            if (res) {
                return true;
            } else {
                throw new ApiException("重复请求", IServiceException.ExceptionType.REPEAT_REQUEST);
            }
        }
    }

    @Override
    public Optional<Object> gettoken(String key) {
        return redisService.getValue("TOKEN" + key);
    }
}
