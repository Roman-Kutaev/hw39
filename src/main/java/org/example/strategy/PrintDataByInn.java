package org.example.strategy;

import org.example.Fine;
import org.example.Person;
import static org.example.utils.PersonInfoHelper.readObject;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PrintDataByInn implements Action {
    Map<Person, List<Fine>> personList;

    @Override
    public void doAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ИНН человека по которому хотите получить распечатку данных");
        int inn = scanner.nextInt();
        personList = readObject();
        for (Person p : personList.keySet()) {
            if (p.equals(new Person(inn))) {
                System.out.println(p + " Список штрафов человека - " + personList.get(p).toString());
            }
        }
    }
}
