package dacn.demo.Service.Users.SignIn;

import dacn.demo.DTO.Request.SignInRequest;
import dacn.demo.Entity.KhachHang;
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
public class SignInApp {
    KhachHangRepo kh;
    public boolean si(SignInRequest signInRequest){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        KhachHang tk = kh.findKhachHangByTaiKhoan(signInRequest.getTaiKhoan());
        return encoder.matches(signInRequest.getMatKhau(), tk.getMatKhau());
    }
}
