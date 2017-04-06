package com.progressoft.test.first;

public class SingUpUseCase {

    public SignUpRepository signUpRepository;

    public void execute(SingUpRequest request){
        SignUp signUp=new SignUp(request.getUserName(), request.getPassword(), request.getPasswordConfirmation());
        //we can also set the values here
        signUp.setEncryptedPassword("something wrong");
        signUpRepository.persist(signUp);
    }

}
