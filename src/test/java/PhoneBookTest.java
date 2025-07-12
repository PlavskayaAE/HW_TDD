import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.PhoneBook;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {

    public static PhoneBook phoneBook;

    @BeforeEach
    public void setPhoneBook() {
        phoneBook = new PhoneBook();
    }

    @Test
    public void testAdd_NewContact() {
        int countNewContact = phoneBook.add("Name", "89001002233");
        assertEquals(1, countNewContact, "После добавления первого контакта должно быть возвращено значение 1");
    }

    @Test
    public void testAdd_DifferentContacts() {
        int countDifferentContacts = phoneBook.add("Name1", "89001002233");
        countDifferentContacts = phoneBook.add("Name2", "89001003344");
        assertEquals(2, countDifferentContacts, "При добавлении двух контактов с разными именами счетчик контактов 2");
    }

    @Test
    public void testAdd_Dublicate() {
        phoneBook.add("Name3", "89001002233");
        int count_Dublicate = phoneBook.add("Name3", "89001002244");
        assertEquals(1, count_Dublicate, "Добавление контакта с таким же именем не влечет увеличение количество контактов");
    }

    @Test
    public void testAdd_InvalidNumber() {
        int count_InvalidNumber_short = phoneBook.add("Name4", "8900");
        int count_InvalidNumber_long = phoneBook.add("Name5", "89001002004000");
        assertEquals(0, count_InvalidNumber_short, "Длина номера слишком короткая, поэтому контакт не добавлен");
        assertEquals(0, count_InvalidNumber_long, "Длина номера слишком большая, поэтому контакт не добавлен");

    }

    @Test
    public void testAdd_NullNameOrNumber() {
        int countNullName = phoneBook.add(null, "12345");
        int countNullNumber = phoneBook.add("Name6", null);
        assertEquals(0, countNullName, "Добавление с null именем не увеличивает количество контактов");
        assertEquals(0, countNullNumber, "Добавление с null номером не увеличивает количество контактов");
    }

    @Test
    public void testAdd_EmptyNameOrNumber() {
        int countEmptyName = phoneBook.add("", "12345");
        int countEmptyNumber = phoneBook.add("Name7", "");
        assertEquals(0, countEmptyName);
        assertEquals(0, countEmptyNumber);
    }
}
