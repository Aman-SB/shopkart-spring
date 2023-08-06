package com.example.Shopkart.Service;

import com.example.Shopkart.Dto.RequestDto.CustomerRequestDto;
import com.example.Shopkart.Dto.ResponseDto.CustomerResponseDto;
import com.example.Shopkart.Model.Cart;
import com.example.Shopkart.Model.Customer;
import com.example.Shopkart.Repository.CustomerRepository;
import com.example.Shopkart.Transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {

        // dto -> entity
        Customer customer = CustomerTransformer.CustomerRequestDtoToCustomer(customerRequestDto);

        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);
        customer.setCart(cart);

        Customer savedCustomer = customerRepository.save(customer);   // saves both customer and cart;

        // prepare the response dto
        return CustomerTransformer.CustomerToCustomerResponseDto(savedCustomer);

    }
}
