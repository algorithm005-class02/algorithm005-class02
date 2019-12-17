学习笔记

# 问题

最早起源于兔子问题

> 假设：一对成年兔子每年生一对小兔，小兔一年后成年。
>
> 提问：一开始有一对小兔，n年后共有多少只兔子

兔子的个数就是一个斐波那契数列

典型的斐波那契数列是：

```
0 1 1 2 3 5 8 13 21 ....
```

还有一些例子，如上台阶，每次只能上一级或两级，也是一个斐波那契数列

# 斐波那契解法

斐波拉契数列形如

```
f(n) = f(n-1) + f(n-2)
```

常见的解法有：

1. 直接递归，时间复杂度为O(2^N)（主定理，或者枚举计算，等比求和），空间复杂度是O(n)，递归调用栈的空间

2. 递归加记忆化，把每个f(n)保存起来，如果计算过就不计算了，空间换时间的思维，时间复杂度为O(N)，空间复杂度O(N)

3. 递推，时间复杂度为O(N)，空间复杂度O(1)

4. 通项公式法，即是求解power(a, n)，时间复杂度O(lgN)，空间复杂度O(1)

<img width="902" alt="屏幕快照 2019-07-23 上午9 28 08" src="https://user-images.githubusercontent.com/7975643/70688347-89eb9a00-1cec-11ea-9b5b-b2a19fbaef46.png">



   斐波那契数列通项公式：

   ```
   f(n) = a1(b1)^n + a2(b2)^n
   ```

   其中a1, b1, a2, b2四个数字都是常数。
   通项公式的计算，并不能O(1)得到，而是一个a^n，即power(a, n)的求解过程。

   另外，由于是浮点运算，受限于浮点运算的精度问题，需要做一个取整才能得到整数，计算机的浮点运算还是比较耗时的。

5. 矩阵相乘法

   [winter老师介绍的办法](https://time.geekbang.org/dailylesson/detail/100028406?utm_source=pc&utm_medium=pcchaping1127&utm_term=pcchaping1127)是借助线性代数的矩阵运算，构造斐波那契数列的通项公式的形态，用矩阵相乘的办法来求解，把斐波那契数列转换成矩阵的幂运算，达到O(lgN)

6. 查表，空间换时间的极致，时间复杂度O(1)，空间复杂度(嗯，很大，不知道怎么表示？)

   ```java
     static final int[] fibs = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040};
     public int fib(int N) { return fibs[N]; }
   ```



## power(a, n)的求解

见[Leetcode50](https://leetcode-cn.com/problems/powx-n/)

- 第一种解法：不断的乘以自己，时间复杂度O(N)
- 第二种解法：递归分治，时间复杂度O(lgN)
- 第三种解法：通过N的二进制位，迭代分治，时间复杂度O(lgN)



## 矩阵相乘法

通过使用矩阵乘法和矩阵幂运算来实现时间复杂度O(lgN)，空间复杂度为O(1)

目标就是a，b变为b，a+b。 

最终的结果用矩阵来表示就是: ![屏幕快照 2019-07-24 上午10.40.52.png](https://pic.leetcode-cn.com/bcee4dc5118b7428fde42e8c854d485a0e999ee07cd2794770a2f9f6caecf2b5-%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202019-07-24%20%E4%B8%8A%E5%8D%8810.40.52.png)

下面是用go来实现

```go
func fib(N int) int {
	if N == 0 || N == 1 {
		return N
	}
	// first 是第0个和第1个元素
	first := [][2]int{[2]int{0, 1}, [2]int{0, 0}}
	// temp为系数
	temp := [][2]int{[2]int{0, 1}, [2]int{1, 1}}
	res := matrix22_pow(temp, N - 1)
	return matrix22_mul(first, res)[0][1]
}

func matrix22_pow(x [][2]int, n int) [][2]int {
	r := x
	res := [][2]int{[2]int{1, 0}, [2]int{0, 1}}
	for n != 0 {
		if n & 1 == 1 {
			// 最低二进制位为1
			res = matrix22_mul(res, r)
		}
		// 2维矩阵相乘
		r = matrix22_mul(r, r)
		n >>= 1
	}
	return res
}

func matrix22_mul(x, y [][2]int) [][2]int {
	temp := make([][2]int, 2)
	temp[0][0] = x[0][0] * y[0][0] + x[0][1] * y[0][1]
	temp[0][1] = x[0][0] * y[0][1] + x[0][1] * y[1][1]
	temp[1][0] = x[1][0] * y[0][0] + x[1][1] * y[0][1]
	temp[1][1] = x[1][0] * y[1][0] + x[1][1] * y[1][1]
	return temp
}
```

# 思想总结

- 空间换时间
- 找重复性，最近重复子问题，计算机被设计之初就是用switch，iteration，recursion等来做重复性的工作
- 其他基础数学也很重要，高等数学，组合数学，线性代数等

# 参考

[极客时间 winter老师的讲解](https://time.geekbang.org/dailylesson/detail/100028406?utm_source=pc&utm_medium=pcchaping1127&utm_term=pcchaping1127)

[架构师之路—别再问我斐波那契数列了](https://yq.aliyun.com/articles/646447?spm=a2c4e.11153940.bloghomeflow.69.70e1291aNGkuPW)

# 课后作业
在java 11 下进行测试

# 改写代码以及测试用的代码
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(8 >>> 1);
        Deque<String> deque = new LinkedList<String>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);

        Queue<Integer> priorityQueue= new PriorityQueue<>();
        Queue<Integer> priorityQueue2= new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        priorityQueue.add(5);
        priorityQueue.add(2);
        priorityQueue.add(1);
        priorityQueue.add(6);
        priorityQueue.add(8);
        priorityQueue.add(3);
        priorityQueue.add(9);


        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove(3));
        System.out.println(priorityQueue.remove());
    }
}

```

# java优先队列的实现

java中采用的是二叉堆来实现

- Insert：O(lgN)
- Delete min/max：O(lgN)
  - remove(Object o) ：需要找到索引，O(N)
- Find min/max：O(1)



## 用数组来实现heap

Java底层使用数组来存储元素

```java
 Object[] queue; // non-private to simplify nested class access
```

<img width="241" alt="屏幕快照 2019-12-12 下午11 26 35" src="https://user-images.githubusercontent.com/7975643/70770350-ff687080-1da7-11ea-82ed-dd3f438638c7.png">


用数组array来实现这个树，[1, 2, 3, 4, 5, 6, 7]

- a[0]，表示根
- 若某个节点的数组索引为i，则其左，右孩子的索引为(2i+1, 2i+2)，其父节点的索引为((i-1)/2)



## 初始化

如果没有指定容量，默认的初始化容量是11；如果指定了容量，使用容量进行初始化，如果指定了比较器，使用指定的比较器进行初始化



## add(e)和offer(e)的实现

add直接调用了offer，如果底层的数组queue已经到达最大容量了，调用grow对其进行扩容，如果旧的容量大小小于64，加倍其容量，否则扩容50%，然后新创建一个数组，将旧数组的元素拷贝过去。

```java
     public boolean add(E e) {
        return offer(e);
    }
     public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        if (i >= queue.length)
            grow(i + 1);
        siftUp(i, e);
        size = i + 1;
        return true;
    }
    // 扩容		
    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        // Double size if small; else grow by 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                         (oldCapacity + 2) :
                                         (oldCapacity >> 1));
        // overflow-conscious code
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        queue = Arrays.copyOf(queue, newCapacity);
    }
