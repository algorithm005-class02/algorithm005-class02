class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        int five = 0;
        int ten = 0;
        int fail = 0;
        for(int i = 0; i < bills.size(); i++){
            //1、收入5元，只需增加五元库存。
            //2、收入10元，只能找五元。如果五元库存为0则失败；否则五元库存-1。
            //3、收入20元，(10+5)：如果十元和五元均有库存，各自库存减1；或(5+5+5)：如果五元库存大于3，库存减3；否则失败
            if(bills[i] == 5) five++;
            else if(bills[i] == 10 && five > 0){
                five--;
                ten++;
            }
            else if(bills[i] == 20 && ten > 0 && five > 0) {
                ten --;
                five --;
            } else if(bills[i] == 20 && five >= 3){
                five = five - 3;
            } else {
                fail = 1;
                break;
            }           
        }
        if(fail) return false;
        else return true;
    }
/*
    bool lemonadeChange(vector<int>& bills) {
        int fives = 0;
        int tens = 0;
        int twenties = 0;
        int fail = 0;
        int change = 0;
        int twen_nums = 0;
        int ten_nums = 0;
        int five_nums = 0;
        for(int i = 0; i < bills.size(); i++){
            if(bills[i] == 20) twenties++;
            else if(bills[i] == 10) tens++;
            else if(bills[i] == 5)  fives++;
            change = bills[i] - 5;
            if(change == 0) continue;
            twen_nums = change/20;
            if(twen_nums <= twenties){
                change = change - twen_nums*20;
                twenties -= twen_nums;
            } else {
                change = change - twenties*20;
                twenties = 0;
            }
            ten_nums = change/10;
            if(ten_nums <= tens){
                change = change - ten_nums*10;
                tens -= ten_nums;
            } else {
                change = change - tens*10;
                tens = 0;
            }
            five_nums = change/5;
            if(five_nums <= fives){
                change = change - five_nums*5;
                fives -= five_nums;
            } else {
                change = change - fives*5;
                fives = 0;
            } 
            if(change != 0){
                fail = 1;
                break;
            }  
        }
        if(fail == 1)
            return false;
        return true;
    }
*/
};