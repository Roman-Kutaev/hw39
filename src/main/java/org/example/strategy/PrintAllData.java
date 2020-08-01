package org.example.strategy;

import org.example.Fine;
import org.example.Person;

import java.util.List;
import java.util.Map;

import static org.example.utils.PersonInfoHelper.readObject;

public class PrintAllData implements Action {
    @Override
    public void doAction() {
        Map<Person, List<Fine>> personListMap = readObject();
        System.out.println("Полный список базы данных:");
        for (Map.Entry<Person, List<Fine>> entry : personListMap.entrySet()) {
            System.out.println(entry.getKey() + " Список штрафов человека - " + entry.getValue().toString());
        }
    }
}
