package dacn.demo.Controller.Admin;

import dacn.demo.DTO.Request.SachRequest;
import dacn.demo.DTO.Response.CustomResponse;
import dacn.demo.Entity.Sach;
import dacn.demo.Service.Admin.Sach.SachService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequestMapping("/admin")
@Slf4j
public class SanPhamController {
    SachService s;
    @PreAuthorize("hasRole('ROLE_STAFF')")
    @PostMapping("/add-sach")
    public CustomResponse add(SachRequest data) throws IOException {
        var context = SecurityContextHolder.getContext().getAuthentication();
        context.getAuthorities().forEach(rq -> System.out.println(rq.getAuthority()));
        return CustomResponse.builder()
                .result(s.addSach(data))
                .build();
    }

    @PreAuthorize("hasRole('ROLE_STAFF')")
    @GetMapping("/sach")
    public CustomResponse getAll() throws IOException {
        return CustomResponse.builder()
                .result(s.getAll())
                .build();
    }

    @PreAuthorize("hasRole('ROLE_STAFF')")
    @GetMapping("/delete/{id}")
    public CustomResponse delete(@PathVariable("id") int id) throws IOException {
        return CustomResponse.builder()
                .result(s.delete(id))
                .build();
    }
}
