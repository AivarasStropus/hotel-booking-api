package lt.codeacademy.hotelbooking.repositories;

import lt.codeacademy.hotelbooking.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
