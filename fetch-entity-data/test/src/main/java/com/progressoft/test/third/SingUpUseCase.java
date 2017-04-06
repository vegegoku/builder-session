package com.progressoft.test.third;

public class SingUpUseCase {

    public SignUpRepository signUpRepository;

    public void execute(SingUpRequest request){
        SignUp signUp=new SignUp(request.getUserName(), request.getPassword(), request.getPasswordConfirmation(), signUpRepository);
        signUp.persist();
    }

}
