package com.progressoft.test.third;


import static java.util.Objects.isNull;

public class SignUp {

    public static class UserRecord{
        private String userName;
        private String password;

        public UserRecord(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    private final SignUpRepository repository;
    private final String userName;
    private String encryptedPassword;

    //the persistence is enforced into this entity model.
    //every one must implement the repository.
    //the model depends on the repository - High level class is depending in low level interface -

    public SignUp(String userName, String password, String passwordConfirm, SignUpRepository repository) {
        if(isNull(userName) || userName.trim().isEmpty())
            throw new InvalidUserNameException();
        if(isNull(password) || password.trim().isEmpty())
            throw new InvalidPasswordException();
        if(isNull(passwordConfirm) || passwordConfirm.trim().isEmpty() || !password.equals(passwordConfirm))
            throw new InvalidPasswordConfirmationException();

        this.repository=repository;
        this.userName=userName;
        encryptPassword();
    }

    private void encryptPassword(){
        this.encryptedPassword="encrypt the password and set the value";
    }

    private class InvalidUserNameException extends RuntimeException {}
    private class InvalidPasswordException extends RuntimeException {}
    private class InvalidPasswordConfirmationException extends RuntimeException {}

    public void persist(){
        this.repository.persist(new UserRecord(userName, encryptedPassword));
    }
}
