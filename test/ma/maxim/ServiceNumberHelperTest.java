package ma.maxim;

import main.ma.maxim.ServiceNumberHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class ServiceNumberHelperTest {

    @Test
    public void testGetUserName() {

        // prepare
        var map = new TreeMap<Integer, String>();
        map.put(1,"001");
        map.put(222,"222");
        map.put(202,"202");
        map.put(002,"002");

        // test
        // validate
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            var input = entry.getKey();
            var expected = entry.getValue();

            Assert.assertEquals(String.format("expected: %b, input: %d)",expected,input),
                    expected, ServiceNumberHelper.getUserName(input));
        }

    }
}
