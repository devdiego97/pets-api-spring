package com.diegoddev.pets.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="pets")
public class Pet {
      
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nome do pet obrigatório")
    @Size(min = 3,max = 30,message = "o nome do pet deve estar entre 3 e 30 caracteres")
    private String name;

    @NotBlank(message = "cor do pet obrigatório")
    @Size(min = 3,max = 30,message = "o cor do pet deve estar entre 3 e 30 caracteres")
    private String color;

    @NotBlank(message = "sexo do pet obrigatório")
    @Size(min = 8,max = 9,message = "o sexo do pet deve estar entre 8 ou 9 caracteres")
    private String sex;

    @NotBlank(message = "idade do pet obrigatório")
    @Size(min = 8,max = 9,message = "a idade do pet deve estar entre 8 ou 9 caracteres")
    private Integer age;

    @NotBlank(message = "raça do pet obrigatório")
    @Size(min = 5,max = 50,message = "a raça do pet deve estar entre 5 e 50 caracteres")
    private String race;


}
