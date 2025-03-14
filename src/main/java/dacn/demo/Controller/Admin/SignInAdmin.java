package dacn.demo.Controller.Admin;


import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.SignedJWT;
import dacn.demo.DTO.Request.SignInRequest;
import dacn.demo.DTO.Request.Token;
import dacn.demo.Service.Admin.Convert.GenerateToken;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Slf4j
//@RequestMapping("/admin")
public class SignInAdmin {
    GenerateToken tk;
    @PostMapping("/admin-sign-in")
    public String adminSignIn(@RequestBody SignInRequest rq) throws JOSEException {
        return tk.generateToken(rq);
    }

}
