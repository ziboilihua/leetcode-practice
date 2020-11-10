package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 */
public class Problem13 {
    public static void main(String[] args) {
        Problem13 problem13 = new Problem13();
        System.out.println(problem13.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        if (s != null && s.length() > 0) {
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
            if (s.length() == 1) {
                return getNum(s.charAt(0), map);
            }
            int result = 0;
            int num;
            for (int i = s.length() - 2; i >= 0; i--) {
                num = getNum(s.charAt(i), map);
                result += needSub(s.charAt(i), s.charAt(i + 1))
                        ? (-1 * num) : num;
            }
            return result + getNum(s.charAt(s.length() - 1), map);
        } else {
            return 0;
        }
    }

    private int getNum(Character c, Map<Character, Integer> map) {
        return map.get(c);
    }

    private boolean needSub(Character pre, Character last) {
        return (pre.equals('I') && (last.equals('V') || last.equals('X')))
                || (pre.equals('X') && (last.equals('L') || last.equals('C')))
                || (pre.equals('C') && (last.equals('D') || last.equals('M')));
    }
}
