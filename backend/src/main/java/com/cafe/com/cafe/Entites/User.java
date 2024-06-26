package com.cafe.com.cafe.Entites;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import java.io.Serializable;

@NamedQuery(name = "User.findByEmailId", query = "select u from User u where u.email=:email")
@NamedQuery(name = "User.getAllUser", query = "SELECT NEW com.cafe.com.cafe.wrapper.User_Wrapper(u.id, u.name, u.email, u.contactNumber, u.status, u.role) FROM User u WHERE u.role='user' OR u.role='cook'")
@NamedQuery(name = "User.updateStatus", query = "update User u set u.status=:status where u.id=:id ")
@NamedQuery(name = "User.getAllAdmin", query = "select u.email from User u where u.role='admin' ")

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "contactNumber")
    private String contactNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "tempPassword")
    private String tempPassword;

    @Column(name = "status")
    private String status;

    @Column(name = "role")
    private String role;

    @Column(name = "otp")
    private String otp;
}
