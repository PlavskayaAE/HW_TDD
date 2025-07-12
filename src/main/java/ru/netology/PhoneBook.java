package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private static Map<String, String> contacts = new HashMap<>();
    private static int size;

    public static int add(String name, String number) {
        if (name == null || number == null|| name.isEmpty() || number.isEmpty()) {
            System.out.println("Oшибка! Имя контакта и номер должны быть заполнены!");
        } else {
            if (number.length() != 11) {
                System.out.println("Ошибка! Номер должен состоять из 11 символов!");
            } else {
                if (contacts.containsKey(name)) {
                    System.out.println("Ошибка! Контакт с таким именем уже существует!");
                } else {
                    contacts.put(name, number);
                    size++;
                }
            }
        }

        return size;

    }

}
