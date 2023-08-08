package dev.likelion.momeal.repository;

import dev.likelion.momeal.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserEntity,Long>{

    UserEntity findByUserid(String userid);
}
