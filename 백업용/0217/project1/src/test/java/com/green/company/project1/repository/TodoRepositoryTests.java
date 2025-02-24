package com.green.company.project1.repository;


import com.green.company.project1.domain.Todo;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootTest
@Slf4j
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository repository;


    //단위 테스트(Unit Test)
    @Test
    public void test(){
//        repository.save(new Todo(null,"홍콩","마리아",false, LocalDate.now()));
        for (int i = 0; i <=100 ; i++) {
            Todo todo=   Todo.builder()
                    .complete(true)
                    .dueDate(LocalDate.now())
                    .title("오늘은 행복한 화요일" +i)
                    .writer("홍길동"+i)
                    .build();
//            todo.setComplete(false);
//            todo.setTitle("과자");
//            todo.setDueDate(LocalDate.now());
//            todo.setWriter("송준항 케이크");
            repository.save(todo);
            log.info("사랑");
       
        }
    }

    @Test
    public void testRead(){
        Long tno = 33l;
        Optional<Todo> result = repository.findById(tno);
        Todo todo = result.orElseThrow();
        log.info("find: "+todo);
    }
    //문 1)
    // tno(Id)가 1,3,5,11,23인것 찾아라
    @Test
    public void testFindvalue(){
        long[] arr={1,2,3,11,23};
        List<Todo> result =new ArrayList<>();
        for(long i : arr){
            Todo v = repository.findById(i).get();
            if(v.getTno()==i){
                result.add(v);
            }
        }
        for(Todo i : result){
            log.info(" "+i);
        }
    }

    @Test
    public void testFindvalueJpaMethod(){
        Long[] arr={1L,2L,3l,11l,23l};

        List<Todo> list = repository.findAllById(List.of(arr));
        list.forEach(i->log.info("find2)"+i));

    }

    @Test
    public void testModify(){
        Long tno = 33l;
        Optional<Todo> result = repository.findById(tno);
        Todo todo = result.orElseThrow();
        todo.changeTitle("수정했어요 제목을");
        todo.changeComplete(true);
        todo.changeDueDate(LocalDate.of(2025,02,11));
        repository.save(todo);
    }

    @Test
    public void testDelete(){
        repository.deleteById(33l);
    }


}
