class Solution {
public:
    bool isPerfectSquare(int num) {
        int start=1;
        int end=num;
        int mid=start+(end-start)/2;
        while(start<=end)
        {
            if(pow(mid,2)>num)
            {
                end=mid-1;
            }
            else if(pow(mid,2)<num)
            {
                start=mid+1;
            }
            else return true;
            mid=(end-start)/2+start;
        }
        return false;
    }
};
