package com.progressoft.test.second;

public class InMemorySingUpRepository implements SignUpRepository<SignUp> {
    @Override
    public void persist(SignUp signUp) {
        UserRecord correctUserRecord=new UserRecord(signUp.getUserName(), signUp.getEncryptedPassword());
        //we can now save safely unless we do this

       signUp.setEncryptedPassword("something other than the original , this will change the state of the signup model into something wrong");

        //then someone might save the wrong thing again. but the real issue is the change of the model state from within the repository.
    }
}
