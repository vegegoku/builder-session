package com.progressoft.test.fifth;

public class SignUpObserver extends SignUp implements StateListener<SignUp.UserRecord> {

    private UserRecord userRecord;

    public SignUpObserver(String userName, String password, String passwordConfirm) {
        super(userName, password, passwordConfirm);
        super.addListener(this);
    }

    @Override
    public void onStateUpdated(UserRecord state) {
        this.userRecord=state;
    }

    public UserRecord getUserRecord() {
        return userRecord;
    }

    public void setUserRecord(UserRecord userRecord) {
        this.userRecord = userRecord;
    }
}
