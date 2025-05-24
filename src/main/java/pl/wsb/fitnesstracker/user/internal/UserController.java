package pl.wsb.fitnesstracker.user.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.training.internal.TrainingExternalService;
import pl.wsb.fitnesstracker.training.internal.TrainingExternalServiceImpl;
import pl.wsb.fitnesstracker.user.api.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    private final UserMapper userMapper;

    private final TrainingExternalServiceImpl trainingExternalService;

    /**
     * Gets all users.
     *
     * @return the all users
     */
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    /**
     * Gets user names.
     *
     * @return the user names
     */
    @GetMapping("/simple")
    public List<UserNameDto> getUserNames() {
        return userService.findAllUsers()
                .stream()
                .map(userMapper::toUserNameDto)
                .toList();
    }

    /**
     * Gets user details.
     *
     * @return the user details
     */
    @GetMapping("/details")
    public List<UserDetailsDto> getUserDetails() {
        return userService.findAllUsers()
                .stream()
                .map(userMapper::toDetailsDto)
                .toList();
    }

    /**
     * Gets user by id.
     *
     * @param id the id
     * @return the user by id
     */
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        Optional<User> userOptional= userService.getUser(id);
        if(userOptional.isPresent()){
            return userMapper.toDto(userOptional.get());
        }
        return null;
    }

    /**
     * Add user user dto.
     *
     * @param userDto the user dto
     * @return the user dto
     * @throws InterruptedException the interrupted exception
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addUser(@RequestBody UserDto userDto) throws InterruptedException {
        User createdUser = userService.createUser(userMapper.toEntity(userDto));

        return userMapper.toDto(createdUser);
    }

    /**
     * Delete user.
     *
     * @param userId the user id
     * @throws InterruptedException the interrupted exception
     */
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long userId) throws InterruptedException {
        trainingExternalService.deleteTrainingsByUserId(userId);
        userService.deleteUserById(userId);
    }

    /**
     * Find by email list.
     *
     * @param email the email
     * @return the list
     */
    @GetMapping("/email")
    public List<UserEmailDto> findByEmail(@RequestParam String email) {
        return userService.findAllUsers()
                .stream()
                .map(userMapper::toUserEmailDto)
                .filter(userEmailDto -> userEmailDto.email().toLowerCase().contains(email.toLowerCase()))
                .toList();
    }

    /**
     * Find by email list.
     *
     * @param time the time
     * @return the list
     */
    @GetMapping("/older/{time}")
    public List<UserDto> findByEmail(@PathVariable LocalDate time) {
        return userService.findAllUsers()
                .stream()
                .map(userMapper::toDto)
                .filter(userDto -> userDto.birthdate().isBefore(time))
                .toList();
    }

    /**
     * Update user.
     *
     * @param userId  the user id
     * @param userDto the user dto
     */
    @PutMapping("/{userId}")
    public void updateUser(@PathVariable Long userId, @RequestBody UserDto userDto) {
        UserDto user = new UserDto(userId, userDto.firstName(), userDto.lastName(), userDto.birthdate(), userDto.email());
        userService.updateUser(user);
    }



}