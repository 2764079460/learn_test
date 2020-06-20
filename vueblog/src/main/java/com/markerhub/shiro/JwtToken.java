package com.markerhub.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created by xiangmiao on 2020/6/12.
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String jwt) {
        this.token = jwt;
    }

    @Override
    public Object getPrincipal() {
        return this.token;
    }

    @Override
    public Object getCredentials() {
        return this.token;
    }
}
