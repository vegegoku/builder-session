package com.progressoft.test.sixth;

public class InMemorySingUpRepository implements SignUpRepository<SignUp> {

    @Override
    public void persist(SignUp signUp) {
        signUp.accept(userRecord -> {
            //save the user record.
        });
    }
}
