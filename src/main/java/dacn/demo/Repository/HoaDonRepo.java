package dacn.demo.Repository;

import dacn.demo.Entity.HoaDon;
import dacn.demo.Entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonRepo extends JpaRepository<HoaDon,Integer> {
    List<HoaDon> findByKhachHang_Sdt(String sdt);
}
