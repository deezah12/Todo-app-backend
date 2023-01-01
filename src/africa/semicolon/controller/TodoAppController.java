package africa.semicolon.controller;

import africa.semicolon.data.models.TodoApp;
import africa.semicolon.dto.request.CreateTodoRequest;
import africa.semicolon.dto.request.UpdateTodoRequest;
import africa.semicolon.service.TodoService;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/v1/todoApp")
@AllArgsConstructor
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
})
public class TodoAppController {

    @Autowired
    TodoService todoService;

    @PostMapping("/create/todo")
    public  String createTodo(@RequestBody CreateTodoRequest createTodoRequest){
        todoService.createTodos(createTodoRequest);
        return "Todo created successfully";
    }
    @PutMapping("/update/todo/{todoId}")
    public  String updateTodo(@PathVariable String todoId, @RequestBody UpdateTodoRequest updateTodoRequest){
        todoService.updateTodos(todoId, updateTodoRequest);
        return "Todo updated successfully";
    }

    @GetMapping("/get/todo/{todoId}")
    public ResponseEntity<TodoApp> viewTodo(@PathVariable String todoId){
        return todoService.getTodo(todoId)
                .map(todoEntity -> new ResponseEntity<>(todoEntity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/todo/{todoId}")
    public String deleteTodo(@PathVariable String todoId){
       todoService.deleteTodo(todoId);
       return "deleted";
    }
}
