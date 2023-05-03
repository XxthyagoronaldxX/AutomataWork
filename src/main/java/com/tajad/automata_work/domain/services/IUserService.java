package com.tajad.automata_work.domain.services;

import com.tajad.automata_work.domain.dtos.UserDTO;
import com.tajad.automata_work.domain.entities.UserEntity;

import java.util.List;

public interface IUserService {
    List<UserEntity> create(UserDTO userDTO);
}
