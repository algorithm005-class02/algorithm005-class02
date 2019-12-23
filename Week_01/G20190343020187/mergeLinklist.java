package GeekHomework;

import org.junit.Test;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val =x;}
}

public class mergeLinklist {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode=new ListNode(0);
        ListNode p=new ListNode(l1.val);
        ListNode q=new ListNode(l2.val);
        p.next=l1.next;
        q.next=l2.next;
        ListNode r;
        listNode.next=l1;
        listNode.next=null;
        r=listNode;
        while (p!=null&&q!=null){
            if(p.val<q.val){
                r.next=p;p=p.next;
                r=r.next;
            }
            else {
                r.next=q;q=q.next;
                r=r.next;
            }
        }
        r.next=null;
        if(p!=null) r.next=p;
        if(q!=null) r.next=q;
        return listNode;
    }
}
