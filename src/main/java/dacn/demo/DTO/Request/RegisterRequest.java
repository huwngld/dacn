package dacn.demo.DTO.Request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String tenKhachHang;
    private boolean gioiTinh;
    private String ngaySinh;
    private String diaChi;
    private String sdt;
    private String email;
    private String taiKhoan;
    private String matKhau;
}
