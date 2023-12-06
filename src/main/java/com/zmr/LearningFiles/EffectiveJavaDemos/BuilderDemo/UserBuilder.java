package com.zmr.LearningFiles.EffectiveJavaDemos.BuilderDemo;

public class UserBuilder {
    private String userName;
    private String password;
    private String sex;
    private Integer age;
    private String email;
    private String address;

    public static class Builder {
        // required parameters
        private final String userName;
        private final String password;
        private final String email;

        // optional parameters
        private String sex;
        private Integer age;
        private String address;

        public Builder(String userName, String password, String email) {
            this.userName = userName;
            this.password = password;
            this.email = email;
        }

        public Builder sex(String val) {
            sex = val;
            return this;
        }

        public Builder age(Integer val) {
            age = val;
            return this;
        }

        public Builder address(String val) {
            address = val;
            return this;
        }

        public UserBuilder build() {
            return new UserBuilder(this);
        }
    }

    private UserBuilder(Builder builder) {
        userName = builder.userName;
        password = builder.password;
        sex = builder.sex;
        age = builder.age;
        email = builder.email;
        address = builder.address;
    }
}
