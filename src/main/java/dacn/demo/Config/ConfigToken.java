package dacn.demo.Config;

import com.nimbusds.jwt.JWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.text.ParseException;

@Component
@Slf4j
public class ConfigToken implements JwtDecoder {
    @Value("${application.key}")
    String key;

    @Override
    public Jwt decode(String token) throws JwtException {

        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(),"HS512");//dùng để tạo ra 1 bộ giải mã từ key và thuật toán sau khi decoder sẽ ra jwt
        return NimbusJwtDecoder.withSecretKey(secretKeySpec).macAlgorithm(MacAlgorithm.HS512).build().decode(token);//cung cấp secretkey và thuật toán để giải mã và decode để trả ra 1 jwt token
    }
}
