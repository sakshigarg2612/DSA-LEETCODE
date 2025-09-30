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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] results = new int[m][n];
        for(int i=0; i<m;i++) {
            Arrays.fill(results[i],-1);
        }
        ListNode curr= head;
        int top =0; int bottom = m-1; int left =0;int right= n-1;
        while(top<=bottom && left<=right && curr!=null) {
            for(int i=left;i <=right  && curr!=null;i++) {
                results[top][i] = curr.val;
                curr= curr.next;
            }
            top++;
            for(int j=top;j <=bottom  && curr!=null;j++) {
                results[j][right] = curr.val;
                curr= curr.next;
            }
            right--;
            for(int i=right;i>=left  && curr!=null;i--) {
                results[bottom][i] = curr.val;
                curr= curr.next;
            }
            bottom--;
            for(int j=bottom;j >=top  && curr!=null;j--) {
                results[j][left] = curr.val;
                curr= curr.next;
            }
            left++;
        }
        return results;
    }
}