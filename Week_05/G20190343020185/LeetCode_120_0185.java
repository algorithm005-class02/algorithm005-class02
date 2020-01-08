class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = triangle.get(0).get(0);
        //将每一层的每一列赋值为顶点走到当前位置的最短路径，每次赋值找最小值
        for(int i = 1; i < triangle.size(); i++){
            //将当前行第一列的值赋值为走到当前位置的路径和
            triangle.get(i).set(0,triangle.get(i).get(0)+triangle.get(i-1).get(0));
            min = triangle.get(i).get(0);
            for(int j = 1; j < triangle.get(i).size()-1; j++){
                //比较找出从上一层走到当前位置两种可能的最小值，赋值到当前位置
                int tmp = triangle.get(i-1).get(j-1) > triangle.get(i-1).get(j) ? triangle.get(i-1).get(j) + triangle.get(i).get(j) : triangle.get(i-1).get(j-1) + triangle.get(i).get(j);
                triangle.get(i).set(j,tmp);
                min = min > tmp ? tmp : min;
            }
            //将当前行最后列的位置赋值为从顶点走到当前位置的路径和
            triangle.get(i).set(triangle.get(i).size()-1,triangle.get(i).get(triangle.get(i).size()-1)+triangle.get(i-1).get(triangle.get(i-1).size()-1));
            min = min > triangle.get(i).get(triangle.get(i).size()-1) ? triangle.get(i).get(triangle.get(i).size()-1) : min;
        }
        return min;
    }
}
