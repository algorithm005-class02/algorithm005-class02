
##Trie树+dfs实现 word search 2 时间复杂度

假设：  
有n个单词，每个单词平均长度为 k ，二维数组board的字符总个数是m个

那么：
1. 构建Trie树： n*k  
2. dfs时间复杂度分析：
    1. 每次dfs的的时间复杂度： 4**k。 因为dfs，每一步有4种可能，是个4通道，单词平均长度为 k 也就是说平均 k 步可以走完Trie树。因此，dfs平均而言走了4\*4\*......4（共K个连乘）
    2. 共做了m次，也就是二维数组board的字符总个数次。
    3. 时间复杂度为m*(4**k)
3. 总的时间复杂度为 n\*k+m**(4**k)



##Trie树Java模板

```java


import java.util.HashMap;
import java.util.Map;


public class TrieTree {

    private TrieNode root = new TrieNode();
    private static TrieNode end = new TrieNode();
    private static Character end_of_word = '#';


    public TrieTree()
    {

    }

    public void insert(String word){

        TrieNode p = root;
        int length = word.length();
        for(int i=0;i<length;i++){
            Character c = word.charAt(i);
            TrieNode t = p.children.getOrDefault(c,new TrieNode());
            p.children.put(c,t);
            p = t;
        }
        p.children.put(end_of_word,end);

    }
    public boolean search(String word){

        TrieNode p = root;
        for(char c : word.toCharArray()){

            if(p.children.containsKey(c)){
                p = p.children.get(c);
            }else{
                return false;
            }

        }
        return p.children.containsKey('#');
    }
    public boolean startWith(String word){
        TrieNode p = root;
        for(char c : word.toCharArray()){

            if(p.children.containsKey(c)){
                p = p.children.get(c);
            }else{
                return false;
            }

        }
        return true;
    }
    public static void main(String args[]){
        String[] worlds = {"hello","help","Australia","August","heaven","heavy","OK","O"};
        TrieTree tree = new TrieTree();
        for(String s:worlds){
            tree.insert(s);
        }
        for(String c:worlds){
            System.out.println(tree.search(c.substring(0,1)));
        }

    }
}

class TrieNode {

    public Map<Character,TrieNode> children = new HashMap<>();


}



```

##双向BFS模板

```python


def bi_bfs(graph, start, end):
    visited = set()
    
    queueStart.append(start) 
    queueEnd.append(end) 
    int level=1
    while queueStart && queueEnd: 
        if len(queueStart)>len(queueEnd):
            tmp = queueStart
            queueStart=queueEnd
            queueEnd=tmp
        queue = [] 
        for node in queueStart:
            if node in endQueue:
                return level+1
            if node not in visited:
                process(node) 
                nodes = generate_related_nodes(node)
                for node in nodes:
                    if not node in visited:
                        queue.append(node)
        queueStart=queue
        level = level+1
                



    # other processing work 
	...
}

```
