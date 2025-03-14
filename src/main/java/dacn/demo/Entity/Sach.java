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
@Table(name = "Sach")
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maSach;

    private String img;
    private String tenSach;

    @ManyToOne
    @JoinColumn(name = "maTacGia",referencedColumnName = "maTacGia")
    private TacGia tacGia;

    @ManyToOne
    @JoinColumn(name = "maTheLoai", referencedColumnName = "maTheLoai")
    private TheLoai theLoai;

    @ManyToOne
    @JoinColumn(name = "maNhaXuatBan", referencedColumnName = "maNhaXuatBan")
    private NhaXuatBan nhaXuatBan;
    private int soLuongTon;
    private double giaBan;
    @JsonIgnore
    @OneToMany(mappedBy = "sach",cascade = CascadeType.ALL)
    private List<ChiTietHoaDon> chiTietHoaDon;
}
