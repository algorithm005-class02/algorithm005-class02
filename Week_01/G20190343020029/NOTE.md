# week01
### 算法设计
1. 穷举法
2. 回溯法
3. 分治法和递归法
4. 贪心法和动态规划法
5. 计算时间复杂度
* 常数阶：O(1)
<pre><code>
var sum = 0, n = 100;
sum = (1 + n) * n / 2;
console.log(sum)
</code></pre>
* 线性阶：O(n)
<pre><code>
for(i = 0; i < n; i++){
  //
}
</code></pre>
* 对数阶：O(logn)
<pre><code>
var count = 1;
while (count < n) {
  count = count * 2
}
</code></pre>
* 平方阶：O(n^i)|O(m*n)
<pre><code>
for(i = 0; i < n; i++) {
  for(j = 0; j < n; j++) {
    //O(n^2)
  }
}
</code></pre>
<pre><code>
for(i = 0; i < m; i++) {
  for(j = 0; j < n; j++) {
    //O(m*n)
  }
}
</code></pre>
* 常用的时间复杂度所耗费的时间从小到大依次是：
&nbsp;O(1) < O(logn) < O(n) < O(nlogn) < O(n^2) < O(n^3) < O(2^n) < O(n!) < O(n^n) 
6. 空间复杂度：S(n) = O(f(n))  n为问题的规模，f(n)为语句关于n所占空间的函数。
7. 插入算法的思路：
* 插入位置不合理，抛出异常
* 线性表长度大于等于数组长度，抛出异常或动态增加容量
* 从最后一个元素开始向前遍历到第i个位置，分别将它们都向后移动一个位置
* 将要插入元素填入位置i处
* 表长加1
8. 删除算法的思路：
* 删除位置不合理，抛出异常
* 取出删除元素
* 从删除元素位置开始遍历到最后一个元素位置，分别将它们都向前移动一个位置
* 表长减1
### 数组、链表、跳表
##### 数组
数组：一个存储元素的线性集合，元素可以通过索引来任意存取，索引通常是数字，用来计算元素之间存储位置的偏移量。

js中数组是一种特殊的对象，用来表示偏移量的索引是该对象的属性，索引可能是整数。数字索引在内部会被转换为字符串类型。js中属性名必须是字符串。

1. 创建数组的方式
* var numbers = []
* var numbers = new Array()
2. 判断一个对象是否是数组
* Array.isArray()
3. 读写数组
用[]操作符将数据赋给数组，例：
> nums[i] = i + 1
4. 由字符串生成数组：split()
> var sentence = "the quick brown fox jumped over the lazy dog"
> var words = sentence.split("")
> for (var i = 0; i < words.length; ++i) {
>   &nbsp;&nbsp;&nbsp;console.log("word " + i + ":" + words[i])
> }
5. 对数组的整体性操作
浅复制：通过原引用修改了数组的值，另一个引用也会感知到这个变化。
> nums = []
> nums1 = [1, 2]
> nums = nums1
深拷贝：
> 法一：nums = JSON.parse(JSON.stringify(nums1))
> 法二：
<pre><code>
  function deepClone(obj) {
    let result = typeof  obj.splice === "function" ? [] : {};
    if (obj && typeof obj === 'object') {
        for (let key in obj) {
            if (obj[key] && typeof obj[key] === 'object') {
                result[key] = deepClone(obj[key]);//如果对象的属性值为object的时候，递归调用deepClone,即在吧某个值对象复制一份到新的对象的对应值中。
            } else {
                result[key] = obj[key];//如果对象的属性值不为object的时候，直接复制参数对象的每一个键值到新的对象对应的键值对中。
            }

        }
        return result;
    }
    return obj;
  }
