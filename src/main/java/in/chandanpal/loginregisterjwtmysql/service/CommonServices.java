package in.chandanpal.loginregisterjwtmysql.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonServices
{
    @GetMapping("/test")
    public String testAuthentication() {
        return "You are authenticated!";
    }

}
