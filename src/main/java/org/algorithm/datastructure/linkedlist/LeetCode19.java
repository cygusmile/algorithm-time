package org.algorithm.datastructure.linkedlist;

import org.algorithm.base.ListNode;
import org.datastructure.union.UF;

/**
 * @fileName: LeetCode19.java
 * @description: LeetCode19.java类说明
 * @author: by echo huang
 * @date: 2020/11/11 10:47 上午
 */
public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast, slow;
        fast = slow = head;
        // 快指针先前进 n 步
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) {
            // 如果此时快指针走到头了，
            // 说明倒数第 n 个节点就是第一个节点
            return head.next;
        }
        // 让慢指针和快指针同步向前
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // slow.next 就是倒数第 n 个节点，删除它
        slow.next = slow.next.next;
        return head;
    }
}
