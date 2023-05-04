package com.tajad.automata_work.domain.services.impl;

import com.tajad.automata_work.domain.dtos.UserDTO;
import com.tajad.automata_work.domain.entities.UserEntity;
import com.tajad.automata_work.domain.repositories.IUserRepository;
import com.tajad.automata_work.domain.services.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> create(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        TemporalAccessor temporalAccessor = formatter.parse(userDTO.getDate());
        LocalDateTime localDateTime = LocalDateTime.from(temporalAccessor);
        Timestamp timestamp = Timestamp.valueOf(localDateTime.minusHours(3));

        double randomValue = Double.parseDouble(userDTO.getRandomValue());

        BeanUtils.copyProperties(userDTO, userEntity, "date", "randomValue");
        userEntity.setDate(timestamp);
        userEntity.setRandomValue(randomValue);

        this.userRepository.save(userEntity);

        return this.userRepository.findAll();
    }
}
