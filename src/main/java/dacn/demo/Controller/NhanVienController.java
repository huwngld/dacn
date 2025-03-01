package dacn.demo.Controller;

import dacn.demo.DTO.Response.CustomResponse;
import dacn.demo.Entity.NhanVien;
import dacn.demo.Repository.NhanVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NhanVienController {
    @Autowired
    NhanVienRepo nhanVienRepo;

    @GetMapping("test")
    public CustomResponse test(){

        return CustomResponse.builder()
                .trangThai(true)
                .result(nhanVienRepo.findAll())
                .build();
    }
}
