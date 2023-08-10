package lt.codeacademy.hotelbooking.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.hotelbooking.converters.HotelConverter;
import lt.codeacademy.hotelbooking.dto.HotelDTO;
import lt.codeacademy.hotelbooking.entities.Hotel;
import lt.codeacademy.hotelbooking.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class HotelService {

    private HotelRepository hotelRepository;

    public List<HotelDTO> getAllHotels(String name, String location) {

        List<Hotel> hotels;

        if(name != null) {
            hotels = hotelRepository.findAllByName(name);
        } else if (location != null) {
            hotels = hotelRepository.findAllByLocation(location);
        } else {
            hotels = hotelRepository.findAll();
        }

        return HotelConverter.convertHotelListToHotelDtoList(hotels);
    }

    public HotelDTO createHotel(Hotel hotel) {
        hotelRepository.save(hotel);
        return HotelConverter.convertHotelToHotelDto(hotel);
    }

    public HotelDTO updateHotel(Hotel hotel) {
        Hotel hotelUpdate = hotelRepository.findById(hotel.getId())
                .orElseThrow(() -> new NoSuchElementException());

        hotelUpdate.setName(hotel.getName());
        hotelUpdate.setLocation(hotel.getLocation());
        hotelRepository.save(hotelUpdate);

        return HotelConverter.convertHotelToHotelDto(hotelUpdate);
    }

    public void deleteByHotelId(Long id) {
        hotelRepository.deleteById(id);
    }

}
