package victor.policarpo.shoppingcart.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import victor.policarpo.shoppingcart.dto.request.CreateUser;
import victor.policarpo.shoppingcart.dto.response.UserResponse;
import victor.policarpo.shoppingcart.entity.User;
import victor.policarpo.shoppingcart.exception.ResourceAlreadyExistsException;
import victor.policarpo.shoppingcart.mapper.UserMapper;
import victor.policarpo.shoppingcart.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public UserResponse createUser(CreateUser dto){
        if (userRepository.existsByName(dto.name())) {
            throw new ResourceAlreadyExistsException("A User with this name already exists.");
        }
        User user = userRepository.save(userMapper.toEntity(dto));
        return userMapper.toUserResponse(user);
    }

    public List<UserResponse> listAllUsers() {
        return userMapper.toListResponseDto(userRepository.findAll());
    }

}
