

#尝试用python写的，勉强通过
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        ret = 0
        valley=None
        climax=None

        for i in range(len(prices)):
            if i==0:
                previous = prices[0]
            else:
                previous = prices[i-1]
            current = prices[i]
            if i==(len(prices)-1):
                next_ = prices[i]
            else:
                next_ = prices[i+1]
            if valley==None:
                #TODO：判断当前点是否为谷底
                if previous>=current and current<next_:
                    valley=current
                    previous = current

            else:
                #TODO: 判断当前点是否为高峰
                if current>previous and current>=next_:
                    climax=current
                    aret = climax-valley
                    ret = ret+aret
                    climax=None
                    valley=None
        return ret