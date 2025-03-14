package dacn.demo.DTO.Response;

import dacn.demo.Entity.KhachHang;
import dacn.demo.Entity.NhanVien;
import dacn.demo.Entity.Sach;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseList1 {
    private List<NhanVien> ds1;
    private List<KhachHang> ds2;
    private List<Sach> ds3;
}
