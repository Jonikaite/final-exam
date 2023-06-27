package lt.techin.vtmc.orderapi.mapper;

import lt.techin.vtmc.orderapi.user.User;
import lt.techin.vtmc.orderapi.user.UserDto;

public interface UserMapper {

    UserDto toUserDto(User user);
}