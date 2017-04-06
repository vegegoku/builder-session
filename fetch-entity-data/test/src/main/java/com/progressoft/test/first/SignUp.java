package com.progressoft.test.first;


import static java.util.Objects.*;

public class SignUp extends SignUpDataStructure{

    public SignUp(String userName, String password, String passwordConfirm) {
        super(userName, password, passwordConfirm, null);
        if(isNull(userName) || userName.trim().isEmpty())
            throw new InvalidUserNameException();
        if(isNull(password) || password.trim().isEmpty())
            throw new InvalidPasswordException();
        if(isNull(passwordConfirm) || passwordConfirm.trim().isEmpty() || !password.equals(passwordConfirm))
            throw new InvalidPasswordConfirmationException();

        encryptPassword();
    }

    //add behaviours here

    private void encryptPassword(){
        setEncryptedPassword("encrypt the password and set the value");
    }


    private class InvalidUserNameException extends RuntimeException {
    }

    private class InvalidPasswordException extends RuntimeException {
    }

    private class InvalidPasswordConfirmationException extends RuntimeException {
    }
}
