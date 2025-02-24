package com.green.company.project1.service;

import com.green.company.project1.domain.Todo;
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
public class TodoServiceTests {
    
    @Autowired
    private TodoService service;
    
    @Test
    public void testRegister(){
        TodoDTO dto = TodoDTO.builder()
                .title("서비스테스트")
                .writer("tester service")
                .dueDate(LocalDate.of(2025,02,12))
                .build();
        
        Long tno = service.register(dto);
        log.info("tno: " +tno);
    }

    @Test
    public void testGet(){
        TodoDTO dto= service.get(10l);
        log.info("dto:" +dto);
    }

    //문1) repository의 findAll을 호출하면 테이블에 저장된 전체 데이터를 준다
    // service에서 전체 데이터를 가져오고 여기 test 코드에서 확인한다
    //service interface에 함수 등록 ,implement에 overriding 하고
    //그 안을 채운다
    @Test
    public void testFind(){
        List<TodoDTO> result = service.find();
        result.forEach(i-> log.info("dto:" +i));
    }
    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO= PageRequestDTO.builder()
                .page(2)
                .size(10)
                .build();
        PageResponseDTO<TodoDTO> response = service.list(pageRequestDTO);
        log.info(""+response);
        //select  *  from tbl_todo  order by  tno desc limit 20,30
    }
}
