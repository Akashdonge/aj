import java.util.HashMap;
import java.util.Map;

public class SubstringFrequency {
    public static void main(String[] args) {
        String str = "hellohellohello";
        String substr = "hello";
        System.out.println("Frequency of '" + substr + "' in '" + str + "': " + countSubstring(str, substr));
    }

    public static int countSubstring(String str, String substr) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(substr, index)) != -1) {
            count++;
            index += substr.length();
        }
        return count;
    }
}
