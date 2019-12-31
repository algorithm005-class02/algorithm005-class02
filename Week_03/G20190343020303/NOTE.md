分治:
1.termintator
2.process(split your big problem)
3.drill down(sbuproblems), merge(subsult)
4.reverse states;

深度优先:
void dfs(node, visited){
visited.add(node)
foreach(next_node in node.children()){
    if （!visited.find(next_node)){
         dfs(next_node, visited);
    }
}
 

贪心算法与动态规划的不同在于它对每个字问题的解决方案都是做出选择，不能回退。
动态规划则保存以前的运算结果，根据以前的结果对当前进行选择，有回退功能

