package data;


import com.github.javafaker.Faker;

import java.util.Locale;

public class DataStudentRegistrationForm {

    Faker faker = new Faker(new Locale("ru"));
    Faker fakerEN = new Faker(new Locale("en-GB"));
    RandomValue randomValue = new RandomValue();

    public String[] keyMassive = {"Student Name", "Student Email", "Gender", "Mobile", "Date of Birth",
            "Subjects", "Hobbies", "Picture", "Address", "State and City"};

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = fakerEN.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            mobileNumber = faker.phoneNumber().subscriberNumber(10),
            month = faker.options().option("January", "February", "March", "April", "May",
                          "June","July", "August", "September", "October", "November", "December"),
            day = randomValue.getDayDependingOnMonth(month),
            year = String.valueOf(faker.number().numberBetween(1960,1999)),
            subjectValue = faker.options().option("A", "B", "C", "D", "E",
                             "O", "P", "R", "S", "U"),
            pictureName = "photo_cat.jpg",
            hobbieValue = faker.options().option("Sports", "Reading", "Music"),
            address = faker.address().streetAddress(),
            stateName = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            cityName = randomValue.getCityDependingOnState(stateName);

    class RandomValue {

        public String getCityDependingOnState(String stateName) {
            switch (stateName) {
                case "NCR":
                    return faker.options().option("Delhi", "Gurgaon", "Noida");
                case "Uttar Pradesh":
                    return faker.options().option("Agra", "Lucknow", "Merrut");
                case "Haryana":
                    return faker.options().option("Karnal", "Panipat");
                case "Rajasthan":
                    return faker.options().option("Jaipur", "Jaiselmer");
                default:
                    throw new IllegalArgumentException("Invalid state: " + stateName);
            }

        }
        public String getDayDependingOnMonth(String month) {
            switch (month) {
                case "January":
                case "March":
                case "May":
                case "July":
                case "August":
                case "December":
                    return faker.options().option("01", "02", "03", "04", "05", "06", "07", "08", "09",
                            "10", "11", "12", "13", "14", "15", "16", "17", "18",
                            "19", "20", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
                case "April":
                case "June":
                case "September":
                case "November":
                   return faker.options().option("01", "02", "03", "04", "05", "06", "07", "08", "09",
                            "10", "11", "12", "13", "14", "15", "16", "17", "18",
                            "19", "20", "22", "23", "24", "25", "26", "27", "28", "29", "30");
                case "February":
                    return faker.options().option("01", "02", "03", "04", "05", "06", "07", "08", "09",
                            "10", "11", "12", "13", "14", "15", "16", "17", "18",
                            "19", "20", "22", "23", "24", "25", "26", "27", "28");
                default:
                    throw new IllegalArgumentException("Invalid state: " + cityName);
            }
        }


    }

}




