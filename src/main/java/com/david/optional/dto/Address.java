package com.david.optional.dto;

import java.util.Objects;
import java.util.Optional;

public class Address {

    private final String addressLine;  // never null
    private final String city;         // never null
    private final String postcode;     // optional, thus may be null

    // constructor ensures non-null fields really are non-null
    // optional field can just be stored directly, as null means optional
    public Address(String addressLine, String city, String postcode) {
        this.addressLine = Objects.requireNonNull(addressLine, "addressLine is required");
        this.city = Objects.requireNonNull(city);
        this.postcode = postcode;
    }

    // normal getters
    public String getAddressLine() { return addressLine; }
    public String getCity() { return city; }

    // special getter for optional field
    public Optional<String> getPostcode() {
        return Optional.ofNullable(postcode);
    }

}
