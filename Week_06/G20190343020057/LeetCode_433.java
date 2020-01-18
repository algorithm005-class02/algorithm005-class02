class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(start == end) return 0;
        // if(!bank.contains(end)) return -1;
        List<String> listBank = Arrays.asList(bank);
        Set<String> bankSet = new HashSet(listBank);
        if(!bankSet.contains(end)) return -1;

        Set<String> beginSet = new HashSet();
        Set<String> endSet = new HashSet();
        Set<String> visited = new HashSet();
        beginSet.add(start);
        endSet.add(end);
        int len = 0;

        char[] geneA = {'A','C','G','T'};
        while(!beginSet.isEmpty()&&!endSet.isEmpty()){
            if(beginSet.size() > endSet.size()){
                //双端BFS，每次用小的
                Set<String> set = endSet;
                endSet = beginSet;
                beginSet = set;
            }

            Set<String> temp = new HashSet();
            for(String gene: beginSet){
                char[] geneChar = gene.toCharArray();
                
                for(int i=0;i<geneChar.length;i++){
                    for(char g:geneA){
                        char old = geneChar[i];
                        if(g == old) continue;
                        geneChar[i] = g;
                        String newGene = String.valueOf(geneChar);

                        if(endSet.contains(newGene)){
                            return len+1;
                        }

                        if(!visited.contains(newGene)&& bankSet.contains(newGene)){
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