package pl.coderslab.charity.entity;


import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Pole imię nie może być puste")
    private String name;
    @NotBlank(message = "Pole nazwisko nie może być puste")
    private String surName;
    @NotBlank(message = "Pole email nie może być puste")
    @Size(max = 70, message = "Zbyt wiele znaków")
    @Pattern(regexp = "([A-Za-z0-9\\W_]+[A-Za-z0-9\\W_]*)@([A-Za-z0-9]+)\\.([a-zA-Z0-9]+)", message = "Nieprawidłowy adres email")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "Pole hasło nie może być puste")
    @Size(min = 8, message = "Hasło powinno mieć conajmniej 8 znaków")
    private String password;
    @Column(columnDefinition = "integer default 0")
    private Integer admin;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Role> roles;

}
