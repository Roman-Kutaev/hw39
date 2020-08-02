package org.example;

import org.example.strategy.*;

public class TaxesOffice {
    public static void main(String[] args) {
        Menu taxesOffice = new Menu("Добро пожаловать в приложение!");
        taxesOffice.add(new Menu("Полная распечатка базы данных.", new PrintAllData()));
        taxesOffice.add(new Menu("Распечатка данных по конкретному коду.", new PrintDataByInn()));
        taxesOffice.add(new Menu("Распечатка данных по конкретному типу штрафа.", new PrintDataByFine()));
        taxesOffice.add(new Menu("Распечатка данных по конкретному городу.", new PrintDataByTown()));
        taxesOffice.add(new Menu("Добавление нового человека с информацией о нем.", new AddPerson()));
        taxesOffice.add(new Menu("Добавление новых штрафов для уже существующей записи.", new AddFine()));
        taxesOffice.add(new Menu("Удаление штрафа.", new DeletionFine()));
        taxesOffice.add(new Menu("Замена информации о человеке.", new ChangPersonData()));
        taxesOffice.add(new Menu("Выход.", () -> System.out.println("До свидания.")));

        taxesOffice.show();
    }
}
