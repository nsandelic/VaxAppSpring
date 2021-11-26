package hr.sandelic.waxapp.user;


import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<UserDTO> findOneByUsername(String username) {
        return userRepository.findOneByUsername(username).map(this::mapUserToDTO);
    }

    private UserDTO mapUserToDTO(final User user){

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setFirst_name(user.getFirstName());
        userDTO.setLast_name(user.getLastName());
        userDTO.setAuthorities(user.getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet()));

        return userDTO;
    }

}
