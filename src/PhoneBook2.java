import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

// Реализуйте структуру телефонной книги с помощью Map, учитывая, 
// что 1 человек может иметь несколько телефонов и у человека уникальное имя. 
// Поработать с методами Map.
// Отсортировать Map в обратном порядке.

public class PhoneBook2 {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> phoneBook = new LinkedHashMap <>();

        phoneBook.put("Иванов", new ArrayList<>(Arrays.asList("0-001", "0-002", "0-003")));
        phoneBook.put("Задень", new ArrayList<>(Arrays.asList("1-111", "1-112", "1-113")));
        phoneBook.put("Скажем", new ArrayList<>(Arrays.asList("2-221", "2-222")));
        phoneBook.put("Баю-Бай", new ArrayList<>(Arrays.asList("3-331", "3-332")));

        // добавление нового номера абоненту с проверкой, что такой абонент уже есть в map.
        addNummer ((LinkedHashMap<String, ArrayList<String>>) phoneBook,
                   (String) "Баю-Бай", (String) "8-881");
        System.out.println("Телефонная книга :\n" + phoneBook);

        // удаление номера абонента с проверкой, что такой абонент и такой номер у него есть в map.
        removeNummer ((LinkedHashMap<String, ArrayList<String>>) phoneBook,
                   (String) "Баю-Бай", (String) "8-881");
        System.out.println("Телефонная книга после удаления одного номера :\n" + phoneBook);

        printReverseMap((LinkedHashMap<String, ArrayList<String>>) phoneBook);       
    }
        public static void printReverseMap (LinkedHashMap<String, ArrayList<String>> mapBook) {
        
        Map<String, ArrayList<String>> sortedPhoneBook = new LinkedHashMap<>();
        List<String> allKeys = new ArrayList<String>(mapBook.keySet());
        Collections.reverse(allKeys);
        for (String key : allKeys) {
            sortedPhoneBook.put(key, mapBook.get(key));
        }
        System.out.println("Телефонная книга в обратном порядке :\n" + sortedPhoneBook);
    }
        public static void addNummer (LinkedHashMap<String, ArrayList<String>> phoneBook,
                                     String name, String nummer) {
        if (!phoneBook.keySet().contains(name)) {
        throw new NoSuchElementException("Такого абонента не существует!");
        }
        else {
            phoneBook.get(name).add(nummer);
        }
    }
        public static void removeNummer (LinkedHashMap<String, ArrayList<String>> phoneBook,
                                     String name, String nummer) {
        if (!phoneBook.keySet().contains(name)) {
        throw new NoSuchElementException("Такого абонента не существует!");
        }
        else if (!phoneBook.get(name).contains(nummer)) {
            throw new NoSuchElementException("Такого номера нет у данного абонента!");
            }
        else {
            phoneBook.get(name).remove(nummer);
        }
    }
}
