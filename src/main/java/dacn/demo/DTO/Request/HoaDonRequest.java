package dacn.demo.DTO.Request;

import dacn.demo.Entity.ChiTietHoaDon;
import dacn.demo.Entity.KhachHang;
import dacn.demo.Entity.NhanVien;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class HoaDonRequest implements Serializable {
    private String maHoaDon;
    private NhanVien nhanVien;
    private KhachHang khachHang;
    private Date ngayLap;
    private double tongTien;
    private String trangThai;
    private List<ChiTietHoaDon> chiTietHoaDon;
}
