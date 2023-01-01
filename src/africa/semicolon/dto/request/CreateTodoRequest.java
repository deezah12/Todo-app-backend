package africa.semicolon.dto.request;

import lombok.Data;

@Data
public class CreateTodoRequest {
    private String title;
    private String body;
}
