package com.progressoft.test.sixth;


import static java.util.Objects.isNull;

public class SignUp{

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

    private class InvalidUserNameException extends RuntimeException {}
    private class InvalidPasswordException extends RuntimeException {}
    private class InvalidPasswordConfirmationException extends RuntimeException {}

   public void accept(SignUpVisitor visitor){
        visitor.visit(new UserRecord(userName, encryptedPassword));
   }

   public interface SignUpVisitor {
       void visit(UserRecord userRecord);
   }

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

}
