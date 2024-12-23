package Kapse1.first.Service;

import Kapse1.first.Entity.UserEntity;
import Kapse1.first.Reposiroty.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    public UserRepository userRepository;
    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }

    public void add(UserEntity user){

        user.setDate(LocalDate.now());
         userRepository.save(user);
    }

    public Optional<UserEntity> getById(ObjectId id){
        return userRepository.findById(id);
    }

    public UserEntity findByUsername(String username){
        return userRepository.findUserbyUserName(username);
    }
    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public void deleteMany(){
        userRepository.deleteAll();
    }
}
