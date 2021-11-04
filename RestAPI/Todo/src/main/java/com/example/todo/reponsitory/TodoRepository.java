package com.example.todo.reponsitory;

import com.example.todo.enity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {

}
