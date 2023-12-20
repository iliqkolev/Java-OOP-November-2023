package org.example;

public class Address {
    private String name;
    private String email;

    private Address() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Address address;

        private Builder() {
            this.address = new Address();
        }

        public Builder withName(String name) {
            address.name = name;
            return this;
        }

        public Builder withEmail(String email) {
            address.email = email;
            return this;
        }

        public Address build() {
            return address;
        }

    }

}
