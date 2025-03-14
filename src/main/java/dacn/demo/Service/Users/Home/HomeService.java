package dacn.demo.Service.Users.Home;

import dacn.demo.Entity.Sach;
import dacn.demo.Repository.SachRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class HomeService {
    SachRepo sach;
    public List<Sach> getAll(){
        return sach.findAll();
    }
}
