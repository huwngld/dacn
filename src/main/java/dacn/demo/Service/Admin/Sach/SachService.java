package dacn.demo.Service.Admin.Sach;

import dacn.demo.DTO.Request.SachRequest;
import dacn.demo.DTO.Request.SanPhamDTO;
import dacn.demo.Entity.Sach;
import dacn.demo.Mapper.mapper;
import dacn.demo.Repository.SachRepo;
import dacn.demo.Service.Users.UploadAnh.uploadAnhService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Service
public class SachService {
    SachRepo sach;
    mapper map;
    uploadAnhService upload;
    public List<Sach> addSach(SachRequest data) throws IOException {
        Sach s = map.toSach(data);
        s.setImg("http://localhost:8080"+upload.uploadAnh(data.getImgFile()));
        sach.save(s);
        return sach.findAll();
    }
    public List<Sach> getAll(){
        return sach.findAll();
    }
    public Sach getOne(int id){
        Sach s = sach.findSachByMaSach(id);
        return s;
    }
    public List<Sach> delete(int id){
        sach.delete(sach.findSachByMaSach(id));
        return sach.findAll();
    }
}
