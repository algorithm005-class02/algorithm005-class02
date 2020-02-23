class Solution {
public:
    int hammingWeight1(uint32_t n) {
        int count = 0;
        while(n != 0){
            n &= (n-1);
            count++;
        }
        return count;
    }

    int hammingWeight(uint32_t n) {
        uint32_t mark = 1;
        int count = 0;
        for(int i = 0; i < 32; ++i){
            count += (n & mark);
            mark <<= 1;
        }
        return count;
    }
                                                                              
};
