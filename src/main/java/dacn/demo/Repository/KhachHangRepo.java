package dacn.demo.Repository;

import dacn.demo.Entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang,Integer> {
    KhachHang findKhachHangByTaiKhoan(String data);
}
