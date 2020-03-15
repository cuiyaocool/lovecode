package com.example.lovecode.jdbc.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author cuiyaocy
 * @date 2020年3月15日
 */
@Repository(value = "userRedis")
public interface UserReidsResposity extends CrudRepository<UserData, String> {
}
