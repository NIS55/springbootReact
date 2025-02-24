package com.green.company.project1.service;


import com.green.company.project1.domain.Product;
import com.green.company.project1.domain.ProductImage;
import com.green.company.project1.dto.PageRequestDTO;
import com.green.company.project1.dto.PageResponseDTO;
import com.green.company.project1.dto.ProductDTO;
import com.green.company.project1.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService{


    private  final ProductRepository repository;

    @Override
    public PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO) {
        log.info("get List : ");
        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage() -1,
                pageRequestDTO.getSize(),
                Sort.by("pno").descending()
        );
        Page<Object[]> result = productRepository.selectList(pageable);

        List<ProductDTO> dtoList = result.get().map(arr-> {
            Product product = (Product) arr[0];
            ProductImage productImage = (ProductImage) arr[1];

            ProductDTO productDTO = ProductDTO.builder()
                    .pno(product.getPno())
                    .pname(product.getPname())
                    .pdesc(product.getPdesc())
                    .price(product.getPrice())
                    .build();
            String imageStr = productImage.getFileName();
            productDTO.setUploadFileNames(List.of(imageStr));
            return productDTO;
        }).collect(Collectors.toList());
        long totalCount = result.getTotalElements();
        return PageResponseDTO.<ProductDTO>withAll()
                .dtoList(dtoList)
                .totalCount(totalCount)
                .pageRequestDTO(pageRequestDTO)
                .build();
    }

    @Override
    public Long register(ProductDTO dto) {
        Product product  =
        return 0L;
    }

    private Product dtoToEntity(ProductDTO dto){
        Product product = Product.builder()
                .pname(dto.getPname())
                .pno(dto.getPno())
                .price(dto.getPrice())
                .pdesc(dto.getPdesc())
                .build();

    }
}
