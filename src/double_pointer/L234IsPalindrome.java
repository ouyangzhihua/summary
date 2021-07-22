package double_pointer;

import java.util.ArrayList;
import java.util.List;

public class L234IsPalindrome {
	/*
	 * 234. 回文链表
	 * 请判断一个链表是否为回文链表。
	 */
	class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
        {
            return true;
        }
        List<Integer> vals = new ArrayList<>();
        ListNode h = head;
        while(h != null)
        {
            vals.add(h.val);
            h = h.next;
        }
        int l = 0, r = vals.size()-1;
        while(l < r)
        {
            if(vals.get(l) != vals.get(r))
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
