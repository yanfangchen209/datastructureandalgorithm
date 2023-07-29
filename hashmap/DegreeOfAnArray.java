//method 1:
class Solution {
    public int findShortestSubArray(int[] nums) {

    /*find degree of an array by building hashmap,
    key is unique element, value is count of each unique element*/
   
    Map<Integer, Integer> map = new HashMap<>();
    for(int num: nums){
        map.put(num, map.getOrDefault(num, 0) + 1);
    }
    /**max(Collection<? extends T> coll)
Returns the maximum element of the given collection, according to the natural ordering of its elements. */

    int degree = Collections.max(map.values());
    int res = nums.length;
    for(int key: map.keySet()){
        if(map.get(key) == degree){
            res = Math.min(res,findSubarrayLength(nums, key));
            System.out.println(res);
        }
    }
    return res;
    }

    private int findSubarrayLength(int[] arr, int num){
        int start = firstOccurenceIndex(arr, num);
        int end = lastOccurenceIndex(arr, num);
        int subarrayLength = end - start + 1;
        return subarrayLength;
    }

    private int firstOccurenceIndex(int[]arr, int num){
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] == num){
                return i;
            }
        }
        return -1;
    }

    private int lastOccurenceIndex(int[] arr, int num){
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] == num){
                return i;
            }
        }
        return -1;
    }
}


/*method 2: create left map to store first occurnece (element,index)pair,
right map to store last occurence (element , index) pair.*/

class Solution {
    public int findShortestSubArray(int[] nums) {
    
    Map<Integer, Integer> firstOccurence = new HashMap<>();
    Map<Integer, Integer> lastOccurence = new HashMap<>();
    Map<Integer, Integer> map = new HashMap<>();

    for(int i = 0; i < nums.length; i++){
        int n = nums[i];
//only add first occurence of element to this map
        if(!firstOccurence.containsKey(n)){
            firstOccurence.put(n, i);
        }
        //alwarys add each elment to this map in case some element only occurs once and lastOccurence.get(key)==null 
        lastOccurence.put(n, i);
        
        map.put(n, map.getOrDefault(n, 0) + 1);
    }
    /**max(Collection<? extends T> coll)
Returns the maximum element of the given collection, according to the natural ordering of its elements. */

    int degree = Collections.max(map.values());
    int res = nums.length;
    for(int key: map.keySet()){
        if(map.get(key) == degree){
            res = Math.min(res, lastOccurence.get(key) - firstOccurence.get(key) + 1);

        }
    }
    return res;
    }
}