package com.progressoft.test.fourth;


import static java.util.Objects.isNull;

public class SignUp {

    public interface UserRecord{
        void setUserName(String userName);
        void setPassword(String password);
    }

    private final String userName;
    private String encryptedPassword;


    public SignUp(String userName, String password, String passwordConfirm) {
        if(isNull(userName) || userName.trim().isEmpty())
            throw new InvalidUserNameException();
        if(isNull(password) || password.trim().isEmpty())
            throw new InvalidPasswordException();
        if(isNull(passwordConfirm) || passwordConfirm.trim().isEmpty() || !password.equals(passwordConfirm))
            throw new InvalidPasswordConfirmationException();

        this.userName=userName;
        encryptPassword();
    }

    private void encryptPassword(){
        this.encryptedPassword="encrypt the password and set the value";
    }

    private class InvalidUserNameException extends RuntimeException {
    }

    private class InvalidPasswordException extends RuntimeException {
    }

    private class InvalidPasswordConfirmationException extends RuntimeException {
    }

    //this is simple and easy to implement, dependencies in the correct direction
    //no persistence logic in the model
    //anyone can obtain the state of the model at any point of time
    //uses an output parameter.
    public void mapToUserRecord(UserRecord userRecord){
        userRecord.setUserName(userName);
        userRecord.setPassword(encryptedPassword);
    }
}
