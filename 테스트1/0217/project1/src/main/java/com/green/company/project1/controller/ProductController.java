package com.green.company.project1.controller;

import com.green.company.project1.dto.PageRequestDTO;
import com.green.company.project1.dto.PageResponseDTO;
import com.green.company.project1.dto.ProductDTO;
import com.green.company.project1.service.ProductService;
import com.green.company.project1.util.CustomFileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final CustomFileUtil fileUtil;
    private final ProductService service;

    @PostMapping("/")
    public Map<String ,String> register(ProductDTO dto){
        log.info("controller register : " +dto);
        List<MultipartFile> fileList= dto.getFiles();
        List<String> uploadFileNames =fileUtil.saveFiles(fileList);
        dto.setUploadFileNames(uploadFileNames);
        log.info("uploadFileNames:"+uploadFileNames);
        return Map.of("result","성공");
    }
    //파일 보여주기(brower)
    @GetMapping("/view/{fileName}") //img src="/view/123445_s송준항.jpg"
    public ResponseEntity<Resource> viewFileGET(@PathVariable String fileName){
        return fileUtil.getFile(fileName);
    }


    @GetMapping("/list")
    public PageResponseDTO<ProductDTO> list(PageRequestDTO dto){
        log.info("product controller list :" + dto);
        return service.getList(dto);
    }
}
