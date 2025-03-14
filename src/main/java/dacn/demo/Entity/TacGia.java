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
@Table(name = "TacGia")
public class TacGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maTacGia;
    private String tenTacGia;
    private String gioiTinh;
    private String ngaySinh;
    private String diaChi;
    private String sdt;
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy = "tacGia",cascade = CascadeType.ALL)
    private List<Sach> sach;
}
