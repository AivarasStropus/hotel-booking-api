package lt.codeacademy.hotelbooking.repositories;

import lt.codeacademy.hotelbooking.entities.OwnerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerInfoRepository extends JpaRepository<OwnerInfo, Long> {

    List<OwnerInfo> findAllByName(String name);
    List<OwnerInfo> findAllByLastName(String lastName);
}
