1. Rewrite the deque codes with add first and add last:  
Deque<String>deque = new LinkedList<String>();  

deque.addFirst("a");  
deque.addFirst("b");  
deque.addFirst("c");  
System.out.println(deque);

String str = deque.peekFirst();
System.out.println(str);
System.out.println(deque);

while(deque.size()>0){
    System.out.println(deque.removeFirst());
}
System.out.println(deque);

2. Study summury:
打开思路远远比一道题目更重要。关键在于拿到一个题目之后我们如何想，思路在哪里。

