package org.example;

import org.example.strategy.*;

/**
 * Реализовать базу данных налоговой инспекции по штрафам. Идентифицировать конкретного человека
 * будет его персональный идентификационный код. У одного человека может быть много штрафов
 * <p>
 * Реализовать:
 * 1. Полная распечатка базы данных.
 * 2. Распечатка данных по конкретному коду.
 * 3. Распечатка данных по конкретному типу штрафа.
 * 4. Распечатка данных по конкретному городу.
 * 5. Добавление нового человека с информацией о нем.
 * 6. Добавление новых штрафов для уже существующей записи.
 * 7. Удаление штрафа.
 * 8. Замена информации о человеке и его штрафах.
 * <p>
 * Использовать сериализацию для сохранения/считывания данных
 */

public class TaxesOffice {
    public static void main(String[] args) {
        Menu taxesOffice = new Menu("Добро пожаловать в приложение!");
        taxesOffice.add(new Menu("Полная распечатка базы данных.", new PrintAllData()));
        taxesOffice.add(new Menu("Распечатка данных по конкретному коду.", new PrintDataByInn()));
        taxesOffice.add(new Menu("Распечатка данных по конкретному типу штрафа.", new PrintDataByFine()));
        taxesOffice.add(new Menu("Распечатка данных по конкретному городу.", new PrintDataByTown()));
        taxesOffice.add(new Menu("Добавление нового человека с информацией о нем.", new AddPerson()));
        taxesOffice.add(new Menu("Добавление новых штрафов для уже существующей записи.", () -> System.out.println("Action for item6")));
        taxesOffice.add(new Menu("Удаление штрафа.", () -> System.out.println("Action for item7")));
        taxesOffice.add(new Menu("Замена информации о человеке.", () -> System.out.println("Action for item8")));
        taxesOffice.add(new Menu("Выход.", () -> System.out.println("До свидания.")));

        taxesOffice.show();
    }
}
