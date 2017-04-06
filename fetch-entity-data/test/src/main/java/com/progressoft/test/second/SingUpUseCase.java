package com.progressoft.test.second;

public class SingUpUseCase {

    public SignUpRepository signUpRepository;

    public void execute(SingUpRequest request){
        SignUp signUp=new SignUp(request.getUserName(), request.getPassword(), request.getPasswordConfirmation());
        //we can do something wrong here.
        signUpRepository.persist(signUp);
    }

}
