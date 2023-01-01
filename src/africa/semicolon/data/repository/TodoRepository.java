package africa.semicolon.data.repository;

import africa.semicolon.data.models.TodoApp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends MongoRepository<TodoApp, String> {


}