</code></pre>
6. 存取函数
* 查找元素
&nbsp;indexOf()函数是常用的存取函数之一，如果目标数组包含该参数，就返回该元素在数组中的索引；如果不包含，就返回-1。
* 数组的字符串表示
&nbsp;有两个方法将数组转化为字符串：join()和toString()
* 由已有数组创建新数组
&nbsp;cancat()和splice()方法允许通过已有数组创建新数组。concat方法可以合并多个数组创建一个新数组，splice()方法截取一个数组的子集创建一个新数组。
7. 可变函数
* 为数组添加元素
&nbsp;push()将一个元素添加到数组末尾。
&nbsp;unshift()将一个元素添加到数组的开头。
&nbsp;splice()将一个元素添加到数组的中间:
&nbsp;&nbsp;&nbsp;起始索引；需要删除的个数，新增时设置为0；想要添加进数组的元素。
&nbsp;reverse()将数组中元素的顺序进行翻转。
&nbsp;sort()按照字典顺序对元素进行排序，元素类型是数字类型，sort()方法的排序结果可能不对；数字类型时可以用[1,2,0,9,5,2,7].sort((a, b) => a-b)代替
<pre><code>
&nbsp;&nbsp;[3, 1, 2, 100, 4, 200].sort() //1, 100, 2, 200, 3, 4
</code></pre>
8. 迭代器方法
* 不生成新数组的迭代器方法
&nbsp;forEach()
&nbsp;every():返回值为布尔型
&nbsp;some():返回值为布尔型
&nbsp;reduce():返回一个值；该方法会从一个累加值开始，不断对累加值和数组中的后续元素调用该函数，直到数组中的最后一个元素，最后返回得到的累加值。
<pre><code>
function add(runningTotal, currentValue) { 
  return runningTotal + currentValue; 
}
var nums = [1,2,3,4,5,6,7,8,9,10]; 
var sum = nums.reduce(add); 
sum; // 显示 55
</code></pre>
<pre><code>
function concat(accumulatedString, item) { 
  return accumulatedString + item; 
}
var words = ["the ", "quick ","brown ", "fox "];
var sentence = words.reduce(concat); 
sentence; // 显示 "the quick brown fox"
</code></pre>
&nbsp;reduceRight()：与reduce（）类似，区别是从右到左执行。
* 产生新数组的迭代器方法
&nbsp;map()
&nbsp;filter()
9. 二维和多维数组
* 创建二维数组
&nbsp;twod[i] = []
* 处理二维数组的元素：按行访问、按列访问
&nbsp;for循环：外层循环对应行，内层循环对应列
* 参差不齐的数组：每行元素个数不同
10. 对象数组
<pre><code>
function Point(x,y) { 
  this.x = x; this.y = y; 
}
function displayPts(arr) { 
  for (var i = 0; i < arr.length; ++i) { 
    console.log(arr[i].x + ", " + arr[i].y); 
  } 
}
var p1 = new Point(1,2); 
var p2 = new Point(3,5); 
var p3 = new Point(2,8); 
var p4 = new Point(4,4); 
var points = [p1,p2,p3,p4]; 
for (var i = 0; i < points.length; ++i) { 
  console.log("Point " + parseInt(i+1) + ": " + points[i].x + ", " + points[i].y); 
}
</code></pre>
11. 对象中的数组
<pre><code>
function weekTemps() { 
  this.dataStore = []; 
  this.add = add; 
  this.average = average; 
}
function add(temp) { 
  this.dataStore.push(temp); 
}
function average() { 
  var total = 0; 
  for (var i = 0; i < this.dataStore.length; ++i) { 
    total += this.dataStore[i]; 
  }
  return total / this.dataStore.length; 
}
var thisWeek = new weekTemps(); 
thisWeek.add(52); 
thisWeek.add(55); 
thisWeek.add(61); 
thisWeek.add(65); 
thisWeek.add(55); 
thisWeek.add(50); 
thisWeek.add(52); 
thisWeek.add(49); 
console.log(thisWeek.average()); // 显示 54.875
</code></pre>


