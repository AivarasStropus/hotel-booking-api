package lt.codeacademy.hotelbooking.converters;

import lt.codeacademy.hotelbooking.dto.UserInfoDTO;
import lt.codeacademy.hotelbooking.entities.UserInfo;

import java.util.ArrayList;
import java.util.List;

public abstract class UserInfoConverter {

    public static UserInfo convertUserDtoToUser(UserInfoDTO userInfoDTO) {
        UserInfo userInfo = null;
        if(userInfoDTO != null) {
            userInfo = new UserInfo();
            userInfo.setName(userInfoDTO.getName());
            userInfo.setLastName(userInfoDTO.getLastName());
            userInfo.setEmail(userInfoDTO.getEmail());
        }

        return userInfo;
    }
    public static UserInfoDTO convertUserToUserDto(UserInfo userInfo) {
        UserInfoDTO userInfoDto = null;
        if (userInfo != null) {
            userInfoDto = new UserInfoDTO();
            userInfoDto.setName(userInfo.getName());
            userInfoDto.setLastName(userInfo.getLastName());
            userInfoDto.setEmail(userInfo.getEmail());
        }

        return userInfoDto;
    }

    public static List<UserInfoDTO> convertUserListToUserDtoList(List<UserInfo> usersList) {
        List<UserInfoDTO> userInfoDtoList = null;
        if (usersList != null && !usersList.isEmpty()) {
            userInfoDtoList = new ArrayList<>();
            for (UserInfo u : usersList) {
                userInfoDtoList.add(convertUserToUserDto(u));
            }
        }
        return userInfoDtoList;
    }
}
