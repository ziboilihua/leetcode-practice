package algorithm;


public class Problem2 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode();
        ListNode temp = l;
        int plusNum;
        boolean plus = false;
        // 当没有进位且两个链表都走到最后截止
        while (l1 != null || l2 != null || plus) {
            // 链表1 + 链表2 + 进位1
            plusNum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + (plus ? 1 : 0);
            plus = plusNum >= 10;
            // 当前位为数据之和余10
            temp.val = plusNum % 10;
            // l1 l2 向下走
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            temp.next = (l1 != null || l2 != null || plus) ? new ListNode() : null;
            temp = temp.next;
        }
        return l;
    }

}
