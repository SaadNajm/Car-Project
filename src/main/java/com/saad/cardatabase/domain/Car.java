package com.saad.cardatabase.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand,model,color,registrationNumber;
    private int price,modelYear;
    @ManyToOne
    @JoinColumn(name="owner")
    private Owner owner;
}
