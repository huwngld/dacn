package dacn.demo.Repository;

import dacn.demo.Entity.KhachHang;
import dacn.demo.Entity.Sach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SachRepo extends JpaRepository<Sach,Integer> {

    Sach findSachByMaSach(int id);
}
