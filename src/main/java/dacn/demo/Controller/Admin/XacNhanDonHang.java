package dacn.demo.Controller.Admin;

import dacn.demo.DTO.Request.HoaDonDTO;
import dacn.demo.Service.Admin.HoaDon.HoaDonService;
import dacn.demo.Service.Admin.Sach.SachService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequestMapping("/admin")
public class XacNhanDonHang {
    HoaDonService hd;
    RedisTemplate redisTemplate;
    SachService s;
    @PreAuthorize("hasRole('ROLE_STAFF')")
    @GetMapping("/save-data/{index}")
    public boolean saveData(@PathVariable("index") int index){
        hd.add((HoaDonDTO)redisTemplate.opsForList().index("xndh",index));
        return true;
    }
    @PreAuthorize("hasRole('ROLE_STAFF')")
    @GetMapping("/xac-nhan-don-hang")
    public List<HoaDonDTO> xacNhanDonHang(){
        return redisTemplate.opsForList().range("xndh",0,-1);
    }

    @PostMapping("/luu-don-hang")
    public Long luuDonHang(@RequestBody HoaDonDTO data){
        return redisTemplate.opsForList().rightPushAll("xndh",data);
    }
    @PreAuthorize("hasRole('ROLE_STAFF')")
    @GetMapping("/huy-don-hang/{index}")
    public Long huyDonHang(@PathVariable("index") int index){
        return redisTemplate.opsForList().remove("xndh",1,redisTemplate.opsForList().index("xndh",index));
    }
}
