package Kapse1.first.Service;

import Kapse1.first.Entity.JournalEntity;
import Kapse1.first.Reposiroty.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalService {

    @Autowired
    public JournalRepository journalRepository;

    public void add(JournalEntity journalEntity){
        journalRepository.save(journalEntity);
    }

    public List<JournalEntity> getAllEntries(){
        return journalRepository.findAll();
    }

    public Optional<JournalEntity> getbyID(ObjectId id){
        return  journalRepository.findById(id);

    }


    public void deleteByID(ObjectId id){
        journalRepository.deleteById(id);
    }

    public  void deleteMany(){
        journalRepository.deleteAll();
    }



}
