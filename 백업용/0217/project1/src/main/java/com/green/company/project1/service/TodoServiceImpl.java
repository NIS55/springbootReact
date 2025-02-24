package com.green.company.project1.service;

import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import com.green.company.project1.domain.Todo;
import com.green.company.project1.dto.PageRequestDTO;
import com.green.company.project1.dto.PageResponseDTO;
import com.green.company.project1.dto.TodoDTO;
import com.green.company.project1.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.metamodel.model.domain.TreatableDomainType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional//ACID (Atomic ,Consistency, Isolation(독립성) , Durablity)
@Slf4j
@RequiredArgsConstructor
public class TodoServiceImpl implements  TodoService{
//    @Autowired
//    private ModelMapper modelMapper;
    private final ModelMapper modelMapper;
    private final TodoRepository todoRepository;

    @Override
    public Long register(TodoDTO todoDTO) {
        log.info("todo service ------------------");
        Todo todo=modelMapper.map(todoDTO, Todo.class);
        Todo savedTodo = todoRepository.save(todo);
        return savedTodo.getTno();
    }

    @Override
    public TodoDTO get(Long tno) {
        log.info("todo service get ------------------"+tno);
        Optional<Todo> result = todoRepository.findById(tno);
        Todo todo= result.orElseThrow();
        TodoDTO dto= modelMapper.map(todo, TodoDTO.class);
        return dto;
    }

    @Override
    public List<TodoDTO> find() {
        List<Todo> result = todoRepository.findAll();
        List<TodoDTO> resultDtoList=new ArrayList<>();
        result.forEach(i->{
            TodoDTO data = modelMapper.map(i, TodoDTO.class);
            resultDtoList.add(data);
        });
        return resultDtoList;
    }

    @Override
    public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO) {//brower url list?page=5&size=10에 전달되는
        //값을 controller에 전달하고 그 controller에서 pageRequestDTO 에 정보가 전달된
        //pdf 38p
        Pageable pageable= PageRequest.of(pageRequestDTO.getPage()-1,
                pageRequestDTO.getSize(), Sort.by("tno").descending());

        Page<Todo> result = todoRepository.findAll(pageable);
        List<TodoDTO> dtoList= result.getContent().stream()
                .map(i-> modelMapper.map(i, TodoDTO.class))
                .collect(Collectors.toList());
        long totalCount = result.getTotalElements();
        PageResponseDTO<TodoDTO> responseDTO= PageResponseDTO.<TodoDTO>withAll()
                .dtoList(dtoList)
                .pageRequestDTO(pageRequestDTO)
                .totalCount(totalCount)
                .build();

        return responseDTO;
    }

    @Override
    public void modify(TodoDTO dto) {
        Optional<Todo> result = todoRepository.findById(dto.getTno());//수정하려는 데이터 조회
        Todo todo = result.orElseThrow();
        todo.changeTitle(dto.getTitle());
        todo.changeDueDate(dto.getDueDate());
        todo.changeComplete(dto.isComplete());
        todoRepository.save(todo);
    }

    @Override
    public void remove(Long tno) {
        todoRepository.deleteById(tno);
    }
    @Override
    public void allDBChange() {
        String[] str={"가","나","다","라","마","바","사","아"};
        List<Long> list = todoRepository.findAll().stream().map(i -> i.getTno()).toList();//tnoList
        list.forEach(i->{//tnoList에서 하나씩 꺼내어
            Todo todo= todoRepository.findById(i).get();// tno에 대한 데이터를 가져와사 아래와 같이 수정하고 save 호출
            String title="", writer="";
            for (int j = 0; j < (int)(Math.random()*str.length) ; j++) {
                int index=(int)(Math.random()*str.length);
                title+= str[index];
            }
            todo.changeTitle(title+"입니다");//제목수정
            for (int j = 0; j < (int)(Math.random()*str.length/2) ; j++) {
                int index=(int)(Math.random()*str.length);
                writer+= str[index];
            }
            todo.setWriter("작성자"+writer);//작성자 수정
            todoRepository.save(todo);
        });
    }

    @Override
    public void t() {

        todoRepository.findAll().forEach(i->{//tnoList에서 하나씩 꺼내어
            Todo a = todoRepository.findById(i.getTno()).get();
            a.setWriter("홍길동"+(int)(Math.random()*100));
            a.setTitle("제목"+(int)(Math.random()*100));//작성자 수정
            todoRepository.save(a);
        });
    }
}
