package org.example.strategy;

import org.example.Fine;
import org.example.Person;
import org.example.utils.PersonInfoHelper;
import static org.example.utils.PersonInfoHelper.readObject;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DeletionFine implements Action {
    Map<Person, List<Fine>> personList;

    @Override
    public void doAction() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите ИНН человека которому удаляется штраф");
        int inn = scanner.nextInt();
        File file = new File("base.dat");
        if (file.exists()) {
            personList = readObject();
            System.out.println("Введите тип штрафа который необходимо удалить:");
            String type = scanner1.nextLine();
            personList.get(new Person(inn)).remove(new Fine(type));
            PersonInfoHelper.saveObject(personList);
            System.out.println("Штраф удален.");

        }
    }
}
