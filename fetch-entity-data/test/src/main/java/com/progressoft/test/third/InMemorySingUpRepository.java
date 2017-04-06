package com.progressoft.test.third;

public class InMemorySingUpRepository implements SignUpRepository<SignUp.UserRecord> {
    @Override
    public void persist(SignUp.UserRecord userRecord) {
        //we can save the user record but this repository is not using the model
    }
}
