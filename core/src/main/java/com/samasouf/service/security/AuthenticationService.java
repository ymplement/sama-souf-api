package com.samasouf.service.security;

import java.util.Set;
import java.util.stream.Collectors;
import com.samasouf.service.security.UserDetailsServiceImpl.UserPrincipal;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samasouf.config.security.JwtTokenUtil;
import com.samasouf.domain.User;
import com.samasouf.domain.security.RefreshToken;
import com.samasouf.dto.RoleDTO;
import com.samasouf.dto.UserDTO;
import com.samasouf.dto.request.LoginRequest;
import com.samasouf.dto.request.RefreshTokenRequest;
import com.samasouf.dto.response.JwtResponse;
import com.samasouf.dto.response.UserInfoResponse;
import com.samasouf.exception.UnauthorizedException;
import com.samasouf.mapper.IRoleMapper;
import com.samasouf.mapper.IUserMapper;
import com.samasouf.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationService {

        private final AuthenticationManager authenticationManager;
        private final UserRepository userRepository;
        private final JwtTokenUtil jwtTokenUtil;
        private final RefreshTokenService refreshTokenService;
        private final IUserMapper userMapper;
        private final IRoleMapper roleMapper;

        @Transactional
        public JwtResponse authenticate(LoginRequest loginRequest) {
                try {
                        Authentication authentication = authenticationManager.authenticate(
                                        new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(),
                                                        loginRequest.getPassword()));

                        SecurityContextHolder.getContext().setAuthentication(authentication);

                        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
                        User user = userRepository.findById(userPrincipal.getId())
                                        .orElseThrow(() -> new UnauthorizedException("User not found"));

                        Set<String> roles = userPrincipal.getRoles();
                        Set<String> permissions = userPrincipal.getPermissions();

                        String accessToken = jwtTokenUtil.generateAccessToken(userPrincipal, user.getUser_id(), roles,
                                        permissions);
                        String refreshToken = refreshTokenService.createRefreshToken(user.getUser_id()).getToken();

                        UserDTO userDTO = userMapper.toUserDTO(user);

                        UserInfoResponse userInfo = UserInfoResponse.builder().user(userDTO).build();

                        return JwtResponse.builder().accessToken(accessToken).refreshToken(refreshToken)
                                        .tokenType("Bearer").userInfo(userInfo).build();
                } catch (BadCredentialsException e) {
                        throw new UnauthorizedException("Invalid username/email or password");
                }
        }

        @Transactional
        public JwtResponse refreshToken(RefreshTokenRequest request) {
                RefreshToken refreshToken = refreshTokenService.findByToken(request.getRefreshToken())
                                .orElseThrow(() -> new UnauthorizedException("Refresh token not found"));

                refreshToken = refreshTokenService.verifyExpiration(refreshToken);

                User user = refreshToken.getUser();
                UserPrincipal userPrincipal = UserPrincipal.create(user);

                Set<String> roles = userPrincipal.getRoles();
                Set<String> permissions = userPrincipal.getPermissions();

                String accessToken = jwtTokenUtil.generateAccessToken(userPrincipal, user.getUser_id(), roles,
                                permissions);

                // Optionally rotate refresh token
                RefreshToken newRefreshToken = refreshTokenService.createRefreshToken(user.getUser_id());

                UserDTO userDTO = userMapper.toUserDTO(user);

                UserInfoResponse userInfo = UserInfoResponse.builder().user(userDTO).build();

                return JwtResponse.builder().accessToken(accessToken).refreshToken(newRefreshToken.getToken())
                                .tokenType("Bearer").userInfo(userInfo).build();
        }
}
