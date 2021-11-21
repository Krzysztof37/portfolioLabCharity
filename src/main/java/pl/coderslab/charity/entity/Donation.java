package pl.coderslab.charity.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Donation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotNull(message = "Podaj ilość worków")
    Integer quantity;
    @NotNull(message = "Podaj kategorię")
    @ManyToMany
    List<Category> category;
    @NotNull(message = "Wybierz instytucję")
    @ManyToOne
    Institution institution;
    @NotBlank(message = "Podaj miasto")
    String city;
    @NotBlank(message = "Podaj ulicę")
    String street;
    @NotBlank(message = "Podaj kod pocztowy")
    String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Podaj datę")
    LocalDate pickUpDate;
    @NotNull(message = "Podaj godzinę")
    LocalTime pickUpTime;
    String pickUpComment;
    @Column(columnDefinition = "integer default 0")
    Integer received;



}
