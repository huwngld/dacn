package dacn.demo.Service.Admin.KhachHang;

import dacn.demo.Entity.KhachHang;
import dacn.demo.Repository.KhachHangRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class KhachHangService {
    KhachHangRepo kh;

    public List<KhachHang> getAll(){
        return kh.findAll();
    }
}
