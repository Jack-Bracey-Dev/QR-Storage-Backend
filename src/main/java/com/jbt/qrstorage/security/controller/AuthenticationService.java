package com.jbt.qrstorage.security.controller;

import com.jbt.qrstorage.common.configuration.security.data.ISecurityConfigService;
import com.jbt.qrstorage.common.configuration.security.jwt.JwtUtils;
import com.jbt.qrstorage.common.dto.AuthUserDto;
import com.jbt.qrstorage.common.entity.AuthUser;
import com.jbt.qrstorage.common.mappers.UserMapper;
import com.jbt.qrstorage.security.dto.NewRefreshTokenBodyDto;
import com.jbt.qrstorage.security.dto.RegistrationBodyDto;
import com.jbt.qrstorage.security.dto.UserLoginBodyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
@Service
public class AuthenticationService implements IAuthenticationService {

    private final IAuthenticationRepository authenticationRepository;

    private final ISecurityConfigService securityConfigService;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtils jwtUtils;

    @Override
    public Mono<AuthUserDto> registerNewUser(RegistrationBodyDto registrationBodyDto) {
        AuthUser user = UserMapper.mapToAuthUser(registrationBodyDto, passwordEncoder);

        return authenticationRepository.registerNewUser(user)
                .map(UserMapper::mapToAuthUserDto);
    }

    @Override
    public Mono<String> loginUser(UserLoginBodyDto body) {
        return authenticationRepository.findUserByEmail(body.getEmail())
                .switchIfEmpty(Mono.error(new Exception("User not found")))
                .flatMap(authUser -> {
                    if (passwordEncoder.matches(body.getPassword(), authUser.getPassword())) {
                        return Mono.just(jwtUtils.generateTokenFromEmail(authUser.getEmail()));
                    }

                    return Mono.just("Incorrect password");
                });
    }

    @Override
    public Mono<String> generateNewRefreshToken(NewRefreshTokenBodyDto body) {
        return Mono.just(jwtUtils.getEmailFromJwtToken(body.getToken()));
    }

}
