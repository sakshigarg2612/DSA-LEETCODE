/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head!=null) {
            list.add(head.val);
            head= head.next;
        }
        int n= list.size();
        double pow= n-1;
        int result =0;
        for(int i=0;i <n;i++) {
            if(list.get(i)==1) {
            result = result + (int)(Math.pow(2,pow));
            }

            pow--;
        }
        return result;
    }
}