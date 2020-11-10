package algorithm;

/**
 * 13. 去除某个数字
 */
public class Problem27 {
    public int removeElement(int[] nums, int val) {
        int length = 0;
        int i = 0;
        int times = 0;
        while (i < nums.length && times < nums.length) {
            if (nums[i] != val) {
                length++;
                i++;
            } else {
                remove(nums, i);
            }
            times++;
        }
        return length;
    }

    public void remove(int[] nums, int i) {
        for (int j = i; j < nums.length - 1; j++) {
            nums[j] = nums[j+1];
        }
    }

    public static void main(String[] args) {
        Problem27 p = new Problem27();
        int[] a = {3,2,2,3};
        p.removeElement(a, 3);
    }

}
