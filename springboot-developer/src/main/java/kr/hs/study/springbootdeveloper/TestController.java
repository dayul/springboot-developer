package kr.hs.study.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    TestService testSevice;  // TestService Bean 주입

    @GetMapping("/")
    public String hi() {
        return "hi";
    }


    @GetMapping("/test")
    public List<Member> getAllMembers() {
        List<Member> members = testSevice.getAllMembers();
        return members;
    }
}
