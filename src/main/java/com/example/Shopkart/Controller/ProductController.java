package com.example.Shopkart.Controller;

import com.example.Shopkart.Dto.RequestDto.ProductRequestDto;
import com.example.Shopkart.Dto.ResponseDto.ProductResponseDto;
import com.example.Shopkart.Enums.ProductCategory;
import com.example.Shopkart.Exception.SellerNotFoundException;
import com.example.Shopkart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto){

        try{
            ProductResponseDto response = productService.addProduct(productRequestDto);
            return new ResponseEntity(response,HttpStatus.CREATED);
        }
        catch (SellerNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get_by_category_and_price_greater_than")
    public ResponseEntity getProdByCategoryAndPriceGreaterThan(@RequestParam("price") int price,
                                                               @RequestParam("category") ProductCategory category){

        List<ProductResponseDto> productResponseDtoList =
                productService.getProdByCategoryAndPriceGreaterThan(price,category);
        return new ResponseEntity(productResponseDtoList,HttpStatus.FOUND);
    }
}
