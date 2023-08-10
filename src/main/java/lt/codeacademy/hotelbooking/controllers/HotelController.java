package lt.codeacademy.hotelbooking.controllers;

import lt.codeacademy.hotelbooking.converters.HotelConverter;
import lt.codeacademy.hotelbooking.dto.HotelDTO;
import lt.codeacademy.hotelbooking.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<HotelDTO>> getAllHotels(@RequestParam(name = "hotelName", required = false) String hotelName,
                                                       @RequestParam(name = "location", required = false) String location) {
        return ResponseEntity.ok(hotelService.getAllHotels(hotelName, location));
    }

    @PostMapping
    public ResponseEntity<HotelDTO> createHotel(@RequestBody HotelDTO hotelDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(hotelService.createHotel(HotelConverter.convertHotelDtoToHotel(hotelDTO)));
    }

    @PutMapping
    public ResponseEntity<HotelDTO> updateHotel(@RequestBody HotelDTO hotelDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(hotelService.updateHotel(HotelConverter.convertHotelDtoToHotel(hotelDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotelById(@PathVariable Long id) {
        hotelService.deleteByHotelId(id);
        return ResponseEntity.noContent().build();
    }


}
