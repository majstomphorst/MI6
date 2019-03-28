package ma.maxim;

import main.ma.maxim.Login;
import org.junit.*;

import java.util.Map;
import java.util.TreeMap;


public class LoginTest {

    @Test
    public void testIsValid() {

        // prepare
        var map = new TreeMap<Integer, Boolean>();
        map.put(0,false);
        map.put(2,true);
        map.put(999,true);
        map.put(1000,false);

        var loginManager = new Login();

        // validate
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            var input = entry.getKey();
            var expected = entry.getValue();
            Assert.assertEquals(String.format("expected: %b, input: %d)",expected,input),
                                               expected, loginManager.isValid(input));
        }
    }

    @Test
    public void testIsValidBlackList() {
        // prepare
        var loginManager = new Login();
        var correctSecretLine = "For ThE Royal QUEEN";
        var wrongSecretLine = "wrong";
        var user1 = 1;
        var user2 = 3;

        // test
        loginManager.validateSecretLine(wrongSecretLine,user1);
        var test1 = loginManager.isValid(user1);

        loginManager.validateSecretLine(correctSecretLine,user1);
        var test2 = loginManager.isValid(user1);

        loginManager.validateSecretLine(correctSecretLine,user2);
        var test3 = loginManager.isValid(user2);

        // validate
        Assert.assertFalse(test1);
        Assert.assertFalse(test2);
        Assert.assertTrue(test3);
    }


    @Test
    public void testValidateSecretLine() {
        // prepare
        var map = new TreeMap<String, Boolean>();
        map.put("haai",                 false);
        map.put("",                     false);
        map.put("For ThE Royal QUEEN",  true);
        map.put("for the royal queen",  false);

        var loginManager = new Login();

        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            var expected = entry.getValue();
            var input = entry.getKey();
            Assert.assertEquals(String.format("expected: %b, input: %s)", expected, input),
                                               expected, loginManager.validateSecretLine(input,2));
        }
    }

    @Test
    public void testIsLoggedIn() {
        // prepare
        var loginManager = new Login();
        var secretLine = "For ThE Royal QUEEN";

        // test
        var test1 = loginManager.isLoggedIn();
        loginManager.validateSecretLine(secretLine,007);
        var test2 = loginManager.isLoggedIn();

        // validate
        Assert.assertFalse(test1);
        Assert.assertTrue(test2);
    }


}
