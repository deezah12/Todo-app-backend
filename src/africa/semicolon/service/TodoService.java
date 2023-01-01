package africa.semicolon.service;

import africa.semicolon.data.models.TodoApp;
import africa.semicolon.dto.request.CreateTodoRequest;
import africa.semicolon.dto.request.UpdateTodoRequest;


import java.util.Optional;

public interface TodoService {
   Optional<TodoApp> getTodo(String id);
    void createTodos(CreateTodoRequest createTodoRequest);
    void updateTodos(String id, UpdateTodoRequest updateTodoRequest);
    void deleteTodo(String id);

}
