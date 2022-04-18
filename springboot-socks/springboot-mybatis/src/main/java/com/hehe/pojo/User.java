package com.hehe.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    //配置文件中开启了全局驼峰映射
    private String userId;
    private String username;
    private String password;

//    public User() {
//
//    }
//
//    public User(String userId, String username, String password) {
//        this.userId = userId;
//        this.username = username;
//        this.password = password;
//    }
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "userId='" + userId + '\'' +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}
