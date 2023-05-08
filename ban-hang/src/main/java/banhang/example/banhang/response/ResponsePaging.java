package banhang.example.banhang.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponsePaging {
    private String message;
    private Boolean status;
    private Object data;

    private Integer pageNo;

    private Integer pageSize;

    private Integer total;

    public ResponsePaging(String message, boolean status, Object data, Integer pageNo, Integer pageSize,Integer total ) {
        this.message=message;
        this.status=status;
        this.data = data;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.total = total;
    }
}
