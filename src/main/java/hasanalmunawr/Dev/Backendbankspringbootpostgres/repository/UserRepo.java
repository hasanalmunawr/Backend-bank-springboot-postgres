package hasanalmunawr.Dev.Backendbankspringbootpostgres.repository;

import hasanalmunawr.Dev.Backendbankspringbootpostgres.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Integer> {

    Optional<UserEntity> findUserEntityByUsername(String username);

    Optional<UserEntity> findUserEntityByEmail(String email);

    boolean checkUserExists(String username, String email);

    boolean checkUsernameExists(String username);

    boolean checkEmailExists(String email);
}
