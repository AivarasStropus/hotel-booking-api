package lt.codeacademy.hotelbooking.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.hotelbooking.converters.ReservationConverter;
import lt.codeacademy.hotelbooking.dto.ReservationDTO;
import lt.codeacademy.hotelbooking.entities.Reservation;
import lt.codeacademy.hotelbooking.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ReservationService {

    private ReservationRepository reservationRepository;

    public List<ReservationDTO> getAllReservations(String checkin, String checkout) {

        List<Reservation> reservations;

        if(checkin != null) {
            reservations = reservationRepository.findAllByCheckin(checkin);
        } else if (checkout != null) {
            reservations = reservationRepository.findAllByCheckout(checkout);
        } else {
            reservations = reservationRepository.findAll();
        }
        return ReservationConverter.convertReservationListToReservationDtoList(reservations);
    }

    public ReservationDTO createReservation(Reservation reservation) {
        reservationRepository.save(reservation);
        return ReservationConverter.convertReservationToReservationDto(reservation);
    }

    public ReservationDTO updateReservation(Reservation reservation) {
        Reservation reservationUpdate = reservationRepository.findById(reservation.getId())
                .orElseThrow(() -> new NoSuchElementException());

        reservationUpdate.setCheckin(reservation.getCheckin());
        reservationUpdate.setCheckout(reservation.getCheckout());
        reservationRepository.save(reservationUpdate);

        return ReservationConverter.convertReservationToReservationDto(reservationUpdate);
    }

    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }
}
