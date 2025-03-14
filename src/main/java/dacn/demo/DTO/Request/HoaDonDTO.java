package dacn.demo.DTO.Request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HoaDonDTO implements Serializable {
    String taiKhoan;
    String tenKhachHang;
    String sdt;
    String ghiChu;
    String diaChi;
    String trangThai;
    int tongTien;
    List<SanPhamDTO> items;
}
