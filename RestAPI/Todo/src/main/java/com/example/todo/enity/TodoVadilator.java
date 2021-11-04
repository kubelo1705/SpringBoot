package com.example.todo.enity;

import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
public class TodoVadilator {
      public boolean isValid(Todo todo){
          return Optional.ofNullable(todo).filter(t->!t.getTitle().isEmpty())
                  .filter(t->!t.getContent().isEmpty()).isPresent();
      }
}
