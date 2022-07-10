
public class Account {

    private final String name;

    public static final int MIN_NAME_LENGTH = 3;

    public static final int MAX_NAME_LENGTH = 19;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
            Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
            Если строка удовлетворяет условиям, метод возвращает true, иначе — false.

            1. в строке не меньше 3 и не больше 19 символов,
            2. в строке есть только один пробел,
            3. пробел стоит не в начале строки
            4. пробел стоит не в конце строки.
         */
        return name != null && name.matches(String.format("^(?=.{%s,%s}$)\\S+ \\S+", MIN_NAME_LENGTH, MAX_NAME_LENGTH));
    }
}
