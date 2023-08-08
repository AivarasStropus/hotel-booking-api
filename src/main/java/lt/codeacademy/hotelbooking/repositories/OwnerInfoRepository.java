package lt.codeacademy.hotelbooking.repositories;

import lt.codeacademy.hotelbooking.entities.OwnerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerInfoRepository extends JpaRepository<OwnerInfo, Long> {
}
