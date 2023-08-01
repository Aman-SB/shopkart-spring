package com.example.Shopkart.Model;

import com.example.Shopkart.Enums.CardType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true)
    String cardNo;

    int CVV;

    Date validTill;

    CardType cardType;

    @ManyToOne
    @JoinColumn
    Customer customer;

}
