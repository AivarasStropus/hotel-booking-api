package lt.codeacademy.hotelbooking.converters;

import lt.codeacademy.hotelbooking.dto.RoomDTO;
import lt.codeacademy.hotelbooking.entities.Room;

import java.util.ArrayList;
import java.util.List;

public abstract class RoomConverter {

    public static Room convertRoomDtoToRoom(RoomDTO roomDTO) {
        Room room = null;
        if (roomDTO != null) {
            room =new Room();
            room.setId(roomDTO.getId());
            room.setCapacity(roomDTO.getCapacity());
            room.setRoomNumber(roomDTO.getRoomNumber());
            room.setPrice(roomDTO.getPrice());
            room.setRoomClass(roomDTO.getRoomClass());
        }

        return room;
    }

    public static RoomDTO convertRoomToRoomDto(Room room) {
        RoomDTO roomDTO = null;
        if (room != null) {
            roomDTO = new RoomDTO();
            roomDTO.setId(room.getId());
            roomDTO.setCapacity(room.getCapacity());
            roomDTO.setRoomNumber(room.getRoomNumber());
            roomDTO.setPrice(room.getPrice());
            roomDTO.setRoomClass(room.getRoomClass());
        }

        return roomDTO;
    }

    public static List<RoomDTO> convertRoomListToRoomDtoList(List<Room> roomList) {
        List<RoomDTO> roomDTOList = null;
        if(roomList != null && !roomList.isEmpty()) {
            roomDTOList = new ArrayList<>();
            for (Room u : roomList) {
                roomDTOList.add(convertRoomToRoomDto(u));
            }
        }

        return roomDTOList;
    }
}
