package com.example.Shopkart.Transformer;

import com.example.Shopkart.Dto.ResponseDto.CartResponseDto;
import com.example.Shopkart.Dto.ResponseDto.ItemResponseDto;
import com.example.Shopkart.Model.Cart;
import com.example.Shopkart.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class CartTransformer {
    public static CartResponseDto CartToCartReponseDto(Cart cart){

        List<ItemResponseDto> itemResponseDtoList = new ArrayList<>();
        for(Item item: cart.getItems()){
            itemResponseDtoList.add(ItemTransformer.ItemToItemResponseDto(item));
        }

        return CartResponseDto.builder()
                .cartTotal(cart.getCartTotal())
                .customerName(cart.getCustomer().getName())
                .items(itemResponseDtoList)
                .build();
    }
}
