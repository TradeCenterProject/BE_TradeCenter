package group1.unnamed.data.repository;

import group1.unnamed.data.entity.CompanyEntity;
import group1.unnamed.data.entity.TaskEntity;
import group1.unnamed.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Boolean existsByEmail(String email);
    UserEntity findByEmail(String email);

}
