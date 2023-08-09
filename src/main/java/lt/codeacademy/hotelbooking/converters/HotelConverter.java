package lt.codeacademy.hotelbooking.converters;

import lt.codeacademy.hotelbooking.dto.HotelDTO;
import lt.codeacademy.hotelbooking.entities.Hotel;

import java.util.ArrayList;
import java.util.List;

public abstract class HotelConverter {

    public static Hotel convertHotelDtoToHotel(HotelDTO hotelDTO) {
        Hotel hotel = null;
        if (hotelDTO != null) {
            hotel = new Hotel();
            hotel.setId(hotelDTO.getId());
            hotel.setName(hotelDTO.getName());
            hotel.setLocation(hotelDTO.getLocation());
        }

        return hotel;
    }

    public static HotelDTO convertHotelToHotelDto(Hotel hotel) {
        HotelDTO hotelDTO = null;
        if(hotel != null) {
            hotelDTO = new HotelDTO();
            hotelDTO.setId(hotel.getId());
            hotelDTO.setName(hotel.getName());
            hotelDTO.setLocation(hotel.getLocation());
        }

        return hotelDTO;
    }

    public static List<HotelDTO> convertHotelListToHotelDtoList (List<Hotel> hotelList) {
        List<HotelDTO> hotelDTOList = null;
        if(hotelList != null && !hotelList.isEmpty()) {
            hotelDTOList = new ArrayList<>();
            for (Hotel u : hotelList) {
                hotelDTOList.add(convertHotelToHotelDto(u));
            }
        }

        return hotelDTOList;
    }
}
