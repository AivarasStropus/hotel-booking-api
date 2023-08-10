package lt.codeacademy.hotelbooking.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.hotelbooking.converters.UserInfoConverter;
import lt.codeacademy.hotelbooking.dto.UserInfoDTO;
import lt.codeacademy.hotelbooking.entities.UserInfo;
import lt.codeacademy.hotelbooking.repositories.UserInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserInfoService {

    private UserInfoRepository userInfoRepository;

    public List<UserInfoDTO> getAllUsers(String name, String lastName) {

        List<UserInfo> users;

        if(name != null) {
            users = userInfoRepository.findAllByName(name);
        } else if (lastName != null) {
            users = userInfoRepository.findAllByLastName(lastName);
        } else {
            users = userInfoRepository.findAll();
        }

        return UserInfoConverter.convertUserListToUserDtoList(users);
    }

    public UserInfoDTO createUser(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
        return UserInfoConverter.convertUserToUserDto(userInfo);
    }

    public UserInfoDTO updateUser(UserInfo userInfo) {
        UserInfo userInfoUpdate = userInfoRepository.findById(userInfo.getId())
                .orElseThrow(() -> new NoSuchElementException());

        userInfoUpdate.setName(userInfo.getName());
        userInfoUpdate.setLastName(userInfo.getLastName());
        userInfoUpdate.setEmail(userInfo.getEmail());
        userInfoRepository.save(userInfoUpdate);

        return UserInfoConverter.convertUserToUserDto(userInfoUpdate);
    }

    public void deleteUserById(Long id) {
        userInfoRepository.deleteById(id);
    }
}
