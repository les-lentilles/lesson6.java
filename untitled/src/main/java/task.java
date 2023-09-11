import java.util.*;

public class task {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Альшевская", "111111111");
        addContact(phoneBook, "Маргевич", "222222222");
        addContact(phoneBook, "Малышка", "333333333");
        addContact(phoneBook, "Альшевская", "444444444");

        printPhoneBook(phoneBook);
    }

    public static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            List<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }
    public static void printPhoneBook(Map<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());

        Collections.sort(sortedEntries, (a, b) -> b.getValue().size() - a.getValue().size());

        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}