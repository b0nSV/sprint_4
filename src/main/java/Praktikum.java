public class Praktikum {

    public static void main(String[] args) {
        /*
             В этом методе заложи логику работы с классом Account.
             Нужно создать экземпляр класса Account: в качестве аргумента передать тестируемое имя
             и вызвать метод, который проверяет, можно ли использовать фамилию и имя для печати на банковской карте.
         */
        for (String arg : args) {
            var account = new Account(arg);
            account.checkNameToEmboss();
            System.out.printf("Для имени %s результат проверки возможности печати на карте: %s%n"
                    , arg, account.checkNameToEmboss());
        }
    }
}
