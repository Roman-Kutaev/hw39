package org.example.strategy;

import org.example.Fine;
import org.example.Person;
import org.example.utils.PersonInfoHelper;

import static org.example.utils.PersonInfoHelper.readObject;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddFine implements Action {
    Map<Person, List<Fine>> personList;

    @Override
    public void doAction() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите ИНН человека которому добавляется штраф");
        int inn = scanner.nextInt();
        File file = new File("base.dat");
        if (file.exists()) {
            personList = readObject();
            System.out.println("Введите тип штрафа:");
            String type = scanner1.nextLine();
            System.out.println("Сумма:");
            int sum = scanner.nextInt();
            personList.get(new Person(inn)).add(new Fine(type, sum));
            PersonInfoHelper.saveObject(personList);
            System.out.println("Новый штраф добавлен.");
        }
    }
}
