package aimoffer;

public class FindFirstCommonNode {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n4;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode p1 = n1;
        ListNode p2 = n3;

        System.out.println(FindFirstCommonNode1(p1, p2).val);
    }

    //大牛算法
    public static ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode n1 = pHead1;
        ListNode n2 = pHead2;

        while (n1 != n2) {
            n1 = n1 == null ? pHead2:n1.next;
            n2 = n2 == null ? pHead1:n2.next;
        }
        return n1;
    }


    //常规长度分析
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode head1 = pHead1;
        ListNode head2 = pHead2;
        int p1=0;
        int p2=0;
        while (head1 != null) {
            p1++;
            head1 = head1.next;
        }
        while (head2 != null) {
            p2++;
            head2 = head2.next;
        }

        head1 = pHead1;
        head2 = pHead2;
        int less = p1>=p2 ? (p1-p2):(p2-p1);
        int left = p1;
        if (p1 > p2) {
            while (less > 0) {
                head1 = head1.next;
                less--;
            }
            left = p2;
        }else if (p1 < p2) {
            while (less > 0) {
                head2 = head2.next;
                less--;
            }
            left = p1;
        }

        while(left > 0) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
            left--;
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
