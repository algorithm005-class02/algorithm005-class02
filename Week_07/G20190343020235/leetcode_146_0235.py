class ListNode(object):                                    

    def __init__(self,key=None,val=None,next=None,prev=None):
        self.key = key                                       
        self.val = val                                       
        self.next = next                                     
        self.prev = prev
class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.occupancy = 0      
        self.sentinel = ListNode()
        self.hashtable = {}

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key in self.hashtable:
            # Update LL, move key to head #
            node = self.hashtable[key]     
            self.moveNodeToHead(node)      
            return node.val                
        else:                              
            return -1

    def put(self, key, val):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        if not key in self.hashtable:
            self.occupancy += 1      
            node = ListNode(key,val,self.sentinel.next) # Create new node, it will point to current head
            if self.sentinel.next:                                                                      
                self.sentinel.next.prev = node # Current head's previous pointer will point to new node 
            self.sentinel.next = node # New node will become head                                       
            self.hashtable[key] = node # Add node to hash table                                         
            if not self.sentinel.prev:                                                                  
                self.sentinel.prev = node                                                               
            if self.occupancy > self.capacity:                                                          
                self.occupancy -= 1 # time to evict                                                     
                node = self.sentinel.prev.prev                                                          
                del self.hashtable[node.next.key]                                                       
                del node.next                                                                           
                node.next = None                                                                        
                self.sentinel.prev = node                                                                                                 
        else:                                                                                           
            # Update LL, move key to head #                                                             
            node = self.hashtable[key]                                                                  
            self.moveNodeToHead(node)                                                                   
            node.val = val

    def moveNodeToHead(self,node):
        # Make previous point to next, if it has a previous
        if node.prev:                                      
            node.prev.next = node.next                     
        else: # we are at head
            return
        # Make next point to previous, if it has a next
        if node.next:
            node.next.prev = node.prev
        else: # we are at tail
            self.sentinel.prev = node.prev
        # Make node point to current head
        node.next = self.sentinel.next
        # Make current head point back
        self.sentinel.next.prev = node
        # Clear old pointer
        node.prev = None
        # Make node the head
        self.sentinel.next = node
        


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)