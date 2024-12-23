package Kapse1.first.Controllers;

import Kapse1.first.Entity.JournalEntity;
import Kapse1.first.Service.JournalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntries {



    @Autowired
    public JournalService journalService;

    @GetMapping
    public ResponseEntity<?> getAll(){

        List<JournalEntity> all =  journalService.getAllEntries();
        if(all != null && !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<JournalEntity> addJournal(@RequestBody JournalEntity journalEntity){

        try {


            journalEntity.setDate(LocalDate.now());
            journalService.add(journalEntity);

            return new ResponseEntity<>(journalEntity, HttpStatus.CREATED);

        }
        catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id/{myid}")
    public ResponseEntity<JournalEntity> getById(@PathVariable ObjectId myid) {

        JournalEntity journal = journalService.getbyID(myid).orElse(null);
        if(journal != null){
            return new ResponseEntity<>(journal, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/id/{myid}")
    public ResponseEntity<?> deleteById(@PathVariable ObjectId myid){
        Optional<JournalEntity> jornal =  journalService.getbyID(myid);
        if( jornal.isPresent()) {


            journalService.deleteByID(myid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public void deletMany(){

        journalService.deleteMany();
    }

    @PutMapping("/id/{myid}")
    public ResponseEntity<?> updateById(@PathVariable ObjectId myid, @RequestBody JournalEntity newEntry){

        JournalEntity old =  journalService.getbyID(myid).orElse(null);
        if (old != null) {
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());


            journalService.add(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

}
