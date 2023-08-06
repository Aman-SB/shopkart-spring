package com.example.Shopkart.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "seller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column(unique = true , nullable = false)
    String emailId;

    @Column(unique = true , nullable = false)
    String panNo;

    @OneToMany(mappedBy = "seller" , cascade =  CascadeType.ALL)
    List<Product> products = new ArrayList<>();
}
