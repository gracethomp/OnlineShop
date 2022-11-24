package entity.user;

import entity.Review;
import entity.user.Role;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private List<Review> reviews;
    private Role role;
    private String phoneNumber;

    public User(){}

    public User(String name, String surname, String email, String password, Role role, String phoneNumber){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phoneNumber = "+380" + phoneNumber;
        this.reviews = new ArrayList<>();
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public String getSurname() {
        return surname;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = "+380" + phoneNumber;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
