class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t ans = 0; 
       for (uint32_t i = 0; i < 32; i++){
           uint32_t tmp = (uint32_t)1 << i;
           if ((n & tmp) != 0){
               ans += uint32_t(1) << ((uint32_t)31 - i);
           }
       }    
    return ans;    
    }
};