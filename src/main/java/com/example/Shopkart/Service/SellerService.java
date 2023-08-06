package com.example.Shopkart.Service;

import com.example.Shopkart.Dto.RequestDto.SellerRequestDto;
import com.example.Shopkart.Dto.ResponseDto.SellerResponseDto;
import com.example.Shopkart.Model.Seller;
import com.example.Shopkart.Repository.SellerRepository;
import com.example.Shopkart.Transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) {

        // dto -> entity
        Seller seller = SellerTransformer.SellerRequestDtoToSeller(sellerRequestDto);

        // save the entity
        Seller savedSeller = sellerRepository.save(seller);

        // prepare response dto
        return SellerTransformer.SellerToSellerResponseDto(savedSeller);
    }
}
