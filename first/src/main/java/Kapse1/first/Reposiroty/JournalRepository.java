package Kapse1.first.Reposiroty;

import Kapse1.first.Entity.JournalEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepository extends MongoRepository<JournalEntity, ObjectId> {

}

