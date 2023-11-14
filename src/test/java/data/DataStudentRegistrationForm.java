package data;


import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class DataStudentRegistrationForm {


    Faker faker = new Faker(new Locale("ru"));
    Faker emailfaker = new Faker(new Locale("en-GB"));
    RandomValue randomValue = new RandomValue();

    String[] stateMassive = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    public String[] keyMassive = {"Student Name", "Student Email", "Gender", "Mobile", "Date of Birth",
            "Subjects", "Hobbies", "Picture", "Address", "State and City"};

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = emailfaker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            mobileNumber = faker.phoneNumber().subscriberNumber(10),
            mouth = faker.options().option("January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"),
            day = randomValue.getDayDependingOnMouth(mouth),
            year = randomValue.getRandomIntToString(1990, 2005),
            subjectValue = faker.options().option("A", "B", "C", "D", "E", "J",
                    "K", "O", "P", "Q", "S", "U"),
            pictureName = "photo_cat.jpg",
            hobbieValue = faker.options().option("Sports", "Reading", "Music"),
            address = faker.address().streetAddress(),
            stateButton = "#state",
            stateName = randomValue.getRandomItemFromArray(stateMassive),
            cityButton = "#city",
            cityName = randomValue.getCityDependingOnState(stateName);

    class RandomValue {
        public String getRandomItemFromArray(String[] array) {
            int index = getRandomInt(0, array.length - 1);
            return array[index];
        }

        public int getRandomInt(int min, int max) {

            return ThreadLocalRandom.current().nextInt(min, max + 1);
        }

        public String getRandomIntToString(int min, int max) {
            return String.valueOf(ThreadLocalRandom.current().nextInt(min, max + 1));
        }

        public String getCityDependingOnState(String stateName) {
            Faker faker = new Faker();
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

        public String getDayDependingOnMouth(String mouth) {
            String day = "";
            switch (mouth) {
                case "January":
                case "March":
                case "May":
                case "July":
                case "August":
                case "December":
                    day = faker.options().option("01", "02", "03", "04", "05", "06", "07", "08", "09",
                            "10", "11", "12", "13", "14", "15", "16", "17", "18",
                            "19", "20", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
                    break;
                case "April":
                case "June":
                case "September":
                case "November":
                    day = faker.options().option("01", "02", "03", "04", "05", "06", "07", "08", "09",
                            "10", "11", "12", "13", "14", "15", "16", "17", "18",
                            "19", "20", "22", "23", "24", "25", "26", "27", "28", "29", "30");
                    break;
                case "February":
                    day = faker.options().option("01", "02", "03", "04", "05", "06", "07", "08", "09",
                            "10", "11", "12", "13", "14", "15", "16", "17", "18",
                            "19", "20", "22", "23", "24", "25", "26", "27", "28");
                    break;
            }
            return day;
        }

    }

}




