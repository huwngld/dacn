package dacn.demo.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HoaDon")
@Builder
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String maHoaDon;

    @ManyToOne
    @JoinColumn(name = "maNhanVien",referencedColumnName = "maNhanVien")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "maKhachHang",referencedColumnName = "maKhachHang")
    private KhachHang khachHang;

    private Date ngayLap;
    private double tongTien;
    private String trangThai;
    @BatchSize(size = 1)
    @OneToMany(mappedBy = "hoaDon",cascade = CascadeType.ALL)
    private List<ChiTietHoaDon> chiTietHoaDon;
}
