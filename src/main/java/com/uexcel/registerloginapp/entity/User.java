package com.uexcel.registerloginapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users", uniqueConstraints =
@UniqueConstraint(name="email_unique",columnNames = {"email"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String FullName;
    private String email;
    private String password;
    private String role;

}
