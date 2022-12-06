package entity.user;

import entity.enums.Role;
import entity.enums.UserStatus;
import entity.interfaces.IComment;
import entity.user.stuff.Order;
import entity.reviews.Review;
import exceptions.NotMatchRegexException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class User implements IComment {
    private static final String NAME_SURNAME_REGEX = "[a-zA-Z]{2,20}";
    private static final String EMAIL_REGEX = "^(.+)@(.+)$";
    private static final String PASSWORD_REGEX =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}\\[\\]:;<>,?/~_+-=|]).{8,32}$";
    private static final String PHONE_REGEX = "\\d{9}";
    private final String PHONE_NUMBER_PREFIX = "+380";

    private String name;
    private String surname;
    private String email;
    private String password;
    private List<Review> reviews = new ArrayList<>();
    private Role role;
    private String phoneNumber;
    private UserStatus status;
    private List<Order> orders = new ArrayList<>();

    private static final Logger LOGGER = Logger.getLogger(Order.class);

    public User(){}

    public User(String name, String surname, String email,
                String password, String phoneNumber, UserStatus status){
        if(!name.matches(NAME_SURNAME_REGEX) && !surname.matches(NAME_SURNAME_REGEX)){
            LOGGER.error(NotMatchRegexException.MESSAGE_FULL_NAME);
            throw new NotMatchRegexException(NotMatchRegexException.MESSAGE_FULL_NAME);
        }
        if (!email.matches(EMAIL_REGEX)) {
            LOGGER.error(NotMatchRegexException.MESSAGE_EMAIL);
            throw new NotMatchRegexException(NotMatchRegexException.MESSAGE_EMAIL);
        }
        if (!password.matches(PASSWORD_REGEX)){
            LOGGER.error(NotMatchRegexException.MESSAGE_PASSWORD);
            throw new NotMatchRegexException(NotMatchRegexException.MESSAGE_PASSWORD);
        }
        if(!phoneNumber.matches(PHONE_REGEX)){
            LOGGER.error(NotMatchRegexException.MESSAGE_PHONE);
            throw new NotMatchRegexException(NotMatchRegexException.MESSAGE_PHONE);
        }
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phoneNumber = PHONE_NUMBER_PREFIX + phoneNumber;
        this.status = status;
    }

    public final boolean addReview(Review review) {
        LOGGER.info("review was added to user");
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
        if(!name.matches(NAME_SURNAME_REGEX)){
            LOGGER.error(NotMatchRegexException.MESSAGE_FULL_NAME);
            throw new NotMatchRegexException(NotMatchRegexException.MESSAGE_FULL_NAME);
        }
        this.name = name;
    }

    public void setSurname(String surname) {
        if(!surname.matches(NAME_SURNAME_REGEX)){
            LOGGER.error(NotMatchRegexException.MESSAGE_FULL_NAME);
            throw new NotMatchRegexException(NotMatchRegexException.MESSAGE_FULL_NAME);
        }
        this.surname = surname;
    }

    public void setEmail(String email) {
        if (!email.matches(EMAIL_REGEX)) {
            LOGGER.error(NotMatchRegexException.MESSAGE_EMAIL);
            throw new NotMatchRegexException(NotMatchRegexException.MESSAGE_EMAIL);
        }
        this.email = email;
    }

    public void setPassword(String password) {
        if (!password.matches(PASSWORD_REGEX)){
            LOGGER.error(NotMatchRegexException.MESSAGE_PASSWORD);
            throw new NotMatchRegexException(NotMatchRegexException.MESSAGE_PASSWORD);
        }
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(!phoneNumber.matches(PHONE_REGEX)){
            LOGGER.error(NotMatchRegexException.MESSAGE_PHONE);
            throw new NotMatchRegexException(NotMatchRegexException.MESSAGE_PHONE);
        }
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
