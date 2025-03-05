package dacn.demo.DTO.Request;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
public class RegisterRequest {
    private String tenKhachHang;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String email;
    private String taiKhoan;
    private String matKhau;
}
