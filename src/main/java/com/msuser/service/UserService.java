package com.msuser.service;

import com.msuser.client.AuthClient;
import com.msuser.dao.entity.UserEntity;
import com.msuser.dao.repository.UserRepository;
import com.msuser.exception.AlreadyExistException;
import com.msuser.mapper.UserMapper;
import com.msuser.model.enums.UserStatus;
import com.msuser.model.request.UserRequest;
import com.msuser.model.response.UserView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final AuthClient authClient;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public UserView create(final UserRequest userRequest) {
        //todo mail sender send otp and confirm account
        validateUsernameUniqueness(userRequest.getUsername());

        final String encodedPassword = encodePassword(userRequest.getPassword());
        userRequest.setPassword(encodedPassword);

        UserEntity savedUser = saveUser(userRequest);
        log.info("UserEntity created: {}", savedUser);

        return userMapper.toView(savedUser);
    }

    private void validateUsernameUniqueness(String username) {
        boolean exists = userRepository.existsByUsernameAndStatus(username, UserStatus.ACTIVE);
        if (exists) {
            throw AlreadyExistException.of("Username: " + username + " already exists");
        }
    }

    private String encodePassword(String rawPassword) {
        return authClient.createPassword(rawPassword);
    }

    private UserEntity saveUser(UserRequest request) {
        UserEntity entity = userMapper.toEntity(request);
        return userRepository.save(entity);
    }

}
