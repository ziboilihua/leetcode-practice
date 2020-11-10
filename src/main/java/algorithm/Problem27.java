package algorithm;

/**
 * 27.移除元素
 */
public class Problem27 {
    public int removeElement(int[] nums, int val) {
        //return answer1(nums, val);
        return answer2(nums, val);
    }


    public static void main(String[] args) {
        Problem27 p = new Problem27();
        int[] a = {3, 2, 2, 3};
        p.removeElement(a, 3);
    }

    /**
     * 暴力解法
     * 从头到尾遍历如果发现数据则后面的所有元素向前移动1位
     * 时间复杂度O(n²)
     * 空间复杂度O(1)
     *
     * @param nums
     * @param val
     * @return
     */
    int answer1(int[] nums, int val) {
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
            nums[j] = nums[j + 1];
        }
    }


    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * 问题[1,2,3,4,5,6]找6的时候需要移动5次
     *
     * @param nums
     * @param val
     * @return
     */
    int answer2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 因为不需要在意返回的数组与原数组顺序是否相同,故可以从头遍历,
     * 发现数字val后与数组最后一个进行替换,并且尾指针-1 头指针不变(防止尾指针指向的数字也是val)
     *
     * @param nums
     * @param val
     * @return
     */
    int answer3(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[--n];
            } else {
                i++;
            }
        }
        return i;
    }


}
