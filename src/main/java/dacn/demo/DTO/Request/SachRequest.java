package dacn.demo.DTO.Request;

import dacn.demo.Entity.NhaXuatBan;
import dacn.demo.Entity.TacGia;
import dacn.demo.Entity.TheLoai;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class SachRequest {
    private MultipartFile imgFile;
    private String tenSach;
    private TacGia tacGia;
    private TheLoai theLoai;
    private NhaXuatBan nhaXuatBan;
    private int soLuongTon;
    private double giaBan;

}
