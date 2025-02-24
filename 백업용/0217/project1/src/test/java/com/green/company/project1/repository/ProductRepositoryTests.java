package com.green.company.project1.repository;

import com.green.company.project1.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository repository;


    @Test
    public void testInsert(){
        for (int i = 0; i < 10; i++) {
            Product product = Product.builder()
                    .pname("상품"+i)
                    .price(100*i)
                    .pdesc("상품 설명 " +i)
                    .build();
            //2개의 이미지 파일 추가
            product.addImageString("IMAGE1.jpg");
            product.addImageString("IMAGE2.jpg");
            repository.save(product);
            log.info("============================");
        }
    }
}
