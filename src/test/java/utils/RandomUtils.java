package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomFirstName());
        System.out.println(getRandomLastName());
        System.out.println(getRandomEmail());
        System.out.println(getRandomGender());
        System.out.println(getRandomPhone());
        System.out.println(getRandomAddress());
    }

    public static String getRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = getRandomInt(0, characters.length() - 1);
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }


    public static int getRandomInt(int min, int max) {
        return int;
    }


    public static String getRandomFirstName() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();

        return firstName;
    }

    public static String getRandomLastName() {
        Faker faker = new Faker();
        String lastName = faker.name().lastName();

        return lastName;
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomItemFromArray(String[] array){
        int index = getRandomInt (0, array.length - 1);

        return array[index];
    }

    public static String getRandomPhone() {
        Faker faker = new Faker();
        String phone = faker.phoneNumber().phoneNumber();

        return phone;
    }


    public static String getRandomEmail() {
        return getRandomString(10) + "@gmail.com";
    }

    public static String getRandomAddress() {
        Faker faker = new Faker();
        String currentAddress = faker.address().fullAddress();

        return currentAddress;
    }

    public static String getRandomBirthday(){
        Faker faker = new Faker();
        Date dayOfBirth = faker.date().birthday();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        return dateFormat.format(dayOfBirth);
    }

    public static String getRandomSubject(){

    }

    public static String getRandomHobby(){

    }

    public static String getRandomFoto(){

    }

    public static String getRandomState(){

    }

    public static String getRandomCity(){

    }
}
