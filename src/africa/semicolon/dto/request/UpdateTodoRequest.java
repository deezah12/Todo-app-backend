package africa.semicolon.dto.request;

import lombok.Data;

@Data
public class UpdateTodoRequest {
    private  String title;
    private  String body;
}
