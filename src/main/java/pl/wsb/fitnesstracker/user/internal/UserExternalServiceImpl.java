package pl.wsb.fitnesstracker.user.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wsb.fitnesstracker.user.api.User;

import java.util.Optional;

/**
 * The type User external service.
 */
@Service
@RequiredArgsConstructor
public class UserExternalServiceImpl implements UserExternalService{

    private final UserServiceImpl userService;

    @Override
    public Optional<User> getUserById(Long userId) {
        return userService.getUser(userId);
    }
}
