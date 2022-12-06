package entity.user;

import entity.enums.Role;
import entity.enums.UserStatus;
import entity.interfaces.IComment;
import entity.user.stuff.Order;
import entity.reviews.Review;
import exceptions.NotMatchRegexException;
import exceptions.OnlineShopIOException;
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
    private static final String PHONE_NUMBER_PREFIX = "+380";

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

    public final boolean addReview(Review review) throws OnlineShopIOException {
        LOGGER.info("review was added to user");
        return reviews.add(review);
    }

    public String getSurname() {
        LOGGER.trace("surname was gotten");
        return surname;
    }

    public String getName() {
        LOGGER.trace("name was gotten");
        return name;
    }

    public String getEmail() {
        LOGGER.trace("email was gotten");
        return email;
    }

    public String getPassword() {
        LOGGER.trace("password was gotten");
        return password;
    }

    public Role getRole() {
        LOGGER.trace("role was gotten");
        return role;
    }

    public List<Review> getReviews() {
        LOGGER.trace("reviews were gotten");
        return reviews;
    }

    public String getPhoneNumber() {
        LOGGER.trace("phone number was gotten");
        return phoneNumber;
    }

    public UserStatus getStatus() {
        LOGGER.trace("status was gotten");
        return status;
    }

    public List<Order> getOrders() {
        LOGGER.trace("orders were gotten");
        return orders;
    }

    public void setName(String name) {
        if(!name.matches(NAME_SURNAME_REGEX)){
            LOGGER.error(NotMatchRegexException.MESSAGE_FULL_NAME);
            throw new NotMatchRegexException(NotMatchRegexException.MESSAGE_FULL_NAME);
        }
        LOGGER.trace("name was set");
        this.name = name;
    }

    public void setSurname(String surname) {
        if(!surname.matches(NAME_SURNAME_REGEX)){
            LOGGER.error(NotMatchRegexException.MESSAGE_FULL_NAME);
            throw new NotMatchRegexException(NotMatchRegexException.MESSAGE_FULL_NAME);
        }
        LOGGER.trace("surname was set");
        this.surname = surname;
    }

    public void setEmail(String email) {
        if (!email.matches(EMAIL_REGEX)) {
            LOGGER.error(NotMatchRegexException.MESSAGE_EMAIL);
            throw new NotMatchRegexException(NotMatchRegexException.MESSAGE_EMAIL);
        }
        LOGGER.trace("email was set");
        this.email = email;
    }

    public void setPassword(String password) {
        if (!password.matches(PASSWORD_REGEX)){
            LOGGER.error(NotMatchRegexException.MESSAGE_PASSWORD);
            throw new NotMatchRegexException(NotMatchRegexException.MESSAGE_PASSWORD);
        }
        LOGGER.trace("password was set");
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(!phoneNumber.matches(PHONE_REGEX)){
            LOGGER.error(NotMatchRegexException.MESSAGE_PHONE);
            throw new NotMatchRegexException(NotMatchRegexException.MESSAGE_PHONE);
        }
        LOGGER.trace("phone number was set");
        this.phoneNumber = PHONE_NUMBER_PREFIX + phoneNumber;
    }

    public void setReviews(List<Review> reviews) {
        LOGGER.trace("reviews were set");
        this.reviews = reviews;
    }

    public void setRole(Role role) {
        LOGGER.trace("role was set");
        this.role = role;
    }

    public void setStatus(UserStatus status) {
        LOGGER.trace("status was set");
        this.status = status;
    }

    public void setOrders(List<Order> orders) {
        LOGGER.trace("orders were set");
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
