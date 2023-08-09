package lt.codeacademy.hotelbooking.repositories;

import lt.codeacademy.hotelbooking.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRespository extends JpaRepository<Room, Long> {
}
