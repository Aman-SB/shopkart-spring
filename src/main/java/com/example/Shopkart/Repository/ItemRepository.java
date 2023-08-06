package com.example.Shopkart.Repository;

import com.example.Shopkart.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
