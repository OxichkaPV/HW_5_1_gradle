package ru.netology.delivery.data;
import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        // TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
        // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String locale) {
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя массив валидных городов и класс Random
        String [] cities = new String[] {"Красноярск", "Москва","Новосибирск","Омск","Хабаровск","Ростов-на-дону",
        "Санкт-Петербург","Владивосток","Иркутск","Самара","Ульяновск","Ставрополь","Челябинск","Севастополь","Ярославль",
        "Краснодар","Пенза","Тула","Рязань","Пермь","Свердловск","Севастополь","Смоленск","Белгород","Чита","Курск"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
        // использовать Faker
        Faker fakerName = new Faker(new Locale(locale));
        return fakerName.name().lastName()+" "+fakerName.name().firstName();
    }

    public static String generatePhone(String locale) {
        // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
        // использовать Faker
        Faker fakerPhone = new Faker(new Locale(locale));
        return fakerPhone.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)
            return new UserInfo(generateCity(locale),generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}