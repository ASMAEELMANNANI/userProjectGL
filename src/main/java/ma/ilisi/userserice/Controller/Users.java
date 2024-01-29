package ma.ilisi.userserice.Controller;

import lombok.AllArgsConstructor;
import ma.ilisi.userserice.dto.ChangePasswordDTO;
import ma.ilisi.userserice.dto.ClientDTO;
import ma.ilisi.userserice.dto.UserDTO;
import ma.ilisi.userserice.Service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin("*")
@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
public class Users {
    ClientService clientService;



    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO user){
       int result=clientService.Login(user);
       if(result==1)
           return ResponseEntity.ok("1");///login succes client
       if(result==2)
           return ResponseEntity.ok("2");///login succes admin

       if(result==-1)
           return ResponseEntity.ok("-1");///Login dosn't exist

        return ResponseEntity.ok("Password incorrect");
    }



    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody ClientDTO client){

        int result=clientService.Signup(client);
        if(result ==-1)
            return ResponseEntity.badRequest().body("Login deja existe");
        if(result ==1)
            return ResponseEntity.ok("Sign up succefuly");
        return ResponseEntity.badRequest().body("Fields required");

    }

    @PostMapping("/changepwd")
    public ResponseEntity<String> ChangePassword(@RequestBody ChangePasswordDTO userA){

        int result=clientService.ChangePassword(userA);
        if(result==-1)
        return ResponseEntity.badRequest().body("Old password is incorrect");

        return ResponseEntity.ok("Password changed succefuly");
    }




}
