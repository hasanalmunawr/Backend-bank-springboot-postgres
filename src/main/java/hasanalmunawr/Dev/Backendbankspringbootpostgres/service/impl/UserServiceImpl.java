package hasanalmunawr.Dev.Backendbankspringbootpostgres.service.impl;

import hasanalmunawr.Dev.Backendbankspringbootpostgres.entity.UserEntity;
import hasanalmunawr.Dev.Backendbankspringbootpostgres.entity.UserRole;
import hasanalmunawr.Dev.Backendbankspringbootpostgres.exception.UserAlreadyExistException;
import hasanalmunawr.Dev.Backendbankspringbootpostgres.repository.UserRepo;
import hasanalmunawr.Dev.Backendbankspringbootpostgres.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;

    private final RoleRepo roleRepo;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity findByUsername(String username) {
     return userRepository.findUserEntityByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findUserEntityByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Email " + email + " not found"));
    }

    @Override
    public boolean checkUserExists(String username, String email) {
        return userRepository.checkUserExists(username, email);
    }

    @Override
    public boolean checkUsernameExists(String username) {
        return userRepository.checkUsernameExists(username);
    }

    @Override
    public boolean checkEmailExists(String email) {
        return userRepository.checkEmailExists(email);
    }

    @Override
    public void save(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public UserEntity createUser(UserEntity user, Set<UserRole> userRoles) {
        try {
            var userEntity = userRepository
                    .findUserEntityByEmail(user.getEmail())
                    .orElseThrow(() -> {
                        log.error("[UserServieImp:createUser] User : {}  Already Exist ", user.getUsername());
                        return new UserAlreadyExistException("User " + user.getEmail() + " already exists");
                    });


        } catch (Exception e) {
            log.error("[UserServiceImpl:createUser] Exception while Creating the user due to : {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Please Try Again");
        }


    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        return null;
    }

    @Override
    public List<UserEntity> findUserList() {
        return List.of();
    }

    @Override
    public void enableUser(String username) {

    }

    @Override
    public void disableUser(String username) {

    }
}
