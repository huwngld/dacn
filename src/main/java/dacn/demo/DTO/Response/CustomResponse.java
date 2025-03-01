package dacn.demo.DTO.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomResponse<T> {
    private boolean trangThai;
    T result;
}
