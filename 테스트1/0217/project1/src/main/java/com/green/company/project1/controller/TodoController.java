package com.green.company.project1.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.green.company.project1.domain.Todo;
import com.green.company.project1.dto.PageRequestDTO;
import com.green.company.project1.dto.PageResponseDTO;
import com.green.company.project1.dto.TodoDTO;
import com.green.company.project1.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.event.WindowFocusListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/todo")
@RequiredArgsConstructor
@Slf4j
public class TodoController {

    private  final TodoService service;
    @GetMapping("/list")
    public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO){
        log.info("controller all list :" +pageRequestDTO);
        return service.list(pageRequestDTO);
    }
    @GetMapping("{tno}")
    public TodoDTO get(@PathVariable(name = "tno") Long tno){
        log.info("controller get tno: " +tno);
        return service.get(tno);
    }
    //pdf page 48
    @PostMapping("/")
    public Map<String,Long> register(@RequestBody TodoDTO todoDTO){
        log.info("controller post register : " + todoDTO);
        Long tno = service.register(todoDTO);
        return Map.of("tno",tno);
    }

    @PutMapping("/{tno}")
    public Map<String,String> modify(
            @PathVariable(name = "tno") Long tno,
            @RequestBody TodoDTO todoDTO ){
        todoDTO.setTno(tno);
        log.info("controller 수정 : " +tno +", dto:" +todoDTO);
        service.modify(todoDTO);
        return Map.of("result","성공");
    }

    @GetMapping("/modify")
    public String modifyAll(){
        service.allDBChange();
        return "성공";
    }
    @DeleteMapping("/{tno}")
    public Map<String,String> remove(@PathVariable(name="tno") Long tno){
        log.info("tno remove controller : " + tno);
        service.remove(tno);
        return  Map.of("result","성공");
    }
    //1) 전체 데이터 삭제(/api/todo/delete)
    @GetMapping("/v")
    public String deleteAll(){
        log.info("controller deleteAll");
        List<TodoDTO> list = service.find();
        log.info("list"+list);

        list.forEach(i->{
            service.remove(i.getTno());
        });
        return "전체 삭제 성공";
    }
    //2) 데이터 200개 추가( 원래 post 방식으로 해야 하지만 그러면 200번을 데이터 입력 해야 하므로
    //get 방식으로 접근하여 반복문으로 dummy data를 생성하여 save 호출 하세요 (/api/todo/dummy)
//    rivate Long tno;//primary key 이면 auto_increment
//
//    private String title;
//    private String writer;
//    private boolean complete;
//
//    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
//    private LocalDate dueDate;
    @GetMapping("/dummy")
    public  String dummyData(){
        for (int i = 0; i <200 ; i++) {
            service.register(new TodoDTO(null,
                    "제목"+(int)(Math.random()*100),
                    "작성자" +(int)(Math.random()*100) ,
                    true,
                    LocalDate.now()
            ));
        }
        return  "성공";
    }

}
