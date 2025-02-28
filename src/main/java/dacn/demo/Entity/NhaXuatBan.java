package dacn.demo.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NhaXuatBan")
public class NhaXuatBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maNhaXuatBan;
    private String tenNhaXuatBan;
    private String diaChi;
    private String sdt;
    private String email;
    @OneToMany(mappedBy = "nhaXuatBan",cascade = CascadeType.ALL)
    private List<Sach> sach;
}