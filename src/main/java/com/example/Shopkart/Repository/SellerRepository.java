package com.example.Shopkart.Repository;

import com.example.Shopkart.Model.Card;
import com.example.Shopkart.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Integer> {
    public Seller findByEmailId(String email);
}
