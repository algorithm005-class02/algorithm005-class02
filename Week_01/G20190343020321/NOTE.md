

# week1 学习笔记

# Queue和Priority Queue的源码分析

## Queue

 ### 基本说明 

        Queue即为队列，继承自Cllection接口，除了基本的 Collection 操作外，队列还提供其他的插入、提取和检查操作。每个方法都存在两种形式：一种抛出异常（操作失败时），另一种返回一个特殊值（null 或 false，具体取决于操作）。插入操作的后一种形式是用于专门为有容量限制的 Queue 实现设计的；在大多数实现中，插入操作不会失败。

 ### 主要方法： 

    - add(e) 添加，将指定的元素插入队列，成功返回true，空间不足而失败抛异常
    
    - offer(e) 添加，将指定的元素插入此队列（如果立即可行且不会违反容量限制），当使用有容量限制的队列时，此方法通常要优于 add(e)。
       
    - remove() 获取并移除此队列的头。与 poll唯一不同：队列为空时将抛异常。
    
    - poll()  获取并移除此队列的头，如果队列为空，则返回 null
    
    - element() 获取，但不移除此队列的头。与peek唯一不同：队列为空时将抛异常
      
    - peek() 获取但不移除此队列的头；如果此队列为空，则返回 null

  参考：https://tool.oschina.net/uploads/apidocs/jdk-zh/java/util/Queue.html

## PriorityQueue

 ### 基本说明 

       PriorityQueue为优先队列，是AbstractQueue抽象类的实现类， 优先队列的作用是能保证每次取出的元素都是队列中权值最小的。这里牵涉到了大小关系，元素大小的评判可以通过元素本身的自然顺序（natural order），也可以通过构造时传入的比较器。

 ### 主要方法

```Java
/**
*Inserts the specified element into this priority queue.
*/
boolean	add(E e)
/**
*emoves all of the elements from this priority queue.
*/
void	clear()
/**
*Returns the comparator used to order the elements in this queue, or null if this queue *is sorted according to the natural ordering of its elements.
*/ 
Comparator<? super E>	comparator()
/**
*Returns true if this queue contains the specified element.
*/
boolean	contains(Object o)
/**
*Returns an iterator over the elements in this queue.
*/
Iterator<E>	iterator()
/**
*Inserts the specified element into this priority queue.
*/
boolean	offer(E e)

    
/**
*Retrieves and removes the head of this queue, or returns null if this queue is empty.
*/
E	peek()

/**
*Retrieves, but does not remove, the head of this queue, or returns null if this queue is *empty.
*/
E	poll()

/**
*Removes a single instance of the specified element from this queue, if it is present.
*/
boolean	remove(Object o)

/**
*Returns the number of elements in this collection.
*/
int	size()
    
/**
*Returns an array containing all of the elements in this queue.
*/
Object[]	toArray()
   
/**
*Returns an array containing all of the elements in this queue; the runtime type of the *returned array is that of the specified array.
*/
<T> T[]	toArray(T[] a)

```



