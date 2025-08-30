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
       if(lists == null || lists.length == 0) {
        return null ;
       }

       PriorityQueue <ListNode> minheap = new PriorityQueue<>((a,b) -> a.val-b.val) ;

       //push head of each list..........
       for(ListNode node : lists) {
            if(node != null) {
                minheap.add(node) ;
            }
        }

        ListNode dummy = new ListNode(0) ;
        ListNode tail = dummy ;

        while(!minheap.isEmpty()) {
            ListNode minNode = minheap.poll() ;
            tail.next = minNode ;
            tail  = tail.next ;

            if(minNode.next != null) {
                minheap.add(minNode.next) ;
            }
        }


        return dummy.next ;
    }
}