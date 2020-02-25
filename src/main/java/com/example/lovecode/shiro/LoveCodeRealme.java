package com.example.lovecode.shiro;

import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.springframework.stereotype.Component;

@Component("loveCodeRealme")
public class LoveCodeRealme extends JdbcRealm {

}
