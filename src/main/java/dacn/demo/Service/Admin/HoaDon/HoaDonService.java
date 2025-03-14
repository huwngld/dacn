package dacn.demo.Service.Admin.HoaDon;

import dacn.demo.DTO.Request.HoaDonDTO;
import dacn.demo.DTO.Request.HoaDonRequest;
import dacn.demo.Entity.ChiTietHoaDon;
import dacn.demo.Entity.HoaDon;
import dacn.demo.Entity.KhachHang;
import dacn.demo.Entity.Sach;
import dacn.demo.Mapper.mapper;
import dacn.demo.Repository.ChiTietHoaDonRepo;
import dacn.demo.Repository.HoaDonRepo;
import dacn.demo.Repository.KhachHangRepo;
import dacn.demo.Repository.SachRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class HoaDonService {
    RedisTemplate redisTemplate;
    HoaDonRepo hoaDon;
    KhachHangRepo kh;
    ChiTietHoaDonRepo cthd;
    SachRepo s;
    mapper map;
    public boolean add(HoaDonDTO data){
        KhachHang newkh = null;
        if (data.getTaiKhoan()==""){
            newkh = kh.save(KhachHang.builder()
                    .tenKhachHang(data.getTenKhachHang())
                    .sdt(data.getSdt())
                    .diaChi(data.getDiaChi())
                    .build());
        }else{
            newkh = kh.findKhachHangByTaiKhoan(data.getTaiKhoan());
        }
        HoaDon newHoaDon = hoaDon.save(HoaDon.builder()
                .khachHang(newkh)
                .tongTien(data.getTongTien())
                .trangThai(data.getTrangThai())
                .build());
        for (int i = 0;i<data.getItems().size();i++){
            Sach sa = s.findSachByMaSach(data.getItems().get(i).getMaSach());
            sa.setSoLuongTon(sa.getSoLuongTon()-data.getItems().get(i).getSoLuong());
            ChiTietHoaDon newCthd = cthd.save(ChiTietHoaDon.builder()
                    .hoaDon(newHoaDon)
                    .soLuong(data.getItems().get(i).getSoLuong())
                    .donGia(data.getItems().get(i).getGia())
                    .sach(s.findSachByMaSach(data.getItems().get(i).getMaSach()))
                    .build());

        }
        return true;
    }
    public List<HoaDon> getAll(){
        return hoaDon.findAll();
    }
}
