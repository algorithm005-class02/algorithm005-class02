/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
    var head = 0;
    for(var i = 0; i < arr2.length; i++){
        for(var j = head; j < arr1.length; j++){
            var tmp = 0;
            if(arr1[j] == arr2[i]){
                tmp = arr1[j];arr1[j]=arr1[head];arr1[head++]=tmp;
            }
        }
    }
    var arr3 = arr1.slice(head,arr1.length);
    arr3.sort((a,b)=>(a-b));
    arr1.splice(head,arr1.length-head,...arr3);
    return arr1;
};
