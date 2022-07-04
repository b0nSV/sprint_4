import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static helpers.RandomSequences.createRandomAccountNameAllowedString;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {
    String name;
    boolean expectedResult;
    String errorMessage;

    public AccountTest(String name, boolean expectedResult, String errorMessage) {
        this.name = name;
        this.expectedResult = expectedResult;
        this.errorMessage = errorMessage;
    }

    @Parameterized.Parameters(name = " account.name = \"{0}\" | expected result is \"{1}\"")
    public static Object[][] getNameData() {
        int minNameLength = Account.minNameLength;
        int maxNameLength = Account.maxNameLength;
        return new Object[][]{
                {String.format("%s %s", createRandomAccountNameAllowedString(minNameLength - (minNameLength - 1))
                        , createRandomAccountNameAllowedString(minNameLength - 2))
                        , true
                        , "Ожидалось, что функция вернет true при использовании name с минимально допустимой длинной"},

                {String.format("%s %s", createRandomAccountNameAllowedString(maxNameLength - (maxNameLength - 1))
                        , createRandomAccountNameAllowedString(maxNameLength - 2))
                        , true
                        , "Ожидалось, что функция вернет true при использовании name с максимально допустимой длинной",},

                {createRandomAccountNameAllowedString(minNameLength - 1)
                        , false
                        , "Ожидалось, что функция вернет false при использовании name с меньше чем минимально допустимой длинной"},

                {String.format("%s %s", createRandomAccountNameAllowedString(maxNameLength - (maxNameLength - 1))
                        , createRandomAccountNameAllowedString(maxNameLength - 1))
                        , false
                        , "Ожидалось, что функция вернет false при использовании name с больше чем максимально допустимой длинной"},

                {String.format("%s  %s", createRandomAccountNameAllowedString(minNameLength), createRandomAccountNameAllowedString(minNameLength))
                        , false
                        , "Ожидалось, что функция вернет false при проверке name с больше чем одним пробелом между частями"},

                {String.format("%s%s", createRandomAccountNameAllowedString(minNameLength), createRandomAccountNameAllowedString(minNameLength))
                        , false
                        , "Ожидалось, что функция вернет false при проверке name без пробела между частями"},

                {String.format(" %s %s", createRandomAccountNameAllowedString(minNameLength), createRandomAccountNameAllowedString(minNameLength))
                        , false
                        , "Ожидалось, что функция вернет false при проверке name c пробелом в начале строки"},

                {String.format("%s %s ", createRandomAccountNameAllowedString(minNameLength), createRandomAccountNameAllowedString(minNameLength))
                        , false
                        , "Ожидалось, что функция вернет false при проверке name c пробелом в конце строки"},

                {null, false, "Ожидалось, что функция вернет false при проверке name со значением null"},
        };
    }

    @Test
    public void checkNameToEmbossTest() {
        Account account = new Account(name);
        assertEquals(errorMessage, expectedResult, account.checkNameToEmboss());
    }

}