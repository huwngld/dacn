package dacn.demo.DTO.Response;

import dacn.demo.Entity.NhaXuatBan;
import dacn.demo.Entity.TacGia;
import dacn.demo.Entity.TheLoai;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Data
@AllArgsConstructor
public class ResponseList {
    private List<TacGia> ds1;
    private List<TheLoai> ds2;
    private List<NhaXuatBan> ds3;

}
