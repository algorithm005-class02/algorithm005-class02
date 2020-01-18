import java.util.*;

/**
 * 最小基因变化
 * https://leetcode.com/problems/minimum-genetic-mutation/
 */
public class Leetcode_433_minimumGeneticMutation {

    /**
     * BFS
     * 逐层搜索，先搜索变化1个的所有基因序列，再搜索变化2个的所有基因序列...
     */
    public static int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }

        char[] geneArr = new char[]{'A', 'C', 'G', 'T'};
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> bankSet = new HashSet<>();

        Collections.addAll(bankSet, bank);
        queue.add(start);
        visited.add(start);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String curStr = queue.poll();
                if (curStr.equals(end)) {
                    return level;
                }

                char[] charArr = curStr.toCharArray();
                for (int i = 0; i < charArr.length; i++) {
                    char old = charArr[i];
                    for (char aGeneArr : geneArr) {
                        charArr[i] = aGeneArr;
                        String newGene = new String(charArr);
                        if (!visited.contains(newGene) && bankSet.contains(newGene)) {
                            queue.add(newGene);
                            visited.add(newGene);
                        }
                    }
                    charArr[i] = old;
                }
                size--;
            }
            level++;
        }

        return -1;
    }


    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(minMutation(start, end, bank));
    }

}
