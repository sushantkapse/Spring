package Kapse1.first.Controllers;

import Kapse1.first.Entity.JournalEntity;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journalBasic")
public class Journal {
    private Map<ObjectId, JournalEntity> journalMap = new HashMap<>();

    @GetMapping
    public List<JournalEntity> getAll(){
        return new ArrayList<>(journalMap.values());
    }

    @PostMapping
    public String addJournal(@RequestBody JournalEntity journalEntity){
        journalMap.put(journalEntity.getId(), journalEntity);
        return "okk";
    }

    @GetMapping("/id/{myid}")
    public JournalEntity getById(@PathVariable ObjectId myid) {
        return journalMap.get(myid);
    }

    @DeleteMapping("/id/{myid}")
    public void deleteById(@PathVariable ObjectId myid){
        journalMap.remove(myid);

}

    @PutMapping("/id/{myid}")
    public JournalEntity updateById(@PathVariable ObjectId myid, @RequestBody JournalEntity journalEntity){
        return journalMap.put(myid,journalEntity);
    }




}
