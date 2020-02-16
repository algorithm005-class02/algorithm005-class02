# 学习笔记  
# 动态规划
## 常用模板
这两个模板是基本模板，需要非常熟练；
        
        //递归模板
        public void recur(int level, int param){
            //terminator
            if(level > Max_value){
                //process result
                return;
            }
            
            //process the current logic
            process(level, param);
            
            //drill down
            recur(level + 1, newParam);
            
            //restore current status            
        }
        
        // 分治代码
        def divide_conquer(problem, param1, param2, ...):
            #recursion terminator
            if problem is None:
                print_result
                return
            
            #prepare data
            data = prepare_data(problem)
            subProblem = split_problem(problem, data)
            
            #conquer subProblems
            subresult1 = self.divide_conquer(subProblem[0], p1, ...)
            subresult2 = self.divide_conquer(subProblem[1], p2, ...)
            subresult3 = self.divide_conquer(subProblem[2], p3, ...)
            ...
            
            #process and generate the final result
            result = process_result(subresult1, subresult2, subresult3, ...)
            
            #revert the current level states
            

## 感触
1. 人肉递归低效、很累；
2. 找到最近最简方法，将其拆分成可重复解决的问题；
3. 使用数学归纳法来辅助思考；

## 关键点
- 写出状态方程
- 动态规划和递归或者分治没有根本上的区别（关键看有无最优子结构）
- 找重复子问题
- 中途可以淘汰次优解

## 复杂度的来源
1. 状态拥有更多维度（二维、三维、或者更多维度、甚至需要压缩）
2. 状态方程更加复杂

# 字符串
## 字符串的基本操作
字符串的题非常考验基本功，所以对字符串的基本操作要烂熟于胸；
1. 字符串的比较；  
Java:  
    string x = "abb";  
    string y = "abb";  
    x == y;  (false)  
    x.equals(y);  (true)
    x.equalsIgnoreCase(y);  (true)
2. 字符串的遍历；
3. 去空格 trim;
4. 转数组 toCharArray;
5. 子串 subString;
6. 子串队列 subSequence;
7. 检查前缀 startWith;
8. 分隔 split;
9. 替换 replace;