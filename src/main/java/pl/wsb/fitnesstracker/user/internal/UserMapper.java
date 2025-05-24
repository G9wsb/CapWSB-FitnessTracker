package pl.wsb.fitnesstracker.user.internal;

import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.user.api.*;

/**
 * The type User mapper.
 */
@Component
class UserMapper {
    /**
     * To dto user dto.
     *
     * @param user the user
     * @return user dto
     */
    UserDto toDto(User user) {
        return new UserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthdate(),
                user.getEmail());
    }

    /**
     * To user name dto user name dto.
     *
     * @param user the user
     * @return user name dto
     */
    UserNameDto toUserNameDto(User user) {
        return new UserNameDto(user.getId(),
                user.getFirstName(),
                user.getLastName());
    }

    /**
     * To details dto user details dto.
     *
     * @param user the user
     * @return the user details dto
     */
    UserDetailsDto toDetailsDto(User user) {
        return new UserDetailsDto(user.getId(),
                user.getEmail(),
                user.getBirthdate().toString());
    }

    /**
     * To user email dto user email dto.
     *
     * @param user the user
     * @return the user email dto
     */
    UserEmailDto toUserEmailDto(User user) {
        return new UserEmailDto(user.getId(),
                user.getEmail());
    }

    /**
     * To entity user.
     *
     * @param userDto the user dto
     * @return the user
     */
    User toEntity(UserDto userDto) {
        return new User(
                userDto.firstName(),
                userDto.lastName(),
                userDto.birthdate(),
                userDto.email());
    }

}
