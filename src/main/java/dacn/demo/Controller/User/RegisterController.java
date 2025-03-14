package dacn.demo.Controller.User;
import dacn.demo.DTO.Request.RegisterRequest;
import dacn.demo.DTO.Response.CustomResponse;
import dacn.demo.Service.Users.Register.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    RegisterService register;
    @PostMapping("/register")
    public CustomResponse test(@RequestBody RegisterRequest data){
        return CustomResponse.builder()
                .result(register.Register(data))
                .build();
    }
}
