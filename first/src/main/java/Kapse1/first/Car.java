package Kapse1.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Car {

    @Autowired
    public Dog dog;

    @GetMapping("bark")
    public String cars(){
        return  dog.bark();
    }

}
