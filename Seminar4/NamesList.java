/*
 * Создайте коллекцию мужских и женских имен с помощью интерфейса List
 * Отсортируйте коллекцию в алфавитном порядке
 * Отсортируйте коллекцию по количеству букв в слове
 * Разверните коллекцию
 */

 /*
  * Создайте коллекцию мужских и женских имен с помощью интерфейса List - добавьте повторяющиеся значения
  * Получите уникальный список Set на основании List
  * Определите наименьший элемент (алфавитный порядок)
  * Определите наибольший элемент (по количеству букв в слове но в обратном порядке)
  * Удалите все элементы содержащие букву ‘A’
  */

  /*
   * Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
   * Найдите человека с самым маленьким номером телефона
   * Найдите номер телефона человека чье имя самое большое в алфавитном порядке
   */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class NamesList {
public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Алексей");
        names.add("Иван");
        names.add("Иван");
        names.add("Олег");
        names.add("Максим");
        names.add("Анна");
        names.add("Ольга");
        names.add("Ксения");
        names.add("Анастасия");
        names.add("Светлана");
        names.sort(String::compareTo);
        System.out.println(names);

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()<o2.length())
                    return 1;
                else if (o2.length()<o1.length())
                    return -1;
                return 0;
            }
        };

        names.sort(comparator);
        System.out.println(names);
        names.sort(Comparator.reverseOrder());
        System.out.println(names);


        Set<String> setStr = new HashSet<>(names);
        System.out.println(setStr);
        names.sort(String::compareTo);
        String name = names.get(0);
        System.out.println(name);
        List<String> namesList = new ArrayList<>();

        for (String str : names) {
            if(!str.contains("А") && !str.contains("а")) {
                namesList.add(str);
            };
        }
        System.out.println(namesList);

        

        Map<String, String> phonebook = new HashMap<>();
        phonebook.put("1235", "User1");
        phonebook.put("1234", "User2");
        phonebook.put("1236", "User3");
        phonebook.put("1237", "User4");
        phonebook.put("1238", "User5");
        phonebook.put("1239", "User6");
        int numMax = 0;
        for (String s : phonebook.keySet()) {
            if (Integer.parseInt(s) > numMax) {
                numMax = Integer.parseInt(s);
            }
        }
        System.out.println(numMax);
        List<Map.Entry<String,String>> value = new ArrayList<>(phonebook.entrySet());
        value.sort(Map.Entry.comparingByValue());
        System.out.println(value);




    }
}