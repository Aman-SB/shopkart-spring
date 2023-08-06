package com.example.Shopkart.Repository;

import com.example.Shopkart.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
