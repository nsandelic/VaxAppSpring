package hr.sandelic.waxapp.user;

import java.util.Optional;

public interface UserService {

    Optional<UserDTO> findOneByUsername(String username);

}
