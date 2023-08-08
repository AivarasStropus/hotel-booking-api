package lt.codeacademy.hotelbooking.controllers;

import lt.codeacademy.hotelbooking.converters.OwnerInfoConverter;
import lt.codeacademy.hotelbooking.dto.OwnerInfoDTO;
import lt.codeacademy.hotelbooking.services.OwnerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ownersInfo")
public class OwnerInfoController {

    @Autowired
    OwnerInfoService ownerInfoService;

    @GetMapping
    public ResponseEntity<List<OwnerInfoDTO>> getAllUsers() {
        return ResponseEntity.ok(ownerInfoService.getAllOwners());
    }

    @PostMapping
    public ResponseEntity<OwnerInfoDTO> createOwner(@RequestBody OwnerInfoDTO ownerInfoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ownerInfoService.createOwner(OwnerInfoConverter.convertOwnerDtoToOwner(ownerInfoDTO)));
    }

    @PutMapping
    public ResponseEntity<OwnerInfoDTO> updateOwner(@RequestBody OwnerInfoDTO ownerInfoDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ownerInfoService.updateOwner(OwnerInfoConverter.convertOwnerDtoToOwner(ownerInfoDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwnerById(@PathVariable Long id) {
        ownerInfoService.deleteOwnerById(id);
        return ResponseEntity.noContent().build();
    }
}
