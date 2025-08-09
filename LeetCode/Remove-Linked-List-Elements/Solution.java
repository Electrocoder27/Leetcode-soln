    while(head):
        if(head.val != val):
            temp.next = head
            temp = temp.next
        head = head.next

    return n.next
   