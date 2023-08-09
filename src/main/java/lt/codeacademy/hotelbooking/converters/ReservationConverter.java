package lt.codeacademy.hotelbooking.converters;

import lt.codeacademy.hotelbooking.dto.ReservationDTO;
import lt.codeacademy.hotelbooking.entities.Reservation;

import java.util.List;

public abstract class ReservationConverter {

    public static Reservation convertReservationDtoToReservation(ReservationDTO reservationDTO) {
        Reservation reservation= null;
        if(reservationDTO != null) {
            reservation = new Reservation();
            reservation.setId(reservationDTO.getId());
            reservation.setCheckin(reservationDTO.getCheckin());
            reservation.setCheckout(reservationDTO.getCheckout());
        }

        return reservation;
    }

    public static ReservationDTO convertReservationToReservationDto(Reservation reservation) {
        ReservationDTO reservationDTO = null;
        if(reservation != null) {
            reservationDTO = new ReservationDTO();
            reservationDTO.setId(reservation.getId());
            reservationDTO.setCheckin(reservation.getCheckin());
            reservationDTO.setCheckout(reservation.getCheckout());
        }

        return reservationDTO;
    }

    public static List<ReservationDTO> convertReservationListToReservationDtoList(List<Reservation> reservationList) {
        List<ReservationDTO> reservationDTOList = null;
        if(reservationList != null && !reservationList.isEmpty()) {
            for (Reservation u : reservationList) {
                reservationDTOList.add(convertReservationToReservationDto(u));
            }
        }

        return reservationDTOList;
    }
}
