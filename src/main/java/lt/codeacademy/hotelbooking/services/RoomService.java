package lt.codeacademy.hotelbooking.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.hotelbooking.converters.RoomConverter;
import lt.codeacademy.hotelbooking.dto.RoomDTO;
import lt.codeacademy.hotelbooking.entities.Room;
import lt.codeacademy.hotelbooking.repositories.RoomRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class RoomService {

    private RoomRespository roomRespository;

    public List<RoomDTO> getAllRooms() {
        return RoomConverter.convertRoomListToRoomDtoList(roomRespository.findAll());
    }

    public RoomDTO createRoom(Room room) {
        roomRespository.save(room);
        return RoomConverter.convertRoomToRoomDto(room);
    }

    public RoomDTO updateRoom(Room room) {
        Room roomUpdate = roomRespository.findById(room.getId())
                .orElseThrow(() -> new NoSuchElementException());

        roomUpdate.setCapacity(room.getCapacity());
        roomUpdate.setRoomNumber(room.getRoomNumber());
        roomUpdate.setPrice(room.getPrice());
        roomUpdate.setRoomClass(room.getRoomClass());
        roomRespository.save(roomUpdate);

        return RoomConverter.convertRoomToRoomDto(roomUpdate);
    }

    public void deleteRoomById(Long id) {
        roomRespository.deleteById(id);
    }
}
