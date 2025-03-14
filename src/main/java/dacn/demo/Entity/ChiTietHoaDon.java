package dacn.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ChiTietHoaDon")
@Builder
public class ChiTietHoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maChiTietHoaDon;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "maHoaDon",referencedColumnName = "maHoaDon")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "maSach", referencedColumnName = "maSach")
    private Sach sach;

    private int soLuong;
    private double donGia;
}
