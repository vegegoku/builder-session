package com.progressoft.builder;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class UserTest {

    //This is builder wraps the original builder from the User class
    //we added this class to simplify our test save us from repeating
    //all user values in all the tests
    private class TestUserBuilder{
        //we initialize all the fields with valid values
        private String userName = "validUserName";
        private String firstName = "validFirstName";
        private String lastName = "validLastName";
        private String email ="valid@test.com";
        private String phone ="990988474";
        private String department = "ECC";

        public TestUserBuilder userName(String userName){
            this.userName=userName;
            return this;
        }
        public TestUserBuilder firstName(String firstName){
            this.firstName=firstName;
            return this;
        }
        public TestUserBuilder lastName(String lastName){
            this.lastName=lastName;
            return this;
        }

        public TestUserBuilder email(String email){
            this.email=email;
            return this;
        }
        public TestUserBuilder phone(String phone){
            this.phone=phone;
            return this;
        }

        public TestUserBuilder department(String department){
            this.department=department;
            return this;
        }

        //we create the user using the our builder from the production code.
        public User build(){
            return User.UserBuilder
                    .userName(userName)
                    .firstName(firstName)
                    .lastName(lastName)
                    .email(email)
                    .phone(phone)
                    .department(department)
                    .build();
        }
    }

    //in the tests we only override the value we want to test.

    @Test(expected = InvalidUsernameException.class)
    public void givenANullUserName_whenBuildingUserWithThisUserName_thenShouldThrowException() throws Exception {
       new TestUserBuilder().userName(null).build();
    }

    @Test(expected = InvalidUsernameException.class)
    public void givenAnEmptyUserName_whenBuildingUserWithThisUserName_thenShouldThrowException() throws Exception {
        new TestUserBuilder().userName("").build();
    }

    @Test(expected = InvalidUsernameException.class)
    public void givenSpacesAsUserName_whenBuildingUserWithThisUserName_thenShouldThrowException() throws Exception {
        new TestUserBuilder().userName("   ").build();
    }

    //add more tests here
}
