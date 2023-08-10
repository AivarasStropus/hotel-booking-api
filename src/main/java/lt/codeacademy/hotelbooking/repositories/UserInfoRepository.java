package lt.codeacademy.hotelbooking.repositories;

import lt.codeacademy.hotelbooking.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    List<UserInfo> findAllByName(String name);
    List<UserInfo> findAllByLastName(String lastName);
}
