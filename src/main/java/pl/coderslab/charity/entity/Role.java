package pl.coderslab.charity.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;



}
