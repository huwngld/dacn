package dacn.demo.Entity;

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
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maKhachHang;
    private String tenKhachHang;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String email;
    @OneToMany(mappedBy = "khachHang",cascade = CascadeType.ALL)
    private List<HoaDon> hoaDon;

}