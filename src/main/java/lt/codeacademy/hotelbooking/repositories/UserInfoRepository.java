package lt.codeacademy.hotelbooking.repositories;

import lt.codeacademy.hotelbooking.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}
