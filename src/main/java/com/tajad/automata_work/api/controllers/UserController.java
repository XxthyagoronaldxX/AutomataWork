package com.tajad.automata_work.api.controllers;

import com.tajad.automata_work.domain.dtos.UserDTO;
import com.tajad.automata_work.domain.entities.UserEntity;
import com.tajad.automata_work.domain.services.IUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UserDTO userDTO) {
        final List<UserEntity> userEntities = this.userService.create(userDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(userEntities);
    }
}
