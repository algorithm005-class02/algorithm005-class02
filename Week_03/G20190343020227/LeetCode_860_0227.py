class Solution(object):
    def lemonadeChange(self, bills):
        """
        :type bills: List[int]
        :rtype: bool
        """
        self.five,self.ten,self.twinty = 0,0,0
        def payBackCheck(pay_back_money):
            if pay_back_money == 5:
                if self.five != 0:
                    self.five -= 1
                    self.ten += 1
                    return True
                else:
                    return False
            if pay_back_money == 15:
                if self.ten >= 1 and self.five >= 1:
                    self.ten  -= 1
                    self.five -= 1
                    self.twinty +=1
                    return True
                elif self.five >= 3:
                    self.five -= 3
                    return True
                else:
                    return False


        while bills != []:
            in_money = bills.pop(0)
            if in_money == 5:
                self.five += 1
            else:
                pay_back_money = in_money - 5
                if payBackCheck(pay_back_money):
                    continue
                else:
                    return False
        return bills == []