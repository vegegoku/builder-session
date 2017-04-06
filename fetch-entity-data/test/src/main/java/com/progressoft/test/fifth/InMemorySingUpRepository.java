package com.progressoft.test.fifth;

public class InMemorySingUpRepository implements SignUpRepository<SignUpObserver> {

    @Override
    public void persist(SignUpObserver signUp) {
        SignUp.UserRecord userRecord=signUp.getUserRecord();
        //we can save the user record but this repository is not using the model
    }
}
