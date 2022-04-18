package com.hehe.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "T_USER")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"}) //指定要忽略的字段 @JsonIgnoreProperties(ignoreUnknown = true)将这个注解写在类上之后，就会忽略类中不存在的字段
public class User {

    @Id
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;

}
