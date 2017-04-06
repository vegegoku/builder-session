package com.progressoft.test.second;


import static java.util.Objects.isNull;

public class SignUp extends SignUpDataStructure {

    public SignUp(String userName, String password, String passwordConfirm) {
        super(userName);
        if(isNull(userName) || userName.trim().isEmpty())
            throw new InvalidUserNameException();
        if(isNull(password) || password.trim().isEmpty())
            throw new InvalidPasswordException();
        if(isNull(passwordConfirm) || passwordConfirm.trim().isEmpty() || !password.equals(passwordConfirm))
            throw new InvalidPasswordConfirmationException();

        encryptPassword();
    }

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
