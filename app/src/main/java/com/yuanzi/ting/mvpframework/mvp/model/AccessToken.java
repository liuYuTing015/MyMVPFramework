package com.yuanzi.ting.mvpframework.mvp.model;

public class AccessToken extends Response {

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    public String access_token = "unsign";
    public String token_type = "Bearer";
    public String refresh_token;
    public long expires_in;

    public boolean isNewUser() {
        return isNewUser;
    }

    public void setIsNewUser(boolean isNewUser) {
        this.isNewUser = isNewUser;
    }

    public boolean isNewUser;

    public String getAuthorization() {
        return String.format("%1$s %2$s", token_type, access_token);
    }
}