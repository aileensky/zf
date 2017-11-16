package cn.derek.springcloud.learning.common.biz.impl;

import cn.derek.springcloud.learning.common.biz.IJWTInfo;

public class JWTInfo implements IJWTInfo {

    protected String id;
    protected String name;
    protected String username;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public JWTInfo(String id, String name, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JWTInfo JWTInfo = (JWTInfo) o;

        if (!id.equals(JWTInfo.id)) return false;
        return username.equals(JWTInfo.username);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + username.hashCode();
        return result;
    }
}
