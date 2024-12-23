package Kapse1.first.Reposiroty;

import Kapse1.first.Entity.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<UserEntity, ObjectId> {

    @Query("{ 'username': ?0 }")
    UserEntity findUserbyUserName(String username);
}

