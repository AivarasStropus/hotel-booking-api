package lt.codeacademy.hotelbooking.converters;

import lt.codeacademy.hotelbooking.dto.OwnerInfoDTO;
import lt.codeacademy.hotelbooking.entities.OwnerInfo;

import java.util.ArrayList;
import java.util.List;

public abstract class OwnerInfoConverter {

    public static OwnerInfo convertOwnerDtoToOwner(OwnerInfoDTO ownerInfoDTO) {
        OwnerInfo ownerInfo = null;
        if (ownerInfoDTO != null) {
            ownerInfo = new OwnerInfo();
            ownerInfo.setId(ownerInfoDTO.getId());
            ownerInfo.setName(ownerInfoDTO.getName());
            ownerInfo.setLastName(ownerInfoDTO.getLastName());
            ownerInfo.setEmail(ownerInfoDTO.getEmail());
            ownerInfo.setPhoneNumber(ownerInfoDTO.getPhoneNumber());
        }

        return ownerInfo;
    }

    public static OwnerInfoDTO convertOwnerToOwnerDto(OwnerInfo ownerInfo) {
        OwnerInfoDTO ownerInfoDTO = null;
        if (ownerInfo != null) {
            ownerInfoDTO = new OwnerInfoDTO();
            ownerInfoDTO.setId(ownerInfo.getId());
            ownerInfoDTO.setName(ownerInfo.getName());
            ownerInfoDTO.setLastName(ownerInfo.getLastName());
            ownerInfoDTO.setEmail(ownerInfo.getEmail());
            ownerInfoDTO.setPhoneNumber(ownerInfo.getPhoneNumber());
        }

        return ownerInfoDTO;
    }

    public static List<OwnerInfoDTO> convertOwnerListToOwnerDtoList(List<OwnerInfo> ownerList) {
        List<OwnerInfoDTO> ownerInfoDTOList = null;
        if(ownerList != null && !ownerList.isEmpty()) {
            ownerInfoDTOList = new ArrayList<>();
            for (OwnerInfo u : ownerList) {
                ownerInfoDTOList.add(convertOwnerToOwnerDto(u));
            }
        }

        return ownerInfoDTOList;
    }
}
