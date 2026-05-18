package io.github.carloscardoso05.bidflow.service;

import io.github.carloscardoso05.bidflow.dto.CreateUserRequest;
import io.github.carloscardoso05.bidflow.dto.UserResponse;
import io.github.carloscardoso05.bidflow.entity.User;
import io.github.carloscardoso05.bidflow.exception.BusinessException;
import io.github.carloscardoso05.bidflow.exception.EntityNotFoundException;
import io.github.carloscardoso05.bidflow.mapper.UserMapper;
import io.github.carloscardoso05.bidflow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

@Service
@NullMarked
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public Page<UserResponse> list(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toDto);
    }

    public UserResponse findByEmail(String email) {
        var user = findUserEntityByEmail(email);
        return userMapper.toDto(user);
    }

    @Transactional
    public UserResponse create(CreateUserRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new BusinessException("User with this email already exists");
        }
        var user = userMapper.toEntity(request);
        var passwordHash = requireNonNull(passwordEncoder.encode(request.password()));
        user.setPasswordHash(passwordHash);
        return userMapper.toDto(userRepository.save(user));
    }

    public User findUserEntityByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(userNotFound(email));
    }

    private Supplier<EntityNotFoundException> userNotFound(String email) {
        return () -> new EntityNotFoundException(User.class, "email", email);
    }
}
