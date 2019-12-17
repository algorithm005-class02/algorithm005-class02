func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
   
    var  res *ListNode
    res = &ListNode{}
    head := res

    for l1!=nil&&l2!=nil{
        if l1.Val >= l2.Val {  
            res.Next = l2
            res = l2
            l2 = l2.Next
            
        }else{
             res.Next = l1
             res =  l1
             l1 = l1.Next
        }
    }

    if l1!=nil{
        res.Next = l1
    } 
    if l2!=nil{
        res.Next = l2
    } 

    return head.Next
}
