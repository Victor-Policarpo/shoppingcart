package victor.policarpo.shoppingcart.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import victor.policarpo.shoppingcart.dto.request.CreateUser;
import victor.policarpo.shoppingcart.dto.response.UserResponse;
import victor.policarpo.shoppingcart.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody  CreateUser dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(dto));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> listAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.listAllUsers());
    }

}
