package hr.sandelic.waxapp.user;


import hr.sandelic.waxapp.security.SecurityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/current-user")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<UserDTO> getCurretUser() {
        return SecurityUtils.getCurrentUserUsername()
                .map(
                        username -> userService.findOneByUsername(username)
                                .map(ResponseEntity::ok)
                                .orElseGet(
                                        ()-> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build()
                                )
                )
                .orElseGet(
                        () -> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build()
                );
    }








}
