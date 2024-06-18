package com.example.plantCare.model;

/**
 * LoginDto is a class used to hold the user login information that's sent from the
 * client to the server for the login endpoint.
 *
 * The acronym DTO is being used for "data transfer object". It means that this type of
 * class is specifically created to transfer data between the client and the server.
 */
public class LoginDto {

   private String email;
   private String password;

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   @Override
   public String toString() {
      return "LoginDTO{" +
              "email='" + email + '\'' +
              ", password='" + password + '\'' +
              '}';
   }
}
