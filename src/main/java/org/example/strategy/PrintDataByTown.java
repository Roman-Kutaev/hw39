package org.example.strategy;

import org.example.Fine;
import org.example.Person;
import static org.example.utils.PersonInfoHelper.readObject;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PrintDataByTown implements Action {
    Map<Person, List<Fine>> personList;

    @Override
    public void doAction() {
        Scanner scanner = new Scanner(System.in);
        personList = readObject();
        System.out.println("Введите название города:");
        String town = scanner.nextLine();
        System.out.println("Штрафники данного города: ");
        for (Person p : personList.keySet()) {
            if (p.equals(new Person(town))) {
                System.out.println(p + " Список штрафов человека - " + personList.get(p));
            }
        }
    }
}
