package pl.wsb.fitnesstracker.training.internal;

import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.training.api.TrainingUserDto;
import pl.wsb.fitnesstracker.user.api.*;

/**
 * The type Training user mapper.
 */
@Component
class TrainingUserMapper {

    /**
     * To dto training user dto.
     *
     * @param user the user
     * @return the training user dto
     */
    TrainingUserDto toDto(User user) {
        return new TrainingUserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthdate(),
                user.getEmail());
    }

    /**
     * To dto training user dto.
     *
     * @param userDto the user dto
     * @return the training user dto
     */
    public TrainingUserDto toDto(UserDto userDto) {
        return new TrainingUserDto(userDto.id(),
                userDto.firstName(),
                userDto.lastName(),
                userDto.birthdate(),
                userDto.email());
    }
}
