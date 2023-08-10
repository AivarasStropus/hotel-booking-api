package lt.codeacademy.hotelbooking.controllers;

import lt.codeacademy.hotelbooking.converters.ReservationConverter;
import lt.codeacademy.hotelbooking.dto.ReservationDTO;
import lt.codeacademy.hotelbooking.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAllReservations(@RequestParam(name = "checkin", required = false) String checkin,
                                                                   @RequestParam(name = "checkout", required = false) String checkout){
        return ResponseEntity.ok(reservationService.getAllReservations(checkin, checkout));
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservationService.createReservation(ReservationConverter.convertReservationDtoToReservation(reservationDTO)));
    }

    @PutMapping
    public ResponseEntity<ReservationDTO> updateReservation(@RequestBody ReservationDTO reservationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservationService.updateReservation(ReservationConverter.convertReservationDtoToReservation(reservationDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservationById(@PathVariable Long id) {
        reservationService.deleteReservationById(id);
        return ResponseEntity.noContent().build();
    }
}
