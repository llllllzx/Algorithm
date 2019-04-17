package ZCY._02ChapterLinkedListQuestions;

/**
 * Created by zhaoxinliu on 2019/4/10
 */
public class _01PrintCommonLinkedList {
    public static void main(String[] args) {
        int[] arr1 = {1,7,8,14,20,24};
        int[] arr2 = {2,3,7,9,14,24,26};
        ListNode head1 = new ListNode(-1);
        ListNode cur1 = head1;
        ListNode head2 = new ListNode(-1);
        ListNode cur2 = head2;
        for(int i = 0; i < arr1.length;i++){
            cur1.next = new ListNode(arr1[i]);
            cur1 = cur1.next;
        }
        for(int i = 0; i < arr2.length;i++){
            cur2.next = new ListNode(arr2[i]);
            cur2 = cur2.next;
        }
        printCommonPart(head1.next,head2.next);
    }
    public static void  printCommonPart(ListNode head1,ListNode head2){
        System.out.println("common part:");
        while(head1 != null &&  head2 != null){
            if(head1.value > head2.value){
                head2 = head2.next;
            }else if(head1.value < head2.value){
                head1 = head1.next;
            }else{
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(-1);
        ListNode head = cur;
        int carry = 0;
        while(l1 != null || l2 != null){
            int a = l1 != null ? l1.value:0;
            int b = l2 != null ? l2.value:0;
            int sum = a + b + carry;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;
            l1 = l1.next != null?l1.next:l1;
            l2 = l2.next != null ? l2.next:l2;
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }
        return head.next;
    }

}

class ListNode{
    public int value;
    public ListNode next;
    public ListNode(int value){
        this.value =  value;
    }
}