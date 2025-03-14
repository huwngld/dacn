package dacn.demo.Repository;

import dacn.demo.Entity.KhachHang;
import dacn.demo.Entity.NhaXuatBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaXuatBanRepo extends JpaRepository<NhaXuatBan,Integer> {
}
