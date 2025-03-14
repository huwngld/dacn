package dacn.demo.Controller.User;

import com.nimbusds.jose.JOSEException;
import dacn.demo.DTO.Request.SignInRequest;
import dacn.demo.DTO.Response.CustomResponse;
import dacn.demo.Entity.HoaDon;
import dacn.demo.Service.Admin.Convert.GenerateToken;
import dacn.demo.Service.Admin.HoaDon.HoaDonService;
import dacn.demo.Service.Users.Home.HomeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class Home {

    HomeService home;

    @GetMapping("/")
    public CustomResponse getAll(){
        return CustomResponse.builder()
                .result(home.getAll())
                .build();
    }
}
