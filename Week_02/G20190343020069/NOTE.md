# 第一周学习总结

本周的学习总结有以下几点内容：
## 学习内容

主要学习了以下几种数据结构或算法：

* 哈希表
* 递归
* 树
* 二叉树
* 二叉搜索树

我在工作中经常使用哈希表（HashMap、HashSet），也经常会使用到递归和树。递归的话我们在处理系统的菜单、用户、机构信息等数据时使用地比较多。所以，看覃老师讲的课程内容时，比较容易理解。感觉平时使用树的机会比较少，常用的就是菜单树、机构树这两种应用场景了。

## 算法实战

作业中，我选的是异位词（LeetCode 242）和二叉树中序遍历(LeetCode 94)两道题目。

## 源码分析

### HashMap
* put

这个方法的功能是将键值对放入Node的数据结构中。如果放入的键的值已经存在，则用新的值替换旧的值。

其中，node是一个链表数据结构

```
 static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }
```

* get

get方法跟put是一对共生的方法，它是根据key的hash值去Node这个数据结构中寻找对应的value,是查找的动作

时间复杂度：？
空间复杂度：？


## 总结：

虽然,Java开发工作中，HashMap是常用的一种数据结构，这次作业分析源码时，当我打开源码依然陌生。get方法的时间复杂度和空间复杂度需要好好分析一下。Node 链表也需要再进一步研究一下。先提交作业了，抽时间完善。