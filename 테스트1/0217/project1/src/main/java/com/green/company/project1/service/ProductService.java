package com.green.company.project1.service;


import com.green.company.project1.dto.PageResponseDTO;
import com.green.company.project1.dto.ProductDTO;
import jakarta.transaction.Transactional;

@Transactional
public interface ProductService {
    public PageResponseDTO<ProductDTO> getList(PageResponseDTO dto);
    Long register(ProductDTO dto)
}
