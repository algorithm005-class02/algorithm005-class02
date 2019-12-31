//自己写的，效率差，实际用个计数器就好了
class Solution {
    public boolean lemonadeChange(int[] bills)
    {
        Map<Integer,Integer> cashbox = new HashMap<Integer,Integer>();
        cashbox.put(5,0);
        cashbox.put(10,0);
        cashbox.put(20,0);

        for(Integer cash:bills){
            if(cash==5){
                cashbox.put(5,cashbox.get(5)+1);
            }else if(cash==10){
                if(cashbox.get(5)>=1){
                    cashbox.put(5,cashbox.get(5)-1);
                    cashbox.put(10,cashbox.get(10)+1);
                }else{
                    return false;
                }

            }else if(cash==20){
                //有两种找零方法：10,5或 5,5,5
                if(cashbox.get(5)>=1  && cashbox.get(10)>=1  ){
                    cashbox.put(5,cashbox.get(5)-1);
                    cashbox.put(10,cashbox.get(10)-1);
                    cashbox.put(20,1);

                }else if(cashbox.get(5)>=3) {
                    cashbox.put(5,cashbox.get(5)-3);
                    cashbox.put(20,1);
                }else{
                    return false;
                }
            }
        }
        return true;

    }
}