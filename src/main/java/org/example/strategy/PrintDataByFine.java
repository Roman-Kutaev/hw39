package org.example.strategy;

import org.example.Fine;
import org.example.Person;
import static org.example.utils.PersonInfoHelper.readObject;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PrintDataByFine implements Action{
    Map<Person, List<Fine>> personList;

    @Override
    public void doAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип штрафа");
        String type = scanner.nextLine();
        personList = readObject();
        System.out.println("Существующие штрафы данного типа: ");
        for (List<Fine> fines : personList.values()) {
            if (fines.contains(new Fine(type))) {
                System.out.println(fines);
            }
        }
    }
}