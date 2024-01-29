
package ru.netology.web;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateCity() {
        String[] cities = new String[]{"Архангельск", "Барнаул", "Брянск", "Воронеж", "Казань", "Красноярск",
                "Липецк", "Москва", "Магадан", "Новосибирск", "Оренбург", "Пермь", "Псков", "Самара", "Саратов",
                "Смоленск", "Тверь", "Томск", "Уфа", "Хабаровск", "Ярославль"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateDate(int addDays) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static class Registration {
        private Registration() {
        }

        public static RegistrationData generateUser(String locale) {
            Faker faker = new Faker(new Locale("ru"));
            return new RegistrationData(
                    generateCity(),
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber()
            );
        }
    }

    @Value
    public static class RegistrationData {
        String city;
        String name;
        String phone;
    }
}