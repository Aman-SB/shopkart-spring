package com.example.Shopkart.Model;

import com.example.Shopkart.Enums.ProductCategory;
import com.example.Shopkart.Enums.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String productName;

    double price;

    int availableQuantity;

    ProductCategory category;

    ProductStatus productStatus;

    @ManyToOne
    @JoinColumn
    Seller seller;

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();
}
