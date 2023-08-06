package com.example.Shopkart.Service;

import com.example.Shopkart.Dto.RequestDto.ItemRequestDto;
import com.example.Shopkart.Exception.CustomerNotFoundException;
import com.example.Shopkart.Exception.InsufficientQuantityException;
import com.example.Shopkart.Exception.ProductNotFoundException;
import com.example.Shopkart.Model.Customer;
import com.example.Shopkart.Model.Item;
import com.example.Shopkart.Model.Product;
import com.example.Shopkart.Repository.CustomerRepository;
import com.example.Shopkart.Repository.ProductRepository;
import com.example.Shopkart.Transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    public Item createItem(ItemRequestDto itemRequestDto) {

        Customer customer = customerRepository.findByEmailId(itemRequestDto.getCustomerEmail());
        if(customer==null){
            throw new CustomerNotFoundException("Customer doesn't exisit");
        }

        Optional<Product> productOptional = productRepository.findById(itemRequestDto.getProductId());
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product doesn't exist");
        }

        Product product = productOptional.get();

        // check for required quantity
        if(product.getAvailableQuantity()< itemRequestDto.getRequiredQuantity()){
            throw new InsufficientQuantityException("Sorry! Required quantity not avaiable");
        }

        // create item
        Item item = ItemTransformer.ItemRequestDtoToItem(itemRequestDto.getRequiredQuantity());
        return item;
    }
}
