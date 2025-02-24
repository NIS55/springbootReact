package com.green.company.project1.service;

import com.green.company.project1.dto.PageRequestDTO;
import com.green.company.project1.dto.PageResponseDTO;
import com.green.company.project1.dto.TodoDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Slf4j
public class ProductServiceTests {
    
    @Autowired
    private ProductService service;

    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO= PageRequestDTO.builder()
                .page(2)
                .size(10)
                .build();
        PageResponseDTO<TodoDTO> response = service.list(pageRequestDTO);
        log.info(""+response);
        response.getDtoList().forEach(i -> log.info(""+i));
        //select  *  from tbl_todo  order by  tno desc limit 20,30
    }
    

}
