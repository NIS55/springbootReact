package com.green.company.project1.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_todo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tno;//primary key 이면 auto_increment

    private String title;
    private String writer;
    private boolean complete;
    private LocalDate dueDate;

    public void changeTitle(String title){
        this.title=title;
    }
    public void changeComplete(boolean complete){
        this.complete=complete;
    }
    public void changeDueDate(LocalDate dueDate){
        this.dueDate=dueDate;
    }

}
