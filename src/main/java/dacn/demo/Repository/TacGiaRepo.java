package dacn.demo.Repository;

import dacn.demo.Entity.KhachHang;
import dacn.demo.Entity.TacGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacGiaRepo extends JpaRepository<TacGia,Integer> {
}
