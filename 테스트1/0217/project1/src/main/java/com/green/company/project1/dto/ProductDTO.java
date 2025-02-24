package com.green.company.project1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
//pdf 5page
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long pno;
    private String pname;
    private int price;
    private String pdesc;
    private boolean delFlag;// 삭제가아니라 delFlag true로 하면 삭제했다고 가정

    @Builder.Default
    private List<MultipartFile> files =new ArrayList<>();//하나의 상품에 여러개의 이미지를 등록

    @Builder.Default
    private List<String> uploadFileNames = new ArrayList<>();

}
