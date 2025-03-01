package dacn.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maNhanVien;
    private String taiKhoan;
    private String matKhau;
    private String tenNhanVien;
    private String gioiTinh;
    private String ngaySinh;
    private String diaChi;
    private String sdt;
    private String email;
    private String vaiTro;
    @JsonIgnore
    @OneToMany(mappedBy = "nhanVien",cascade = CascadeType.ALL)
    private List<HoaDon> hoaDon;
}