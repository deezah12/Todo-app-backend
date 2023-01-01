package africa.semicolon.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document
public class TodoApp {
    @Id
    private String id;
    @Getter
    @Setter
    private boolean complete;
    private String title;
    private String body;
    private LocalDateTime creationTime = LocalDateTime.now();
}
