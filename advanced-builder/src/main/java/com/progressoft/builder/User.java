package com.progressoft.builder;

import static java.util.Objects.isNull;

public class User {

    //required
    private final String userName;
    private final String firstName;
    private final String lastName;
    private final String email;

    //not required
    private final String phone;
    private final String department;

    private User(String userName, String firstName, String lastName, String email, String phone, String department) {
        if(isNull(userName) || userName.trim().isEmpty())
            throw new InvalidUsernameException();
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.department = department;
    }

    //we can add some behaviours here
    //behaviours like contact user
    //login user

    public interface HasFirstName{
        HasLastName firstName(String firstName);
    }

    public interface HasLastName{
        HasEmail lastName(String lastName);
    }

    public interface HasEmail{
        CanBuildUser email(String email);
    }

    public interface CanBuildUser{
        CanBuildUser phone(String phone);
        CanBuildUser department(String department);
        User build();
    }

    //Interface Segregation Principle applied here
    public static class UserBuilder implements HasFirstName, HasLastName, HasEmail, CanBuildUser{
        private String userName;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String department;

        private UserBuilder(String userName){
            this.userName=userName;
        }

        public static HasFirstName userName(String userName){
            return new UserBuilder(userName);
        }

        @Override
        public HasLastName firstName(String firstName) {
            this.firstName=firstName;
            return this;
        }

        @Override
        public HasEmail lastName(String lastName) {
            this.lastName=lastName;
            return this;
        }

        @Override
        public CanBuildUser email(String email) {
            this.email=email;
            return this;
        }

        @Override
        public CanBuildUser phone(String phone) {
            this.phone=phone;
            return this;
        }

        @Override
        public CanBuildUser department(String department) {
            this.department=department;
            return this;
        }

        @Override
        public User build(){
            return new User(userName, firstName, lastName, email, phone, department);
        }
    }
}
