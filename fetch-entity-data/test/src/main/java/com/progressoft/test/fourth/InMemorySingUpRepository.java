package com.progressoft.test.fourth;

public class InMemorySingUpRepository implements SignUpRepository<SignUp> {

    private static class UserRecordDataStructure implements SignUp.UserRecord{

        public String userName;
        public String password;

        @Override
        public void setUserName(String userName) {
            this.userName=userName;
        }

        @Override
        public void setPassword(String password) {
            this.password=password;
        }
    }

    @Override
    public void persist(SignUp signUp) {
        UserRecordDataStructure userRecordDataStructure=new UserRecordDataStructure();
        signUp.mapToUserRecord(userRecordDataStructure);
        //we can save the user record but this repository is not using the model
    }
}