##### 链表
数组在实际使用时很慢，可使用链表代替它。除了对数据的随机访问，链表几乎可以用在任何可以使用一维数组的情况下。
1. 定义链表：链表是一组节点组成的集合。每个节点都使用一个对象的引用指向它的后继。指向另一个节点的引用叫做链。
链表的尾元素指向一个null节点。
链表的实现是在链表的最前面有一个特殊节点，叫做头节点。
* 向链表插入一个节点，需要修改它前面的节点（前驱），使其指向新加入的节点，而新加入的节点则指向原来前驱指向的节点。
* 从链表删除一个元素，将待删除元素的前驱节点指向待删除元素的后继节点，同时将待删除元素指向null。
2. 基于对象的链表
* node类
<pre><code>
function Node(element) { 
  this.element = element; 
  this.next = null; 
}  
</code></pre>
* LList类
<pre><code>
function LList() { 
  this.head = new Node("head"); 
  this.find = find; 
  this.insert = insert; 
  this.remove = remove; 
  this.display = display; 
}
</code></pre>
* 查找节点
<pre><code>
function find(item) { 
  var currNode = this.head; 
  while (currNode.element != item) { 
    currNode = currNode.next; 
  }
  return currNode; 
}
</code></pre>
* 插入新节点
<pre><code>
function insert(newElement, item) { 
  var newNode = new Node(newElement); 
  var current = this.find(item); 
  newNode.next = current.next; 
  current.next = newNode;
}
</code></pre>
* 从链表中删除一个节点
<pre><code>
function remove(item) { 
  var prevNode = this.findPrevious(item); 
  if (!(prevNode.next == null)) { 
    prevNode.next = prevNode.next.next; 
  }
} 
</code></pre>
3. 双向链表
* 插入元素
<pre><code>
function insert(newElement, item) { 
  var newNode = new Node(newElement); 
  var current = this.find(item); 
  newNode.next = current.next; 
  newNode.previous = current; 
  current.next = newNode; 
}
</code></pre>
* 删除元素
<pre><code>
function remove(item) { 
  var currNode = this.find(item); 
  if (!(currNode.next == null)) {    
    currNode.previous.next = currNode.next; 
    currNode.next.previous = currNode.previous; 
    currNode.next = null; 
    currNode.previous = null; 
  } 
}
</code></pre>
4. 循环链表
循环链表和单向链表相似，节点类型一样。区别是在创建循环链表时，让头节点的next属性指向它本身。
如果希望可以从后向前遍历链表，但是又不想付出额外代价来创建一个双向链表，就需要循环链表。从循环链表的尾节点向后移动，就等于从后向前遍历链表。
<pre><code>
head.next = head
</code></pre>
5. 链表的其他方法
* advance(n)在链表中向前移动n个节点
* back(n)在双向链表中向后移动n个节点。
* show()只显示当前节点
##### 跳表
* 跳表是一种随机化的数据结构。
* 跳表的性质:
&nbsp;1)有很多层结构组成
&nbsp;2)每一层都是一个有序的链表
&nbsp;3)最底层（level1）的链表包含所有元素
&nbsp;4)如果一个元素出现在level i 的链表中，则它在level i之下的链表也都会出现
&nbsp;5)每个节点包含两个指针，一个指向同一链表中的下一个元素，一个指向下面一层的元素
* 跳表的搜索：查找元素 117
&nbsp;(1) 比较 21， 比 21 大，往后面找
&nbsp;(2) 比较 37,   比 37大，比链表最大值小，从 37 的下面一层开始找
&nbsp;(3) 比较 71,  比 71 大，比链表最大值小，从 71 的下面一层开始找
&nbsp;(4) 比较 85， 比 85 大，从后面找
&nbsp;(5) 比较 117， 等于 117， 找到了节点。
* 跳表的插入：
&nbsp;先确定该元素要占据的层数K（采用丢硬币的方式，这完全是随机的），然后在Level 1 ... Level K各个层的链表都插入元素。
&nbsp;如果K大于链表的层数，则要添加新的层。
* 丢硬币决定K：插入元素的时候，元素所占有的层数完全是随机的。
* 跳表的高度：n个元素的跳表，每个元素插入的时候都要做一次实验，用来决定元素占据的层数K，跳表的高度等于这n次实验中产生的最大K
* 跳表的空间复杂度分析：每个元素的期望高度为2，一个大小为n的跳表，其节点数目的期望值是2n。
* 跳表的删除：在各个层中找到包含x的节点，使用标准的delete from list方法删除该节点。
##### 补充
1. 顺序存储结构的优缺点：
* 优点：
&nbsp;无须为表示表中元素之间的逻辑关系而增加额外的存储空间
&nbsp;可以快速地存取表中任一位置的元素
* 缺点：
&nbsp;插入和删除操作需要移动大量元素
&nbsp;当线性表长度变化较大时，难以确定存储空间的容量
&nbsp;造成存储空间的“碎片”
2. 单链表第 i 个数据插入节点的算法思路：
* 声明一节点p指向链表第一个结点，初始化j从1开始
* 当j < i 时，就遍历链表，让p的指针向后移动，不断指向下一节点，j累加1
* 若到链表末尾p为空，则说明第i个元素不存在；
* 否则查找成功，在系统生成一个空结点s；
* 将数据元素e赋值给s->data
* 单链表的插入标准语句s->next = p->next; p->next = s
* 返回成功
3. 单链表第 i 个数据删除结点的算法思路：
* 声明一节点p指向链表第一个节点，初始化j从1开始
* 当j < i ,就遍历链表，让p的指针向后移动，不断指向下一节点，j累加1
* 若链表末尾p为空，则说明第i个元素不存在
* 否则查找成功，将要删除的节点p->next赋值给q
* 单链表的输出标准语句p->next = q->next
* 将q节点的数据赋值给e，作为返回。
* 释放q节点
* 返回成功
4. 单链表整表清空
* 声明节点p和q
* 将第一个节点赋值给p
* 循环：
&nbsp;将下一节点赋值给q
&nbsp;释放p
&nbsp;将q赋值给p
5. 数组描述的链表叫做静态链表


