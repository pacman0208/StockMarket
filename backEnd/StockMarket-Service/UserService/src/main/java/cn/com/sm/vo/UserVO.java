package cn.com.sm.vo;

import cn.com.sm.entity.UsersEntity;

public class UserVO extends UsersEntity {
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
