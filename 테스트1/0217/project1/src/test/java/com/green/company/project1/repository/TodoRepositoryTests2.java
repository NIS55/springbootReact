package com.green.company.project1.repository;

import com.green.company.project1.domain.Todo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.validation.AbstractBindingResultAssert;

import java.util.*;


@SpringBootTest
@Slf4j
public class TodoRepositoryTests2 {
    @Autowired
    private TodoRepository repository;

    @Test
    public void testPaging() {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) list.add(i + 1);
        map.put("data", list);
        Page<Todo> result = null;
        Pageable pageable=null;
        for (int i : map.get("data")) {
            pageable = PageRequest.of(i, 10, Sort.by("tno").descending());
            result = repository.findAll(pageable);
            log.info("page " + i + "======================== ");
            result.getContent().forEach(j -> log.info("todo: " + j));
        }
        int pageSize = 7;
        long lastPage = result.getTotalElements() / pageSize;
        long lastPageData = result.getTotalElements() % pageSize;
        log.info("last: " + lastPage + ",data:" + lastPageData);
        pageable = PageRequest.of((int) (lastPage + 1), (int)lastPageData, Sort.by("tno").descending());
        result = repository.findAll(pageable);
        log.info("last page ======================== ");
        result.getContent().forEach(j -> log.info("todo: " + j));
    }
    @Test
    public void testOrdering(){
        String[] str={"tno","writer","dueDate"};
        int[] d ={1,2,3,4,11};
        Pageable pageable;
        for(String i :str)    {
            for(int k: d){
                log.info(k+"page======================================= ");
                pageable = PageRequest.of(k,10, Sort.by(i).descending());
                Page<Todo> result = repository.findAll(pageable);
                result.getContent().forEach(j -> log.info("todo: " + j));
            }
            log.info("========================="+ i +"keyword");
        }
    }
    
}