### 栈、队列、优先队列、双端队列
栈和队列都是典型的线性结构。栈的特点是后进先出，常用来处理具有递归结构的数据；队列的特点则是先进先出，在实际中体现出公平的原则，可以用来暂时存放需要按照一定次序依次处理但尚未处理的元素。
##### 栈
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;栈的一端是栈顶，另一端是栈底。最后插入的元素是最先被删除或读取的元素。一叠盘子、大型火车站用于调整调度火车头方向的调度栈结构都可视为栈的模型。
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;习惯上往栈中插入元素为push操作，简称压栈或入栈。删除栈顶元素称为pop操作，简称为出栈或弹出。
1. 栈的抽象数据类型
&nbsp;栈的操作：进栈push、出栈pop、读栈顶top、判断是否为空isEmpty和是否已满isFull等。栈的实现与其存储结构相关。
2. 栈的实现
<pre><code>
function Stack() {
  this.dataStore = []
  this.top = 0
  this.push = push
  this.pop = pop
  this.peek = peek
}
</code></pre>
<pre><code>
//push()
function push(element) {
  this.dataStore[this.top++] = element
}
</code></pre>
<pre><code>
//pop()
function pop() {
  return this.dataStore[--this.top]
}
</code></pre>
<pre><code>
//peek()
function peek() {
  return this.dataStore[this.top-1]
}
</code></pre>
<pre><code>
//length()
function length() {
  return this.top
}
</code></pre>
<pre><code>
//clear()
function clear() {
  this.top = 0
}
</code></pre>
3. 顺序栈
&nbsp;需要一块连续的区域来存储栈中的元素，事先需要知道或估算栈的大小。顺序栈实现时，用一个整型变量top（通常称为栈顶指针）来指示当前栈顶位置，同时也可表示当前栈中元素的个数。
* top的两种定义方式：
&nbsp;1）将其设置为栈中第一个空闲位置，即空栈的top为0；
&nbsp;2）将其定义为栈中最上面的那个元素的位置，而非第一个空闲位置，此时空栈的top初始化为-1或任何非自然数
4. 栈中元素是动态变化的，当栈中有最大个数个元素时，进栈会产生上溢出。在空栈进行出栈会造成下溢出。为避免溢出，在对栈进行push和pop操作之前检查栈是否已满或已空。
5. 链式栈
&nbsp;链式栈本质上是简化的链表，栈顶元素应该设为链表头。
6. 栈的应用
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;记录网页访问历史、保存文本编辑器中的undo序列、编译栈中函数调用地址和参数的保存、二叉树的深度优先等。
##### 队列
1. 队列是一种列表，队列只能在队尾插入元素，在队首删除元素。
2. 队列的应用：
&nbsp;提交操作系统执行的一系列进程、打印任务池等，一些仿真系统用模拟银行或杂货店里排队的顾客。
3. 插入操作叫做入队、删除操作叫做出队。读取队头元素操作为peek()。
4. 用数组实现的队列：
<pre><code>
function Queue() {
  this.dataStore = []
  this.enqueue = enqueue
  this.dequeue = dequeue
  this.front = front
  this.back = back
  this.toString = toString
  this.empty = empty
}
</code></pre>
<pre><code>
function enqueue(element) {
  this.dataStore.push(element)
}
</code></pre>
<pre><code>
function dequeue() {
  return this.dataStore.shift()
}
</code></pre>
<pre><code>
function front() {
  return this.dataStore[0]
}
</code></pre>
<pre><code>
function back() {
  return this.dataStore[this.dataStore.length-1]
}
</code></pre>
<pre><code>
function toString() {
  var retStr = ""
  for(var i = 0; i < this.dataStore.length; ++i) {
    reStr += this.dataStore[i] + ";"
  }
  return retStr
}
</code></pre>
<pre><code>
function empty() {
  if(this.dataStore.length == 0) {
    return true
  }else {
    return false
  }
}
</code></pre>
##### 优先队列
1. 在一般情况下，从队列中删除的元素，一定是率先入队的元素。但是也有一些使用队列的 应用，在删除元素时不必遵守先进先出的约定。这种应用，需要使用一个叫做优先队列的 数据结构来进行模拟。
2. 优先队列的应用：医院急诊室
<pre><code>
function Patient(name, code) {
  this.name = name
  this.code = code
}
</code></pre>
<pre><code>
function dequeue() {
  var priority = this.dataStore[0].code
  for(var i = 1; i < this.dataStore.length; ++i) {
    if(this.dataStore[i].code < priority) {
      priority = i
    }
  }
  return this.dataStore.splice(priority, 1)
}
</code></pre>
##### 双端队列
双端队列是与队列类似的项的有序集合。双端队列有两个端部，首部和尾部，并且项在集合中保持不变。双端队不同的地方是添加和删除项是非限制性的。可以在前面或后面添加新项；同样，可以从任一端移除现有项。
* 代码实现
<pre><code>
function Deque() {
  this.dataStore = []
  return this.dataStore
}
</code></pre>
<pre><code>
function addFront(element) {
  this.dataStore.shift(element)
}
</code>
<pre><code>
function addRear(element) {
  this.dataStore.push(element)
}
</code></pre>
<pre><code>
function removeFront() {
  return this.dataStore.unshift()
}
</code></pre>
<pre><code>
function removeRear() {
  return this.dataStore[this.dataStore.length--]
}
</code></pre>
<pre><code>
function isEmpty() {
  return this.dataStore.length > 0 ? false : true
}
</code></pre>
<pre><code>
function size() {
  return this.dataStore.length
}
</code></pre>
* 应用
&nbsp;回文