//method 1: try brute force

class Solution {
    public void rotate(int[] nums, int k) {
        //if k=5, after rotating 5 times, array will be the same
        k %= nums.length;
        
        /**
        totally k rounds, for each round: save last element in temp variable, put number with index j to its next index, that's shift to right by one, finally put previous save temp in index 0 position.
         */
        int temp;
        for (int i = 0; i < k; i++){
            temp = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
              nums[j + 1] = nums[j];
            }
            nums[0] = temp;
        }
    }
}

/**
Time complexity: O(n×k)
All the numbers are shifted by one step(O(n))k times.
Space complexity: O(1). No extra space is used. */


//method 2: try extra data store, use arraylist

class Solution {
    public void rotate(int[] nums, int k) {
        //if k=5, after rotating 5 times, array will be the same
        k %= nums.length;
        
        /**
        1 2 3 4 5 , if k=2; rotated array is 4 5 1 2 3
        add second part element to arraylist, then first part, copy to array, done
        */

        List<Integer> list = new ArrayList<>();

        int length = nums.length;

        //add second part elements to arraylist
        for(int i = length - k; i < length; i++){
            list.add(nums[i]);
        }
        //add first part elements to arraylist
        for(int j = 0; j < length - k; j++){
            list.add(nums[j]);
        }

        //copy integer in arraylist to array nums
        for(int i = 0; i < length; i++){
            nums[i] = list.get(i);
        }

    }
}

/**
Time complexity: O(n).
two passes is used to put the numbers in the arraylist.
And another pass to copy arraylist to the original array.
Space complexity: O(n). Another arraylist is used.
 */

//method 3: reverse, the best solution

class Solution {
  public void rotate(int[] nums, int k) {

      k %= nums.length;
      //reverse the whole array
      reverse(nums, 0, nums.length - 1);

      //reverse first part
      reverse(nums, 0, k-1);

      //reverse second part
      reverse(nums, k, nums.length - 1);
  }
  //use two pointers to reverse array
  public void reverse(int[] arr, int start, int end){
      int temp;
      while(start < end){
          temp = arr[start];
          arr[start] = arr[end];
          arr[end] = temp;
          start++; 
          end--;
      }
  }
}

/**
Time complexity: O(n). n elements are reversed a total of three times.
Space complexity: O(1).
 */