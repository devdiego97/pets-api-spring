package com.diegoddev.pets.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="pets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @Size(min=5,max=5,message = "o sexo do pet deve ser macho ou femea")
    private String sex;

    
    @NotNull(message = "A idade não pode ser nula")
    @Min(value = 0, message = "A idade não pode ser negativa")
    @Max(value = 100, message = "A idade não pode ser maior que 100")
    private Integer age;

    @NotBlank(message = "raça do pet obrigatório")
    @Size(min = 5,max = 50,message = "a raça do pet deve estar entre 5 e 50 caracteres")
    private String race;


}
