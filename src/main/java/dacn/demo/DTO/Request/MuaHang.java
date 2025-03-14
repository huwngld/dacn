package dacn.demo.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class MuaHang implements Serializable {
    private int idSach;
    private String ten;
    private String diaChi;
    private String sdt;
}
