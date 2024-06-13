package com.domain.RMS.SignUpService.Impl;

import com.domain.RMS.SignUpModel.SignUp;

import java.util.List;

public interface SignUpService {
    SignUp saveSignUp(SignUp signUp);
    List<SignUp> getAllSignUp();
    SignUp getSignUpById(long id );
    SignUp updateSignUp(SignUp signUp, long id);
    void deleteSignUp(long id);


}
