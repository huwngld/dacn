package dacn.demo.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignInRequest {
    private String taiKhoan;
    private String matKhau;

}
