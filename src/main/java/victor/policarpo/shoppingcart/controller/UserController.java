package victor.policarpo.shoppingcart.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import victor.policarpo.shoppingcart.dto.request.CreateUserRequest;
import victor.policarpo.shoppingcart.dto.response.UserResponse;
import victor.policarpo.shoppingcart.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(CreateUserRequest dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(dto));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> listAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.listAllUsers());
    }

}
