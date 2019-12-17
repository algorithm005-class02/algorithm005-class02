Leetcode26题解题思路：    
去除重复元素，双指针法，一个指针遍历数组，另一个指针来保存非重复元素。  
这里有两种比较方法：  
1、遍历元素和最后一个非重复元素比较，如果不相等，就增加一个非重复元素。  
2、遍历元素自身前后比较，把前后出现变化的元素加为非重复元素。  
这两个比较的基础都是题干说明的有序数组。  

Leetcode641题解题思路：
参考国际站的数组方法，这种方法在理解上比较直观，类似循环队列，队满和队空的判断，就是判断头尾指针的位置。  
如果front == end，就是空队列。  
如果（front+1)%capicaty==end, 就是队满。这里是一个理解盲点，最开始想的时候是队尾+1，因为是队尾和队头相差1个位置，但到底谁在前谁在后。  
第一直觉是队尾在前，因为绕1圈后队尾去到前面。但画图分析后，还是队头在前，因为起始点是0，队头是从0加，队尾是从0减，变成大数。所以队头小于队尾。  
另外一个点就是，addFirst和addLast，其中一个是先赋值再累加，另一个是先累加再赋值。因为要利用起来0位置点，不然中间就空了，无法将队头和队尾连贯起来。  
同样因为赋值后累加的原因，为与队空区分，数组实际大小比容量大1，有1个单位的空间是永远空闲的。  

用Deque的新API改写代码：  
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

分析Queue和Priority Queue码：
看了官方的接口文档和类文档，queue简单，但优先队列的函数没看明白哪个函数是利用不同优先级来出栈。
