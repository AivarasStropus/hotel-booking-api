package lt.codeacademy.hotelbooking.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.hotelbooking.converters.OwnerInfoConverter;
import lt.codeacademy.hotelbooking.dto.OwnerInfoDTO;
import lt.codeacademy.hotelbooking.entities.OwnerInfo;
import lt.codeacademy.hotelbooking.repositories.OwnerInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class OwnerInfoService {

    private OwnerInfoRepository ownerInfoRepository;

    public List<OwnerInfoDTO> getAllOwners(String name, String lastName) {

        List<OwnerInfo> owners;

        if (name != null) {
            owners = ownerInfoRepository.findAllByName(name);
        } else if (lastName != null) {
            owners = ownerInfoRepository.findAllByLastName(lastName);
        } else {
            owners = ownerInfoRepository.findAll();
        }

        return OwnerInfoConverter.convertOwnerListToOwnerDtoList(owners);
    }

    public OwnerInfoDTO createOwner(OwnerInfo ownerInfo) {
        ownerInfoRepository.save(ownerInfo);
        return OwnerInfoConverter.convertOwnerToOwnerDto(ownerInfo);
    }

    public OwnerInfoDTO updateOwner(OwnerInfo ownerInfo) {
        OwnerInfo ownerInfoUpdate = ownerInfoRepository.findById(ownerInfo.getId())
                .orElseThrow(() -> new NoSuchElementException());

        ownerInfoUpdate.setName(ownerInfo.getName());
        ownerInfoUpdate.setLastName(ownerInfo.getLastName());
        ownerInfoUpdate.setEmail(ownerInfo.getEmail());
        ownerInfoUpdate.setPhoneNumber(ownerInfo.getPhoneNumber());
        ownerInfoRepository.save(ownerInfoUpdate);

        return OwnerInfoConverter.convertOwnerToOwnerDto(ownerInfoUpdate);
    }

    public void deleteOwnerById(Long id) {
        ownerInfoRepository.deleteById(id);
    }
}
