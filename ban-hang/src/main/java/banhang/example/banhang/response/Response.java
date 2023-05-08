package banhang.example.banhang.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Response {

    private String message;
    private Boolean status;
    private Object data;


    public Response(String message, boolean status, Object data) {
        this.message=message;
        this.status=status;
        this.data = data;
    }
}
