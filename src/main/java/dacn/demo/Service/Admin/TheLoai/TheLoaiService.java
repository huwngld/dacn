package dacn.demo.Service.Admin.TheLoai;

import dacn.demo.Entity.TheLoai;
import dacn.demo.Repository.TheLoaiRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class TheLoaiService {
    TheLoaiRepo tl;
    public List<TheLoai> getAll(){
        return tl.findAll();
    }
}
