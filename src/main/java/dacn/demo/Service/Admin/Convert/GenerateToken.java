package dacn.demo.Service.Admin.Convert;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import dacn.demo.DTO.Request.SignInRequest;
import dacn.demo.DTO.Request.Token;
import dacn.demo.Entity.NhanVien;
import dacn.demo.Repository.NhanVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class GenerateToken {
    @Autowired
    NhanVienRepo nvr;

    @Value("${application.key}")
    String key;
    public String generateToken(SignInRequest request) throws JOSEException {
        System.out.println(request);
        NhanVien nv = nvr.findNhanVienByTaiKhoan(request.getTaiKhoan());

        if(nv.getTaiKhoan().equals(request.getTaiKhoan()) && nv.getMatKhau().equals(request.getMatKhau())){
            JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .subject(nv.getTaiKhoan())
                    .issuer("hung")
                    .claim("scope",nv.getVaiTro())
                    .build();
            Payload payload = claimsSet.toPayload();
            JWSObject jwsObject = new JWSObject(header,payload);
            jwsObject.sign(new MACSigner(key.getBytes()));
            return jwsObject.serialize();
        }
        return null;
    }
    public boolean verifyToken(Token token) throws JOSEException, ParseException {
        MACVerifier mac = new MACVerifier(key.getBytes());
        SignedJWT signedJWT = SignedJWT.parse(token.getToken());
        return signedJWT.verify(mac);
    }
}
