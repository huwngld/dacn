package dacn.demo.Controller.Admin;

import dacn.demo.Entity.HoaDon;
import dacn.demo.Service.Admin.HoaDon.HoaDonService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequestMapping("/admin")
@Slf4j
public class LichSuDatHang {
    HoaDonService hd;
    @PreAuthorize("hasRole('ROLE_STAFF')")
    @GetMapping("/lich-su-dat-hang")
    public List<HoaDon> getAll1(){
        var context = SecurityContextHolder.getContext().getAuthentication();
        context.getAuthorities().forEach(req -> log.info(req.getAuthority()));
        context.getAuthorities().forEach(req -> System.out.println(req.getAuthority()));
        return hd.getAll();
    }
}
