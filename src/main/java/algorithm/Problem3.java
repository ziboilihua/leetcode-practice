package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 窗口滑动问题
 */
public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0, end = -1;
        // 滑动窗口
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                // 窗口右移,删除set最左侧元素
                set.remove(s.charAt(i));
            }
            // 如果存在更大的元素则滑动后应该会比之前的窗口更大
            while (end + 1 < s.length() && !set.contains(s.charAt(end + 1))) {
               set.add(s.charAt(end + 1));
               end++;
            }
            // 每次轮询记录最大的窗口值
            result = Math.max(result, end + 1 - i);
        }
        return result;
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.lengthOfLongestSubstring("abc"));
        System.out.println(problem3.lengthOfLongestSubstring("abcabcda"));
        System.out.println(problem3.lengthOfLongestSubstring("abcabcabca"));
    }
}
