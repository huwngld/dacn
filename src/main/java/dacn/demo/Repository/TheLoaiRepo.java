package dacn.demo.Repository;

import dacn.demo.Entity.KhachHang;
import dacn.demo.Entity.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheLoaiRepo extends JpaRepository<TheLoai,Integer> {
}
