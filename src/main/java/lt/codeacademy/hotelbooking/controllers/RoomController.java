package lt.codeacademy.hotelbooking.controllers;

import lt.codeacademy.hotelbooking.converters.RoomConverter;
import lt.codeacademy.hotelbooking.dto.RoomDTO;
import lt.codeacademy.hotelbooking.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping
    public ResponseEntity<List<RoomDTO>> getAllRooms(@RequestParam(name = "roomClass", required = false) String roomClass,
                                                     @RequestParam(name = "price", required = false) Double price,
                                                     @RequestParam(name = "capacity", required = false) Integer capacity,
                                                     @RequestParam(name = "roomNumber", required = false) Integer number) {
        return ResponseEntity.ok(roomService.getAllRooms(roomClass, price, capacity, number));
    }

    @PostMapping
    public ResponseEntity<RoomDTO> createRoom(@RequestBody RoomDTO roomDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(roomService.createRoom(RoomConverter.convertRoomDtoToRoom(roomDTO)));
    }

    @PutMapping
    public ResponseEntity<RoomDTO> updateRoom(@RequestBody RoomDTO roomDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(roomService.updateRoom(RoomConverter.convertRoomDtoToRoom(roomDTO)));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteRoomById(@PathVariable Long id) {
        roomService.deleteRoomById(id);
        return ResponseEntity.noContent().build();
    }
}
