package org.example.utils;

import org.example.Fine;
import org.example.Person;

import java.io.*;
import java.util.List;
import java.util.Map;

public class PersonInfoHelper {
    public static void saveObject(Map<Person, List<Fine>> personList) {
        for (Person person : personList.keySet()) {
            try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream("base.dat"))) {
                output.writeObject(personList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<Person, List<Fine>> readObject() {
        Map<Person, List<Fine>> personList = null;
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream("base.dat"))) {
            personList = (Map<Person, List<Fine>>) objectInput.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return personList;
    }
}
