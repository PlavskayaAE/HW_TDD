import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.PhoneBook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PhoneBookTest {

    private PhoneBook phoneBook;

    @BeforeEach
    public void setUp() {
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
        int count_Dublicate = phoneBook.add("Name3", "89001002233");
        count_Dublicate = phoneBook.add("Name3", "89001002244");
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

    @Test
    public void testFindByNumber_ok() {
        phoneBook.add("Саша", "89112223344");
        String result_FindByNumber = phoneBook.findByNumber("89112223344");
        String expected = "Саша";
        assertEquals(expected, result_FindByNumber, "Поиск по номеру телефона дает имя контакта");
    }

    @Test
    public void testFindByNumber_UnknownNumber() {
        phoneBook.add("Паша", "89001002233");
        String result_UnknownNumber = phoneBook.findByNumber("8900000000");
        assertNull(result_UnknownNumber, "При введении номера, отсутствующего в книге, возвращается null");
    }

    @Test
    public void testFindByName_ok() {
        phoneBook.add("Name", "89001002233");
        String result_FindByName = phoneBook.findByName("Name");
        String expected = "89001002233";
        assertEquals(expected, result_FindByName);
    }

    @Test
    public void testFindByName_UnknownName() {
        phoneBook.add("Name33", "89123336699");
        String result_UnknownName = phoneBook.findByName("Name789");
        assertNull(result_UnknownName);
    }

    @Test
    public void testPrintAllNames_Eng() {
        phoneBook.add("AName", "12345678900");
        phoneBook.add("CName", "77777777777");
        phoneBook.add("DName", "99999999999");
        phoneBook.add("BName", "89565696363");

        String result_printAllNames = phoneBook.printAllNames();
        String expected = "[AName, BName, CName, DName]";
        assertEquals(expected, result_printAllNames);
    }

    @Test
    public void testPrintAllNames_Ru() {
        phoneBook.add("Маша", "12345678900");
        phoneBook.add("Настя", "77777777777");
        phoneBook.add("Дарья", "99999999999");
        phoneBook.add("Филипп", "89565696363");

        String result_printAllNames = phoneBook.printAllNames();
        String expected = "[Дарья, Маша, Настя, Филипп]";
        assertEquals(expected, result_printAllNames);
    }

    @Test
    public void testPrintAllNames_empty() {
        String result_printAllNames = phoneBook.printAllNames();
        String expected = "[]";
        assertEquals(expected, result_printAllNames);
    }

}
