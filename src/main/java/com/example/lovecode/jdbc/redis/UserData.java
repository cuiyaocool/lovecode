package com.example.lovecode.jdbc.redis;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Map;


/**
 * @author cuiyaocy
 */
@Data
@RedisHash("user")
@NoArgsConstructor
public class UserData {

    @Id
    private String userId;

    private Map<String, String> data;
}
