package algorithm.leetcode.排序;

public class Sort {
    
    //先排序左右子数组，然后合并两个有序子数组
    public static void mergeSort(int[] array,int left,int right){
        if(right<=left) return;
        int mid = (left+right)>>1;
        mergeSort(array,left,mid);
        mergeSort(array,mid+1,right);
        merge(array,left,mid,right);
    }

    private static void merge(int[] array, int left, int mid, int right) {

        int[] temp = new int[right-left+1];
        int i=left,j=mid+1,k=0;
        while( i<=mid && j<=right ){
            temp[k++]= array[i]<=array[j]?array[i++]:array[j++];
        }
        while (i<=mid) temp[k++]=array[i++];
        while (j<=right) temp[k++]=array[j++];

        for(int p=0;p<temp.length;p++){
            array[left+p]=temp[p];
        }

    }

    //先调配处左右子数组，然后对于左右子数组进行排序
    public static void quickSort(int[] array,int begin,int end){

        if(end<=begin){
            return;
        }
        int pivot = partition(array,begin,end);
        System.out.println(array);
        quickSort(array,begin,pivot-1);
        quickSort(array,pivot+1,end);

    }

    /**
     * 选取一个pivot元素，将小于pivot的元素移动到左边，大于pivot的元素移动到右边，最后返回pivot的位置
     * @param array
     * @param begin
     * @param end
     * @return
     */
    private static int partition(int[] array,int begin,int end){
        //pivot定为end。
        //counter定为小于pivot元素个数，另一个作用是来标识潜在的下一个可以交换的元素
        int pivot = end,counter=begin;
        for(int i=begin;i<end;i++){
            if(array[i]<array[pivot]){
                //交换array[counter]和array[i]元素
                int temp = array[counter];array[counter]=array[i];array[i]=temp;

                counter++;
            }
        }
        //交换pivot和counter
        int temp = array[pivot];array[pivot] = array[counter];array[counter]=temp;
        return counter;
    }



    public static void heapSort(int[] array){
        if(array.length==0) return;
        int length = array.length;
        for(int i =  (length/2-1);i>=0;i--){
            heapify(array,length,i);
        }
        for(int i=length-1;i>=0;i--){
            int temp = array[0];array[0]=array[i];array[i]=temp;
            heapify(array,i,0);
        }

    }

    private static void heapify(int[] array,int length,int i){
        int left = i<<1+1;
        int right = i<<1+2;
        int largest = i;
        if(left<length && array[left]>array[largest]){
            largest = left;
        }
        if(right<length && array[right]>array[largest]){
            largest=right;
        }
        if(largest!=i){
            int temp = array[i];array[i]=array[largest];array[largest]=temp;
            heapify(array,length,largest);
        }

    }


    public static void main(String args[]){
        int[] arr = {12,5,3,1,5,8,9,10};
        Sort.quickSort(arr,0,arr.length-1);
        System.out.print(arr);

    }


}
