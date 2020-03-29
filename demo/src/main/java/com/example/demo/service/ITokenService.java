package com.example.demo.service;

import com.example.demo.exception.ApiException;

/**
 * @author cuiyaocy
 */
public interface ITokenService {

    String generateToken();
    boolean checkToken(String key) throws ApiException;
    Object gettoken(String key);
}
