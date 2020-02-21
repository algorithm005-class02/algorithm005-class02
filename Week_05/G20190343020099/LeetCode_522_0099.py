class Solution:
    def checkRecord(self, n: int) -> int:
        if n == 0:
            return 1
        M = 10**9 + 7
        #对于某个长度为i的记录序列，以下变量表示对应情况的序列数量
        #P: 序列中没有A，最新的一个记录不是L
        #AP: 序列中有过A，最新的一个记录不是L
        #L: 序列中没有A，最新的一个记录是L
        #AL: 序列中有过A，最新的一个记录是L
        #LL: 序列中没有A，最新的两个记录是LL
        #ALL: 序列中有过A，最新的两个记录是LL
        #A: 最新的一个记录是A
        P, AP, L, LL, AL, ALL, A = 1, 0, 1, 0, 0, 0, 1
        #对于长度为1的情况，记录的第一次是 P, L, A 均可奖励，都是只有1种
        for i in range(2, n+1): #遍历长度为2~n的记录
            #等号左边计算长度为i的记录序列的结果，右边引用长度为i - 1的记录序列的结果
            #必须写在一起，否则可能引用的是更新过后的值
            P, AP, L, LL, AL, ALL, A = (
                (P + L + LL) % M,			#如果第i次记录是P
                (AP + AL + ALL + A) % M,  		#如果第i次记录是P
                P,					#如果第i次记录是L
                L,					#如果第i次记录是L
                (AP + A) % M,				#如果第i次记录是L
                AL,					#如果第i次记录是L
                (P + L + LL) % M,			#如果第i次记录是A
            )
        return (P + AP + L + LL + AL + ALL + A) % M