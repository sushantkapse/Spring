package Kapse1.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyClass {
    @GetMapping("abc")
    public  String hello() {
        return "Hey Sushant";
    }
}
