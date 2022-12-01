package entity.user;

import entity.enums.Role;
import entity.enums.UserStatus;
import entity.user.interfaces.IComment;
import entity.user.stuff.Order;
import entity.reviews.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class User implements IComment {
    private final String PHONE_NUMBER_PREFIX = "+380";

    private String name;
    private String surname;
    private String email;
    private String password;
    private List<Review> reviews;
    private Role role;
    private String phoneNumber;
    private UserStatus status;
    private List<Order> orders;

    public User(){}

    public User(String name, String surname, String email, String password,
                Role role, String phoneNumber, UserStatus status){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phoneNumber = PHONE_NUMBER_PREFIX + phoneNumber;
        this.reviews = new ArrayList<>();
        this.status = status;
        this.orders = new ArrayList<>();
    }

    public boolean addReview(Review review) {
        return reviews.add(review);
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

    public UserStatus getStatus() {
        return status;
    }

    public List<Order> getOrders() {
        return orders;
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
        this.phoneNumber = PHONE_NUMBER_PREFIX + phoneNumber;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(surname, user.surname)
                && Objects.equals(email, user.email) && Objects.equals(password, user.password)
                && Objects.equals(reviews, user.reviews) && role == user.role
                && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(status, user.status)
                && Objects.equals(orders, user.getOrders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, email, password, reviews, role, phoneNumber, status, orders);
    }

    @Override
    public String toString() {
        return "User info: \n" +
                "name and surname: " + name + " " + surname +
                ", email: " + email +
                ", password: " + password +
                ", reviews: " + reviews +
                ", role: " + role +
                ", phoneNumber: " + phoneNumber +
                ", status: '" + status;
    }
}
