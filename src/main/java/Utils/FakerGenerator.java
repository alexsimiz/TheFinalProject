package Utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerGenerator {
    private Locale locale = new Locale("en-US");
    private Faker faker = new Faker(locale);

    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String address = faker.address().streetAddress();
    private String city = faker.address().city();
    private String phone = faker.number().digits(10);

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }
}
