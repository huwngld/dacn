package dacn.demo.Controller.User;

import dacn.demo.DTO.Request.ConvertToken;
import dacn.demo.DTO.Request.HoaDonDTO;
import dacn.demo.DTO.Request.MuaHang;
import dacn.demo.DTO.Request.toSHA256;
import dacn.demo.Entity.Sach;
import dacn.demo.Service.Admin.Convert.ConvertData;

import dacn.demo.Service.Admin.HoaDon.HoaDonService;
import dacn.demo.Service.Admin.Sach.SachService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class MuaHangController {

    ConvertData cv;

    @PostMapping("/mua-hang")
    public MuaHang muaHang(@RequestBody MuaHang data){
        return data;
    }

    @PostMapping("/convert")
    public String convert(@RequestBody ConvertToken data) throws NoSuchAlgorithmException, InvalidKeyException {
        return cv.isValidData(data.getData());
    }

}
