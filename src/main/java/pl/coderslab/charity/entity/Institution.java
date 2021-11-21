package pl.coderslab.charity.entity;



import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "institutions")
@Data
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    @Override
    public String toString() {
        return "instytucja: "+name+" opis: "+description;
    }
}



