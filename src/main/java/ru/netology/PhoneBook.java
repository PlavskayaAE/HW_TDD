package ru.netology;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class PhoneBook {
    private static Map<String, String> contactsKeyIsName = new HashMap<>();
    private static Map<String, String> contactsKeyIsNumber = new HashMap<>();
    private static TreeSet<String> names = new TreeSet<>();

    public static int add(String name, String number) {
        if (name == null || number == null || name.isEmpty() || number.isEmpty()) {
            System.out.println("Ошибка! Имя контакта и номер должны быть заполнены!");
        } else {
            if (number.length() != 11) {
                System.out.println("Ошибка! Номер должен состоять из 11 символов!");
            } else {
                if (contactsKeyIsName.containsKey(name) || contactsKeyIsNumber.containsKey(number)) {
                    System.out.println("Ошибка! Такой контакт уже существует!");
                } else {
                    contactsKeyIsName.put(name, number);
                    contactsKeyIsNumber.put(number, name);
                }
            }
        }

        return contactsKeyIsName.size();

    }

    public static String findByNumber(String number) {
        return contactsKeyIsNumber.get(number);
    }

    public static String findByName(String name) {
        return contactsKeyIsName.get(name);
    }


    public static String printAllNames() {
        names.addAll(contactsKeyIsName.keySet());
        return names.toString();
    }
}
