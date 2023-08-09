package lt.codeacademy.hotelbooking.repositories;

import lt.codeacademy.hotelbooking.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
