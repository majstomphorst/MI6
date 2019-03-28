package ma.maxim;

import main.ma.maxim.LoginModel;
import org.junit.*;

import java.util.Map;
import java.util.TreeMap;


public class LoginModelTest {

    @Test
    public void testIsValid() {

        // prepare
        var map = new TreeMap<Integer, Boolean>();
        map.put(0,false);
        map.put(2,true);
        map.put(999,true);
        map.put(1000,false);

        var loginManager = new LoginModel();

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
        var loginManager = new LoginModel();
        var correctSecretLine = "For ThE Royal QUEEN";
        var wrongSecretLine = "wrong";
        var user1 = 1;
        var user2 = 3;

        // test
        var test1 = loginManager.isValid(user1);
        var test2 = loginManager.validateSecretLine(wrongSecretLine);
        var test3 = loginManager.isValid(user1);


        // validate
        Assert.assertTrue("",test1);
        Assert.assertFalse(test2);
        Assert.assertFalse(test3);
    }


    @Test
    public void testValidateSecretLine() {
        // prepare
        var map = new TreeMap<String, Boolean>();
        map.put("haai",                 false);
        map.put("",                     false);
        map.put("For ThE Royal QUEEN",  true);
        map.put("for the royal queen",  false);

        var loginManager = new LoginModel();

        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            var expected = entry.getValue();
            var input = entry.getKey();
            Assert.assertEquals(String.format("expected: %b, input: %s)", expected, input),
                                               expected, loginManager.validateSecretLine(input));
        }
    }

    @Test
    public void testIsLoggedIn() {
        // prepare
        var loginManager = new LoginModel();
        var secretLine = "For ThE Royal QUEEN";

        // test
        var test1 = loginManager.isLoggedIn();
        loginManager.validateSecretLine(secretLine);
        var test2 = loginManager.isLoggedIn();

        // validate
        Assert.assertFalse(test1);
        Assert.assertTrue(test2);
    }


}
