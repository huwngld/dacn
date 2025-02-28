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
@Table(name = "Sach")
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maSach;
    private String tenSach;

    @ManyToOne
    @JoinColumn(name = "maSach",referencedColumnName = "maTacGia")
    private TacGia tacGia;

    @ManyToOne
    @JoinColumn(name = "maSach", referencedColumnName = "maTheLoai")
    private TheLoai theLoai;

    @ManyToOne
    @JoinColumn(name = "maSach", referencedColumnName = "maNhaXuatBan")
    private NhaXuatBan nhaXuatBan;
    private int soLuongTon;
    private double giaBan;
    private String viTri;
    @OneToMany(mappedBy = "sach")
    private List<ChiTietHoaDon> chiTietHoaDon;
}
