package lt.codeacademy.hotelbooking.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.hotelbooking.converters.UserInfoConverter;
import lt.codeacademy.hotelbooking.dto.UserInfoDTO;
import lt.codeacademy.hotelbooking.repositories.UserInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserInfoService {

    private UserInfoRepository userInfoRepository;

    public List<UserInfoDTO> getUsers() {
        return UserInfoConverter.convertUserListToUserDtoList(userInfoRepository.findAll());
    }
}