```

如果没有指定比较器，默认实现是小顶堆，根元素是最小值。siftUp函数负责对优先队列进行维护，底层就是维护min heap

```java
   // 维护heap
   private void siftUp(int k, E x) {
        if (comparator != null)
            siftUpUsingComparator(k, x, queue, comparator);
        else
            siftUpComparable(k, x, queue);
    }
   private static <T> void siftUpUsingComparator(
        int k, T x, Object[] es, Comparator<? super T> cmp) {
        while (k > 0) {
          	// 找到父节点索引
          	// 无符号右移，忽略符号位，空位都以0补齐
            int parent = (k - 1) >>> 1;
            Object e = es[parent];
          	// 比较当前值和父节点值，如果x比e大或相等，退出循环
            if (cmp.compare(x, (T) e) >= 0)
                break;
          	// 否则调整父节点，进行下一轮比较
            es[k] = e;
            k = parent;
        }
     	// 最后把x放到合适的位置
        es[k] = x;
    }
```



## remove() 和 poll()

remove是从AbstractQueue继承的，调用了poll。

```java
    public E remove() {
        E x = poll();
        if (x != null)
            return x;
        else
            throw new NoSuchElementException();
    }
    public E poll() {
        final Object[] es;
        final E result;
	//  拿到根的值
        if ((result = (E) ((es = queue)[0])) != null) {
            modCount++;
            final int n;
          	// 拿到最后一个元素
            final E x = (E) es[(n = --size)];
          	// 清空最后一个元素
            es[n] = null;
            if (n > 0) {
              	// 从索引0开始调整heap
                final Comparator<? super E> cmp;
                if ((cmp = comparator) == null)
                    siftDownComparable(0, x, es, n);
                else
                    siftDownUsingComparator(0, x, es, n, cmp);
            }
        }
      	// 根即为所求
        return result;
    }
    private static <T> void siftDownComparable(int k, T x, Object[] es, int n) {
        // assert n > 0;
        Comparable<? super T> key = (Comparable<? super T>)x;
        int half = n >>> 1;           // loop while a non-leaf
        while (k < half) {
          	// 左孩子索引
            int child = (k << 1) + 1; // assume left child is least
            Object c = es[child];
          	// 右孩子索引
            int right = child + 1;
          	// 找到左右孩子中least
            if (right < n &&
                ((Comparable<? super T>) c).compareTo((T) es[right]) > 0)
                c = es[child = right];
          	// 左右孩子中least和x进行比较
            if (key.compareTo((T) c) <= 0)
                break;
            es[k] = c;
            k = child;
        }
        es[k] = key;
    }


```

## remove(Object o) 

```java
   public boolean remove(Object o) {
        int i = indexOf(o);
        if (i == -1)
            // 如果没有这个元素直接返回
            return false;
        else {
            removeAt(i);
            return true;
        }
    }

    E removeAt(int i) {
        // assert i >= 0 && i < size;
        final Object[] es = queue;
        modCount++;
        int s = --size;
        if (s == i) // removed last element
            es[i] = null;
        else {
            E moved = (E) es[s];
            es[s] = null;
          	// 将最后一个元素，插入到删除的位置。下沉moved直到小于等于child
            siftDown(i, moved);
          	// 如果没有下沉，需要考虑提升moved来调整heap
            if (es[i] == moved) {
              	// 向上提升moved，直到大于等于它的parent
                siftUp(i, moved);
                if (es[i] != moved)
                    return moved;
            }
        }
        return null;
    }
```



## peek()和element()

element调用了peek

```java
    public E peek() {
      	// 直接返回根元素
        return (E) queue[0];
    }
```