package main.ma.maxim;

public class ServiceNumberHelper {

    public static String getUserName(Integer number) {
        if (number != null) {
            return padLeftZeros(number,3);
        }
        return "";
    }

    private static String padLeftZeros(int inputInt, int length) {
        var inputString = Integer.toString(inputInt);

        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }


}
