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
@Table(name = "TheLoai")
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maTheLoai;
    private String tenTheLoai;
    @JsonIgnore
    @OneToMany(mappedBy = "theLoai",cascade = CascadeType.ALL)
    private List<Sach> sach;
}