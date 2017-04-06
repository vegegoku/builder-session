package com.progressoft.test.fifth;

public class SingUpUseCase {

    public SignUpRepository signUpRepository;

    public void execute(SingUpRequest request){
        SignUp signUp=new SignUp(request.getUserName(), request.getPassword(), request.getPasswordConfirmation());
        signUp.addListener(new StateListener<SignUp.UserRecord>() {
            @Override
            public void onStateUpdated(SignUp.UserRecord state) {
                //do something here
            }
        });



        SignUpObserver signUp2=new SignUpObserver(request.getUserName(), request.getPassword(), request.getPasswordConfirmation());
        signUpRepository.persist(signUp2);
    }

}
