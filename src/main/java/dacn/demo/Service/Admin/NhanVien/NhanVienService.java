package dacn.demo.Service.Admin.NhanVien;

import dacn.demo.Entity.NhanVien;
import dacn.demo.Repository.NhanVienRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class NhanVienService {
    NhanVienRepo nv;
    public List<NhanVien> getAll(){
        return nv.findAll();
    }
}
