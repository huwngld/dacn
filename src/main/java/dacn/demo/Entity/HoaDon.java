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
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    private String maHoaDon;

    @ManyToOne
    @JoinColumn(name = "maNhanVien",referencedColumnName = "maNhanVien")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "maKhachHang",referencedColumnName = "maKhachHang")
    private KhachHang khachHang;

    private Date ngayLap;
    private double tongTien;

    @JsonIgnore
    @OneToMany(mappedBy = "hoaDon",cascade = CascadeType.ALL)
    private List<ChiTietHoaDon> chiTietHoaDon;
}
