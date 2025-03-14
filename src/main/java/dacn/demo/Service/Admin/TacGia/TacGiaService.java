package dacn.demo.Service.Admin.TacGia;

import dacn.demo.Entity.TacGia;
import dacn.demo.Repository.TacGiaRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class TacGiaService {
    TacGiaRepo tacGia;
    public List<TacGia> getAll(){
        return tacGia.findAll();
    }
}
