package com.hehe.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "T_USER")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"}) //这个干嘛用的?
public class User {

    @Id
    @GenericGenerator(name = "idg",strategy = "uuid")
    @GeneratedValue(generator = "idg")
    private String userId;
    private String username;
    private String password;

}
