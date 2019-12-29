import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int index = 0;
        int jinwei = 0;
        int m=digits.length-2;
        int n=digits.length-2;
        int k=digits.length-2;
        if (digits.length == 1) {//如果是只有一位的数组。则存在两种情况：（1）与1相加之后存在进位，那么结果数组的长度就是2
            //（2）与2相加之后不存在进位，那么结果数组的长度就是1
            int p=(digits[0] + 1) % 10;
            jinwei = (digits[0] + 1) / 10;
            if (jinwei != 0) {//存在进位，则分配两个长度的数组来装结果；
                int result[]=new int[2];
                result[0]=p;
                index++;
                result[index]=jinwei; 
                reverse(result, 0, index);//将结果数组反转一下
                return result;
            }
            else{
                int result[]=new int[1];//不存在进位时，则分配一个长度的数组
                result[0]=p;
                return result;
            }
        } else {//原数组的长度不是1.则需要考虑两种情况，（1）不断存在进位，以至于最终得长度比原数组的长度还长1
            //特殊样例：A[999] +1
            //(2)第二种就是虽然存在进位，但是最左边的数字即A【0】与前一位得进位相加时不会再有进位了
            //因此就需要判断一直加到最左边的时候，是否进位不为0（即为1）；
            jinwei=(digits[digits.length-1]+1)/10;
            if(jinwei!=0){
                while(m>=0){
                    jinwei=(digits[m]+jinwei)/10;
                    m--;
                }//上述while循环就是不断地往前推进，看最左边的位会不会产生进位
                if (jinwei!=0){//产生了进位，那么结果数组的长度就得分配成：原来数组长度+1
                    int result1[]=new int[digits.length+1];
                    result1[index]=(digits[digits.length-1]+1)%10;
                    jinwei=(digits[digits.length-1]+1)/10;
                    while(n>=0){
                        index++;
                        result1[index]=(digits[n]+jinwei)%10;
                        jinwei=(digits[n]+jinwei)/10;
                        n--;
                    }
                    result1[++index]=jinwei;
                    reverse(result1, 0, index);
                    return result1;
                }
                else{//不存在进位，那么结果数组得长度就是原来数组的长度就可以了
                    int result2[]=new int[digits.length];
                    result2[index]=(digits[digits.length-1]+1)%10;
                    jinwei=(digits[digits.length-1]+1)/10;
                    while(k>=0){
                        index++;
                        result2[index]=(digits[k]+jinwei)%10;
                        jinwei=(digits[k]+jinwei)/10;
                        k--;
                    }

                    reverse(result2, 0, index);
                    return result2;
                }
            }
            else{//如果第一次相加就不会产生进位，则从倒数第二位之后就把
                //原先的数组从倒数第二位拷贝进结果数组就好，以及分配的
                //长度就是原来数组的长度就可以装载得结果
                int result2[]=new int[digits.length];
                result2[index]=(digits[digits.length-1]+1)%10;
                while(m>=0){        
                    index++;
                    result2[index]=digits[m];
                    m--;
                }
                reverse(result2, 0, index);
                // System.out.println(index);
                // int step=0;
                // for(int i=0;i<index+1;i++){
                //     zancun[step]=result[i];
                //     step++;
                // }
                return result2;
            }
            
        }
        // return true;
    }
    public void reverse(int nums[],int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
        // return null;
    }
}
// @lc code=end
/* 
//方法一：死做：逐个考虑每一位与1相加之后的可能情况，将原数组化成一个数字来看待
        
*/

/* 

很巧妙的方法：
（1）因为只是加一，所以从未位来看的话，如果末尾取余10之后是0的话，
说明存在进一，那么等价于前面一位也有加1的操作，但凡当前位置取余10之后不是0，
说明当前位置和1相加的值小于10，换言之，当前位置以前的数字还保持原数组中的元素不变
不会存在受到后一位的进位影响，这个时候直接返回数组就可以；
（2）如果整个数组都遍历完了，但是还没有返回数组，只能说明一个情况，就是不断存在进位加1，
那么第一位必然也是取余10等于的0，所以这个时候只需要将原数组全部置为0，并且扩展数组长度
到原来的长度加1，并且令第一位=0就好

        for(int i=digits.length-1;i>=0;i--){
            digits[i]++;
            digits[i]=digits[i]%10;
            if((digits[i]%10)!=0){
                return digits;
            }
        }
        int result[]=new int[digits.length+1];
        result[0]=1;
        return result;
*/