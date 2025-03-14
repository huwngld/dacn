package dacn.demo.Service.Admin.NhaPhatHanh;

import dacn.demo.Entity.NhaXuatBan;
import dacn.demo.Repository.NhaXuatBanRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class NhaXuatBanService {
    NhaXuatBanRepo nxb;
    public List<NhaXuatBan> getAll(){
        return nxb.findAll();
    }
}
