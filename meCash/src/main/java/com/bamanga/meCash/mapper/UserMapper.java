package com.bamanga.meCash.mapper;

import com.bamanga.meCash.dto.UserDto;
import com.bamanga.meCash.entity.User;

public class UserMapper
{
    public static User mapToUser (UserDto userDto)
    {
        User user = new User
                (
                        userDto.getId(),
                        userDto.getAccountHolderName(),
                        userDto.getEmail(),
                        userDto.getPassword()
                );
        return user;
    }

    public static UserDto mapToUserDto (User user)
    {
        UserDto userDto = new UserDto
                (
                        user.getId(),
                        user.getAccountHolderName(),
                        user.getEmail(),
                        user.getPassword()
                );
        return userDto;
    }
}
