package com.progressoft.test.first;

public class InMemorySingUpRepository implements SignUpRepository<SignUp> {
    @Override
    public void persist(SignUp signUp) {
        UserRecord correctUserRecord=new UserRecord(signUp.getUserName(), signUp.getEncryptedPassword());
        //but we also can do this
        UserRecord wrongUserRecord=new UserRecord(signUp.getUserName(), signUp.getPassword());
        //or this
        UserRecord anotherWrongUserRecord=new UserRecord(signUp.getUserName(), signUp.getPasswordConfirm());

        //then anyone can save something wrong in the persistence storage.
    }
}
