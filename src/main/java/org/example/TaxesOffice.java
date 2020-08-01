package org.example;

import org.example.strategy.AddPerson;
import org.example.strategy.PrintAllData;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Реализовать базу данных налоговой инспекции по штрафам. Идентифицировать конкретного человека
 * будет его персональный идентификационный код. У одного человека может быть много штрафов
 * <p>
 * Реализовать:
 * 1. Полная распечатка базы данных.
 * 2. Распечатка данных по конкретному коду.
 * 3. Распечатка данных по конкретному типу штрафа.
 * 4. Распечатка данных по конкретному городу.
 * 5. Добавление нового человека с информацией о нем.
 * 6. Добавление новых штрафов для уже существующей записи.
 * 7. Удаление штрафа.
 * 8. Замена информации о человеке и его штрафах.
 * <p>
 * Использовать сериализацию для сохранения/считывания данных
 */

public class TaxesOffice {
    public static void main(String[] args) {
        Map<Person, List<Fine>> personList = new TreeMap<>();
        Menu taxesOffice = new Menu("Добро пожаловать в приложение!");
        taxesOffice.add(new Menu("Полная распечатка базы данных.", new PrintAllData()));
        taxesOffice.add(new Menu("Распечатка данных по конкретному коду.", () -> System.out.println("Action for item2")));
        taxesOffice.add(new Menu("Распечатка данных по конкретному типу штрафа.", () -> System.out.println("Action for item3")));
        taxesOffice.add(new Menu("Распечатка данных по конкретному городу.", () -> System.out.println("Action for item4")));
        taxesOffice.add(new Menu("Добавление нового человека с информацией о нем.", new AddPerson()));
        taxesOffice.add(new Menu("Добавление новых штрафов для уже существующей записи.", () -> System.out.println("Action for item6")));
        taxesOffice.add(new Menu("Удаление штрафа.", () -> System.out.println("Action for item7")));
        taxesOffice.add(new Menu("Замена информации о человеке.", () -> System.out.println("Action for item8")));
        taxesOffice.add(new Menu("Выход.", () -> saveObject(personList)));

        taxesOffice.show();
    }
    private static Map<Person, List<Fine>> readObject() {
        Map<Person, List<Fine>> personList = null;
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream("base.dat"))) {
            personList = (Map<Person, List<Fine>>) objectInput.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return personList;
    }

    private static void saveObject(Map<Person, List<Fine>> personList) {
        for (Person person : personList.keySet()) {
            try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream("base.dat"))) {
                output.writeObject(personList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
