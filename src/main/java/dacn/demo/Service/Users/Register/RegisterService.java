package dacn.demo.Service.Users.Register;

import dacn.demo.DTO.Request.RegisterRequest;
import dacn.demo.Mapper.mapper;
import dacn.demo.Repository.KhachHangRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class Register{
    KhachHangRepo kh;
    mapper map;
    public boolean Register(RegisterRequest data){
        try{
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            data.setMatKhau(encoder.encode(data.getMatKhau()));
            kh.save(map.toKhachHang(data));
            return true;
        }catch (Exception ex) {
            return false;
        }
    }
}
