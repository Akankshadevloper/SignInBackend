package com.domain.RMS.SignUpService;

import com.domain.RMS.SignUpException.ResourceNotFoundException;
import com.domain.RMS.SignUpModel.SignUp;
import com.domain.RMS.SignUpRepository.SignUpRepository;
import com.domain.RMS.SignUpService.Impl.SignUpService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignUpServiceImpl implements SignUpService {

    private SignUpRepository signUpRepository;


    public SignUpServiceImpl(SignUpRepository signUpRepository) {
        super();
        this.signUpRepository = signUpRepository;
    }

    @Override
    public SignUp saveSignUp(SignUp signUp) {
        return signUpRepository.save(signUp);
    }

    @Override
    public List<SignUp> getAllSignUp() {
        return signUpRepository.findAll();
    }

    @Override
    public SignUp getSignUpById(long id) {
 //       Optional<SignUp> signUp = signUpRepository.findById(id);
        //       if(signUp.isPresent()) {
        // return signUp.get();
        //}else{
        //throw new ResourceNotFoundException("SignUp","Id", id);
        //}
        return signUpRepository.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("SignUp", "Id", id));
}
    @Override
    public SignUp updateSignUp(SignUp signUp, long id) {
        SignUp existingSignUp = signUpRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("SignUp", "Id", id));

        existingSignUp.setFirstName(signUp.getFirstName());
        existingSignUp.setLastName(signUp.getLastName());
        existingSignUp.setPhoneNumber(signUp.getPhoneNumber());
        existingSignUp.setpassword(signUp.getpassword());

        signUpRepository.save(existingSignUp);
        return existingSignUp;
    }
// build delete signUp REST API
    @Override
    public void deleteSignUp(long id) {
        // check whether a signUp exist in DB or not
        signUpRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("SignUp", "Id", id));
        signUpRepository.deleteById(id);

    }
}

