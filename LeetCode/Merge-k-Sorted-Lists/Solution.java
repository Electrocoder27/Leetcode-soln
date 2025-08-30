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
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> values = new ArrayList<>() ;


        for(ListNode node:lists) {
            while(node != null) {
                values.add(node.val) ;
                node = node.next ;
            }
        }


        if(values.isEmpty()) {
            return null ;
        }

        Collections.sort(values) ;

        ListNode dummy = new ListNode(0) ;
        ListNode curr = dummy ;

        for(int val: values) {
            curr.next = new ListNode(val) ;
            curr = curr.next ;
        }

        return dummy.next ;
    }
}