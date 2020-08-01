package org.example.strategy;

import org.example.Fine;
import org.example.Person;
import org.example.utils.PersonInfoHelper;
import static org.example.utils.PersonInfoHelper.readObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class AddPerson implements Action {
    Map<Person, List<Fine>> personList;

    @Override
    public void doAction() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите Имя человека");
        String name = scanner.nextLine();

        System.out.println("Введите название города");
        String town = scanner.nextLine();

        System.out.println("Введите ИНН");
        int inn = scanner.nextInt();

        personList = readObject();
        personList.put(new Person(name, inn, town), new ArrayList<>());
        PersonInfoHelper.saveObject(personList);
        System.out.println("Новый человек добавлен в базу.");
    }
}
