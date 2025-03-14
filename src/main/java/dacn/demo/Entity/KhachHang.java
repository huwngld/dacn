package dacn.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "KhachHang")
@Builder
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maKhachHang;
    private String tenKhachHang;
    private boolean gioiTinh;
    private String ngaySinh;
    private String diaChi;
    private String sdt;
    private String taiKhoan;
    private String matKhau;
    @JsonIgnore
    @OneToMany(mappedBy = "khachHang",cascade = CascadeType.ALL)
    private List<HoaDon> hoaDon;

}