class Solution(object):
    def plusOne(self, digits):
        return [int(j) for j in str(int(''.join('%s' % i for i in digits))+1)]