package dacn.demo.DTO.Request;


import lombok.Data;

import java.io.Serializable;

@Data
public class SanPhamDTO implements Serializable {
    int maSach;
    String ten;
    int soLuong;
    int gia;
}
