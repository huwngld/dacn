package dacn.demo.Controller.User;

import dacn.demo.DTO.Request.SignInRequest;
import dacn.demo.DTO.Response.CustomResponse;
import dacn.demo.Service.Users.SignIn.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignIn {
    @Autowired
    SignInService sign;
    @PostMapping("/sign-in")
    public CustomResponse test(@RequestBody SignInRequest signInRequest){
        return CustomResponse.builder()
                .trangThai(sign.si(signInRequest)!=null)
                .result(sign.si(signInRequest))
                .build();
    }
}
