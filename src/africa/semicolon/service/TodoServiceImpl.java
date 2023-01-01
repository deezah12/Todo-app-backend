package africa.semicolon.service;

import africa.semicolon.dto.request.CreateTodoRequest;
import africa.semicolon.dto.request.UpdateTodoRequest;
import africa.semicolon.exception.TodoNotFoundException;
import africa.semicolon.data.models.TodoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import africa.semicolon.data.repository.TodoRepository;

import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{
    @Autowired
    private TodoRepository todoRepository;


    @Override
    public Optional<TodoApp> getTodo(String id) {
        return todoRepository.findById(id);
    }

    @Override
    public void createTodos(CreateTodoRequest createTodoRequest) {

        TodoApp todoApp = new TodoApp();
        todoApp.setTitle(createTodoRequest.getTitle());
        todoApp.setBody(createTodoRequest.getBody());
        todoRepository.save(todoApp);
    }

    @Override
    public void updateTodos(String id, UpdateTodoRequest updateTodoRequest) {
        TodoApp updatedTodo = new TodoApp();
        if (todoRepository.existsById(id)) {
            updatedTodo.setId(id);
            updatedTodo.setTitle(updateTodoRequest.getTitle());
            updatedTodo.setBody(updateTodoRequest.getBody());
            todoRepository.save(updatedTodo);
        }
        else {
            throw new TodoNotFoundException("This todo id does not exist");
        }
    }


    @Override
    public  void deleteTodo(String id) {
        if (todoRepository.existsById(id)){
            todoRepository.deleteById(id);
        }
    }

}
