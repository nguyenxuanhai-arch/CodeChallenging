package com.codechallenge.user.user_service.controller;

import com.codechallenge.user.user_service.dto.UserDTO;
import com.codechallenge.user.user_service.dto.UserUpdateRequest;
import com.codechallenge.user.user_service.dto.SubmissionHistoryDTO;
import com.codechallenge.user.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserUpdateRequest request) {
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    @GetMapping("/{id}/submissions")
    public ResponseEntity<List<SubmissionHistoryDTO>> getSubmissionHistory(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getSubmissionHistory(id));
    }
} 