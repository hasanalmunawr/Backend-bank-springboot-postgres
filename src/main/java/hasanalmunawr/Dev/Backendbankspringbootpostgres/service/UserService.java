package hasanalmunawr.Dev.Backendbankspringbootpostgres.service;

import hasanalmunawr.Dev.Backendbankspringbootpostgres.entity.UserEntity;
import hasanalmunawr.Dev.Backendbankspringbootpostgres.entity.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {
    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);

    boolean checkUserExists(String username, String email);

    boolean checkUsernameExists(String username);

    boolean checkEmailExists(String email);

    void save(UserEntity user);

    UserEntity createUser(UserEntity user, Set<UserRole> userRoles);

    UserEntity saveUser(UserEntity user);

    List<UserEntity> findUserList();

    void enableUser(String username);

    void disableUser(String username);
}
