package dacn.demo.Mapper;

import dacn.demo.DTO.Request.HoaDonRequest;
import dacn.demo.DTO.Request.RegisterRequest;
import dacn.demo.DTO.Request.SachRequest;
import dacn.demo.Entity.HoaDon;
import dacn.demo.Entity.KhachHang;
import dacn.demo.Entity.Sach;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface mapper {
    RegisterRequest toRegisterRequest(KhachHang data);

    KhachHang toKhachHang(RegisterRequest data);

    Sach toSach(SachRequest data);

    HoaDon toHoaDon(HoaDonRequest data);
}
