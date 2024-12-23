package Kapse1.first.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data

public class UserEntity {
    @Id

    private ObjectId id;

    @NonNull
    @Indexed(unique = true)
    private String username;

    @NonNull
    private String password;
    private LocalDate date;

    @DBRef
    private List<JournalEntity> journalEntries =  new ArrayList<>();

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
        this.date = LocalDate.now();
    }
}
