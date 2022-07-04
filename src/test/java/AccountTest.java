import org.junit.Test;

import static helpers.RandomSequences.createRandomAccountNameAllowedString;
import static org.junit.Assert.*;

public class AccountTest {
    String name;
    Account account;
    int minNameLength = Account.minNameLength;
    int maxNameLength = Account.maxNameLength;

    @Test
    public void checkNameToEmbossMinLengthTrue() {
        name = String.format("%s %s", createRandomAccountNameAllowedString(minNameLength - (minNameLength - 1))
                , createRandomAccountNameAllowedString(minNameLength - 2));
        account = new Account(name);
        assertTrue("Ожидалось, что функция вернет true при использовании name с минимально допустимой длинной"
                , account.checkNameToEmboss());
    }

    @Test
    public void checkNameToEmbossMaxLengthTrue() {
        name = String.format("%s %s", createRandomAccountNameAllowedString(maxNameLength - (maxNameLength - 1))
                , createRandomAccountNameAllowedString(maxNameLength - 2));
        account = new Account(name);
        assertTrue("Ожидалось, что функция вернет true при использовании name с максимально допустимой длинной"
                , account.checkNameToEmboss());
    }

    @Test
    public void checkNameToEmbossShorterThenMinLengthFalse() {
        name = createRandomAccountNameAllowedString(minNameLength - 1);
        account = new Account(name);
        assertFalse("Ожидалось, что функция вернет false при использовании name с меньше чем минимально допустимой длинной"
                , account.checkNameToEmboss());
    }

    @Test
    public void checkNameToEmbossLargerThenMaxLengthFalse() {
        name = String.format("%s %s", createRandomAccountNameAllowedString(maxNameLength - (maxNameLength - 1))
                , createRandomAccountNameAllowedString(maxNameLength - 1));
        account = new Account(name);
        assertFalse("Ожидалось, что функция вернет false при использовании name с больше чем максимально допустимой длинной"
                , account.checkNameToEmboss());
    }

    @Test
    public void checkNameToEmbossTwoSpacesBetweenNamePartsFalse() {
        name = String.format("%s  %s", createRandomAccountNameAllowedString(minNameLength), createRandomAccountNameAllowedString(minNameLength));
        account = new Account(name);
        assertFalse("Ожидалось, что функция вернет false при проверке name с больше чем одним пробелом между частями"
                , account.checkNameToEmboss());
    }

    @Test
    public void checkNameToEmbossNoSpacesBetweenNamePartsFalse() {
        name = String.format("%s%s", createRandomAccountNameAllowedString(minNameLength), createRandomAccountNameAllowedString(minNameLength));
        account = new Account(name);
        assertFalse("Ожидалось, что функция вернет false при проверке name без пробела между частями"
                , account.checkNameToEmboss());
    }

    @Test
    public void checkNameToEmbossNameStartsWithSpaceFalse() {
        name = String.format(" %s %s", createRandomAccountNameAllowedString(minNameLength), createRandomAccountNameAllowedString(minNameLength));
        account = new Account(name);
        assertFalse("Ожидалось, что функция вернет false при проверке name c пробелом в начале строки"
                , account.checkNameToEmboss());
    }

    @Test
    public void checkNameToEmbossNameEndsWithSpaceFalse() {
        name = String.format("%s %s ", createRandomAccountNameAllowedString(minNameLength), createRandomAccountNameAllowedString(minNameLength));
        account = new Account(name);
        assertFalse("Ожидалось, что функция вернет false при проверке name c пробелом в конце строки"
                , account.checkNameToEmboss());
    }

    @Test
    public void checkNameToEmbossNameIsNullFalse() {
        account = new Account(null);
        assertFalse("Ожидалось, что функция вернет false при проверке name со значением null"
                , account.checkNameToEmboss());
    }
}