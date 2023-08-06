package com.example.Shopkart.Repository;

import com.example.Shopkart.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {

    public Card findByCardNo(String cardNo);
}
