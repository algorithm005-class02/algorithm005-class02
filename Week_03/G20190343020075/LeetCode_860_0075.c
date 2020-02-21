bool lemonadeChange(int* bills, int billsSize){
    int five = 0;
    int ten = 0;
    for (int cnt = 0; cnt < billsSize; ++cnt) {
        if (bills[cnt] == 5) {
            five++ ;
        }
        else if (bills[cnt] == 10) {
            if (five == 0) { return false; }
            ten++;
            five--;
        }
        else {
//        一个10 一个 5
            if (five > 0 && ten > 0) {
                five--;
                ten--;
            }
//        三个5
            else if ( five >= 3 ) {
                five -= 3;
            }
            else {
                return false;
            }

        }

    }

    return true;
}
