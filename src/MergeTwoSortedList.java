public class MergeTwoSortedList {
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Initialize the finalList
        ListNode finalList = new ListNode(0);
        
        // Initialize a listNode that will create the merged list as
        // it traverse between l1 and l2
        ListNode curr = finalList;
        
        // Handle null cases
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        while (l1 != null && l2 != null) {
            curr.next = (l1.val < l2.val ? l1 : l2);
            // Move on the the respective next of l1 or l2
            if (l1.val < l2.val) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
            
            // Move on to the next of curr
            curr = curr.next;
            
            // Check for any further null cases either on l1 or l2
            if (l1 == null) {
                curr.next = l2;
                break;
            } else if (l2 == null) {
                curr.next = l1;
                break;
            }
            
        }
        // Link curr (which is the mergedList), back to finalList 
        return finalList.next;
    }          
}
