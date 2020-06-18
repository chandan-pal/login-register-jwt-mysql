package in.chandanpal.loginregisterjwtmysql.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.chandanpal.loginregisterjwtmysql.model.RegistrationRequest;
import in.chandanpal.loginregisterjwtmysql.model.RegistrationResponse;
import in.chandanpal.loginregisterjwtmysql.model.User;

@RestController
public class RegistrationService {
    
    Logger logger = LoggerFactory.getLogger(RegistrationService.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest) throws Exception
	{
		logger.info("RegistrationService:registerUser...started");
		
		String userEmail = registrationRequest.getUserEmail();
		
		// Lookup user in database by e-mail
        User userExists = userService.findUserByEmail(userEmail);
        logger.debug("User exists = " + userExists);
        
        if (userExists != null)
        {
            long userId = userExists.getUserId();
            return ResponseEntity.ok(new RegistrationResponse(userId, "User already exists!"));
        }
        else
        {
            User newUser = new User();
            newUser.setEmail(userEmail);
            newUser.setActive(1);
            newUser.setFirstName(registrationRequest.getFirstName());
            newUser.setLastName(registrationRequest.getLastName());
            newUser.setPassword(bCryptPasswordEncoder.encode(registrationRequest.getPassword()));
            
            // save new user
            newUser = userService.saveUser(newUser);
            
            long userId = newUser.getUserId();
            return ResponseEntity.ok(new RegistrationResponse(userId, "New user registered!"));
        }
	}
}
