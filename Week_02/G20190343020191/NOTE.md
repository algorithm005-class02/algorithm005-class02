学习笔记
leetcode22
思路：使用递归打印括号，先两个递归，然后增加参数和条件

```java
//处理当前层
String t1 = s + "(";
String t2 = s + ")";
//三个重复性:如何用左 如何用右 用完了怎么办?
//下一层
if (left < n)
    generate2(left + 1,right, n, s+"(");
if (left > right)
    generate2(left, right+1,n, s+")");
```



# 养成收藏精选代码的习惯
> https://shimo.im/docs/R6g9WJV89QkHrDhr
> 加强切题四件套
> 五毒神掌练习
> 解题思路
> 精选代码
> 时间复杂度
> 中文题解
> 英文题解

# 递归注意点
> 避免人肉递归
> 找重复子问题 找到最近最简单方法，将其拆解成可重复解决的问题
> 数学归纳法

# 树
树是没有环的图
链表是特殊的树

# 树的类定义

# 树的遍历
- pre order  前序 根左右
- in order   中序 左根右
- psot order 后续 左右根
> **树的遍历代码**

# 递归 --树的面试题一般都是递归
# 循环和递归类似

- 递归模板
```java
public void recur(int level,int param){
    if(level>max) return;//结束条件
    process(level,param);//处理当前层逻辑
    recur(level:level+1,newParam);//下探到下一层
    //注意恢复当前层状态  清理当前层，--本身是拷贝
}
```

# python code
```python
list = [1,2,3]
map = {'hello':1,'myu':2}
```

# visualgo.net
> bst
> 数据结构可视化 动画

# 知乎live？



# leetcode刷题记录
236
105
22


# vscode 使用
c-b 隐藏左侧栏
c-p 跳转文件
c-t 列出所有符号
https://segmentfault.com/a/1190000019821154
21个 vscode快捷键
搜索全文 cs-f
重新打开 cs-t
匹配文本打开 c-t
选项卡移动组 ca-左右
删除上一个单词 c-bs
复制行       as-下箭头
修改匹配文本  c-f2
编辑器tab左右移动 cs-pd
列编辑        ca-上箭头
切换tab       c-tab
# 抛弃word
markdown 贴图
w-s s windows截图
c-a v 粘贴图片

# 安装插件
paste image
markdown enhance previewp

# vscode 测试推送github
github push
