package org.example.strategy;

import org.example.Fine;
import org.example.Person;
import static org.example.utils.PersonInfoHelper.readObject;
import org.example.utils.PersonInfoHelper;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ChangPersonData implements Action {
    Map<Person, List<Fine>> personList;

    @Override
    public void doAction() {
        Scanner scanner = new Scanner(System.in);
        personList = readObject();
        System.out.println("Введите ИНН человека которому будут вноситься изменения");
        int inn = scanner.nextInt();
        for (Person person : personList.keySet()) {
            if (person.equals(new Person(inn))) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Введите новое имя человека");
                String name = scanner1.nextLine();
                System.out.println("Введите название нового города");
                String town = scanner1.nextLine();
                person.setName(name);
                person.setTown(town);
                PersonInfoHelper.saveObject(personList);
                System.out.println("Данные изменены.");
            }
        }
    }
}

