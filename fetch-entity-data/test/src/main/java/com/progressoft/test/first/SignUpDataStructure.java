package com.progressoft.test.first;

public class SignUpDataStructure {

    private String userName;
    private String password;
    private String passwordConfirm;
    private String encryptedPassword;

    public SignUpDataStructure(String userName, String password, String passwordConfirm, String encryptedPassword) {
        this.userName = userName;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.encryptedPassword = encryptedPassword;
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

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
}
