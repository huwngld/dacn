package dacn.demo.Controller.User;

import dacn.demo.DTO.Request.SachRequest;
import dacn.demo.DTO.Response.CustomResponse;
import dacn.demo.DTO.Response.ResponseList;
import dacn.demo.Service.Admin.NhaPhatHanh.NhaXuatBanService;
import dacn.demo.Service.Admin.Sach.SachService;
import dacn.demo.Service.Admin.TacGia.TacGiaService;
import dacn.demo.Service.Admin.TheLoai.TheLoaiService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequestMapping("/sach")
public class SachController {
    SachService sach;
    TacGiaService tg;
    TheLoaiService tl;
    NhaXuatBanService nxb;

    @GetMapping("/")
    public ResponseList getAll(){
        return new ResponseList(tg.getAll(),tl.getAll(),nxb.getAll());
    }

    @GetMapping("/details/{id}")
    public CustomResponse details(@PathVariable(name = "id") int id){
        return CustomResponse.builder()
                .result(sach.getOne(id))
                .build();
    }
}
