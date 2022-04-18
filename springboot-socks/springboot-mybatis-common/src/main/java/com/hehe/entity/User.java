package com.hehe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "T_USER")
public class User {
    @Id //指定userId为主键
    @Column(name = "USER_ID") //直接在实体类绑定与数据库表的映射关系
    private String userId;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "PHONE_NUM")
    private String mobileNum;
    @Transient
    private String other; //跟数据库无关的字段使用@Transient标记或移至VO类。

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
//    public String getMobileNum() {
//        return mobileNum;
//    }
//
//    public void setMobileNum(String mobileNum) {
//        this.mobileNum = mobileNum;
//    }
}
