int min(int x, int y){
    return x<y?x:y;
}
int max(int x, int y){
    return x>y?x:y;
}

int trap(int* height, int heightSize){
    int area = 0;
    int max_left;
    int max_right;
    int num;
    for(int i = 0 ; i < heightSize; i++){
        max_left = 0;
        max_right = 0;
        for(int j = i-1 ; j >= 0; j--){
            max_left = max(max_left, height[j]);
        }
        for(int k = i+1 ; k < heightSize; k++){
            max_right = max(max_right, height[k]);
        }
        num = min(max_left, max_right) - height[i];
        area += num > 0 ? num : 0;
    }
    return area;
}