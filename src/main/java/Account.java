
public class Account {

    private final String name;

    public static final int minNameLength = 3;

    public static final int maxNameLength = 19;

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

        if (name == null) {
            return false;
        }
        if (name.startsWith(" ") || name.endsWith(" ")) {
            return false;
        }
        if (name.length() - 1 != name.replace(" ", "").length()) {
            return false;
        }

        if (name.length() < minNameLength || name.length() > maxNameLength) {
            return false;
        }
        return true;
    }
}
