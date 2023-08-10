package lt.codeacademy.hotelbooking.repositories;

import lt.codeacademy.hotelbooking.dto.RoomDTO;
import lt.codeacademy.hotelbooking.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRespository extends JpaRepository<Room, Long> {

    List<Room> findAllByRoomClass(String roomClass);
    List<Room> findAllByPrice(Double price);
    List<Room> findAllByCapacity(Integer capacity);
    List<Room> findAllByRoomNumber(Integer number);
}
