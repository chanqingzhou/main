package seedu.address.testutil;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import seedu.address.model.restaurant.Address;
import seedu.address.model.restaurant.Email;
import seedu.address.model.restaurant.Name;
import seedu.address.model.restaurant.Phone;
import seedu.address.model.restaurant.Restaurant;
import seedu.address.model.restaurant.categories.Cuisine;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Restaurant objects.
 */
public class RestaurantBuilder {

    public static final String DEFAULT_NAME = "Kentucky Fried Chicken";
    public static final String DEFAULT_PHONE = "65355255";
    public static final String DEFAULT_EMAIL = "kfc@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Set<Tag> tags;
    private Cuisine cuisine;

    public RestaurantBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        tags = new HashSet<>();
        cuisine = null;
    }

    /**
     * Initializes the RestaurantBuilder with the data of {@code restaurantToCopy}.
     */
    public RestaurantBuilder(Restaurant restaurantToCopy) {
        name = restaurantToCopy.getName();
        phone = restaurantToCopy.getPhone();
        email = restaurantToCopy.getEmail();
        address = restaurantToCopy.getAddress();
        tags = new HashSet<>(restaurantToCopy.getTags());
        cuisine = restaurantToCopy.getCuisine().isPresent() ? restaurantToCopy.getCuisine().get() : null;
    }

    /**
     * Sets the {@code Name} of the {@code Restaurant} that we are building.
     */
    public RestaurantBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Restaurant} that we are building.
     */
    public RestaurantBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Restaurant} that we are building.
     */
    public RestaurantBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Restaurant} that we are building.
     */
    public RestaurantBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Restaurant} that we are building.
     */
    public RestaurantBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Cuisine} of the {@code Restaurant} that we are building.
     */
    public RestaurantBuilder withCuisine(String cuisine) {
        this.cuisine = new Cuisine(cuisine);
        return this;
    }

    public Restaurant build() {
        return new Restaurant(name, phone, email, address, tags, Optional.ofNullable(cuisine));
    }

}
