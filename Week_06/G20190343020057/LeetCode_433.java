class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(start == end) return 0;
        // if(!bank.contains(end)) return -1;
        List<String> listBank = Arrays.asList(bank); //将数组转化为列表，再从列表变成Set
        Set<String> bankSet = new HashSet(listBank);
        if(!bankSet.contains(end)) return -1;

        Set<String> beginSet = new HashSet();
        Set<String> endSet = new HashSet();
        Set<String> visited = new HashSet();
        beginSet.add(start);
        endSet.add(end);
        int len = 0;

        char[] geneA = {'A','C','G','T'};
        while(!beginSet.isEmpty()&&!endSet.isEmpty()){ //只要两个集合不为空，就一直循环
            if(beginSet.size() > endSet.size()){
                //双端BFS，每次用小的
                Set<String> set = endSet;
                endSet = beginSet;
                beginSet = set;
            }

            Set<String> temp = new HashSet();
            for(String gene: beginSet){
                char[] geneChar = gene.toCharArray();
                
                for(int i=0;i<geneChar.length;i++){//遍历基因位
                    for(char g:geneA){ //遍历基因种类
                        char old = geneChar[i];
                        if(g == old) continue;
                        geneChar[i] = g;
                        String newGene = String.valueOf(geneChar);

                        if(endSet.contains(newGene)){//如果新变化的基因在endSet有，证明已经完全找到
                            return len+1;
                        }

                        if(!visited.contains(newGene)&& bankSet.contains(newGene)){//新增基因既不包含在已访问集合中又是合法的
                            temp.add(newGene); 
                            visited.add(newGene);
                        }
                        geneChar[i] = old;
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return -1;
    }
    
}
