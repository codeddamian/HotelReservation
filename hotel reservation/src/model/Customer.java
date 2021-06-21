package model;

import java.util.regex.Pattern;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String emailRegex = "^(.+)@(.+).com$";
    private final Pattern pattern = Pattern.compile(emailRegex);


  public Customer(String firstName, String lastName, String email){
      if (!pattern.matcher(email).matches()) {
          throw new IllegalArgumentException("Error Invalid Email");

      }
     this.firstName = firstName;
     this.lastName = lastName;
     this.email= email;
  }
    public String getEmail() {
        return email;
    }
    @Override
    public String toString() {

      return "firstName " + firstName + " LastName " + lastName + "\n The Email " + email;

    }
}