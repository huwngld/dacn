package dacn.demo.Controller.User;

import dacn.demo.Entity.HoaDon;
import dacn.demo.Service.Admin.HoaDon.HoaDonService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class TrangThaiDonHang {
    HoaDonService hd;
    @GetMapping("/trang-thai-don-hang/{sdt}")
    public List<HoaDon> timKiemDonHang(@PathVariable("sdt") String sdt){
        return hd.timKien(sdt);
    }
}
