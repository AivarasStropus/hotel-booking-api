package lt.codeacademy.hotelbooking.repositories;

import lt.codeacademy.hotelbooking.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findAllByName(String name);
    List<Hotel> findAllByLocation(String location);
}
