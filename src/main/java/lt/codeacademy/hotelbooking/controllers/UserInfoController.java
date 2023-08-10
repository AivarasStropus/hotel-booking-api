package lt.codeacademy.hotelbooking.controllers;

import lt.codeacademy.hotelbooking.converters.UserInfoConverter;
import lt.codeacademy.hotelbooking.dto.UserInfoDTO;
import lt.codeacademy.hotelbooking.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usersInfo")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @GetMapping
    public ResponseEntity<List<UserInfoDTO>> getAllUsers(@RequestParam(name = "name", required = false) String name,
                                                         @RequestParam(name = "lastName", required = false) String lastName) {
        return ResponseEntity.ok(userInfoService.getAllUsers(name, lastName));
    }

    @PostMapping
    public ResponseEntity<UserInfoDTO> createUser(@RequestBody UserInfoDTO userInfoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userInfoService.createUser(UserInfoConverter.convertUserDtoToUser(userInfoDTO)));
    }

    @PutMapping
    public ResponseEntity<UserInfoDTO> updateUser(@RequestBody UserInfoDTO userInfoDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userInfoService.updateUser(UserInfoConverter.convertUserDtoToUser(userInfoDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userInfoService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
