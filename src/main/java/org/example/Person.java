package org.example;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Comparable<Person>, Serializable {
    private String name;
    private int identificationCode;
    private String town;

    public Person() {
    }

    public Person(String town) {
        this.town = town;
    }

    public Person(int identificationCode) {
        this.identificationCode = identificationCode;
    }

    public Person(String name, int identificationCode, String town) {
        this.name = name;
        this.identificationCode = identificationCode;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getIdentificationCode() {
        return identificationCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setIdentificationCode(int identificationCode) {
        this.identificationCode = identificationCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return identificationCode == person.identificationCode ||
                town.equals(person.town);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificationCode);
    }

    @Override
    public String toString() {
        return name +
                " ИНН = " + identificationCode +
                ", город - " + town + ".";
    }

    @Override
    public int compareTo(Person o) {
        return identificationCode - o.identificationCode;
    }
}
