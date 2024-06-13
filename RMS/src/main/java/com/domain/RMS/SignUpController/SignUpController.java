package com.domain.RMS.SignUpController;

import com.domain.RMS.SignUpModel.SignUp;
import com.domain.RMS.SignUpService.Impl.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/SignUp")
public class SignUpController {



    private SignUpService SignUpService;

    @Autowired
    public SignUpController(SignUpService signUpService) {
        super();
        SignUpService = signUpService;
    }

    //build create SignUp REST API

    @PostMapping
    public ResponseEntity<SignUp> saveSignUp(@RequestBody SignUp signUp) {
        return new ResponseEntity<>(SignUpService.saveSignUp(signUp), HttpStatus.CREATED);

    }


    // build get all SignUP REST API
    @GetMapping
    public List<SignUp> getAllSignUp() {
        return SignUpService.getAllSignUp();

    }


    // build get SignUp by id REST API
    @GetMapping("{id}")
    public ResponseEntity<SignUp> getLoginDetailsById(@PathVariable("id") long signUpId) {
        return new ResponseEntity<SignUp>(SignUpService.getSignUpById(signUpId), HttpStatus.OK);
    }

    //build Update signUp REST API

    @PutMapping("{id}")
    public ResponseEntity<SignUp> updateSignUp(@PathVariable("id") long id
            , @RequestBody SignUp signUp) {
        return new ResponseEntity<SignUp>(SignUpService.updateSignUp(signUp, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSignUp(@PathVariable("id") long id) {
        SignUpService.deleteSignUp(id);
        return new ResponseEntity<>("SignUp Details Deleted Successfully", HttpStatus.OK);


    }

}



