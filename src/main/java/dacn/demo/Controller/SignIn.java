package dacn.demo.Controller.SignIn;

import dacn.demo.DTO.Request.SignInRequest;
import dacn.demo.DTO.Response.CustomResponse;
import dacn.demo.Service.Users.SignIn.SignInApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignIn {
    @Autowired
    SignInApp sign;
    @PostMapping("/sign-in")
    public CustomResponse test(@RequestBody SignInRequest signInRequest){
        return CustomResponse.builder()
                .result(sign.si(signInRequest))
                .build();
    }
}
