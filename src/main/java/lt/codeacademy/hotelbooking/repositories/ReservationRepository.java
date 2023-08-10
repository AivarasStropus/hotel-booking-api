package lt.codeacademy.hotelbooking.repositories;

import lt.codeacademy.hotelbooking.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByCheckin(String checkin);
    List<Reservation> findAllByCheckout(String checkout);
}
