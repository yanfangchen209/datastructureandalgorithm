/**the maximum positive value an int can hold is 2,147,483,647, which has 10 digits. 
the maximum positive value a long can hold is 9,223,372,036,854,775,807, which has 19 digits.
The maximum number of digits a BigInteger can hold is practically unlimited and depends on the amount of 
memory available in the computer.
so we cannot transfer the arry to integer for this problem.
*/
/*solution 1: get last digit of k and add to num elements from right to left*/
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        int i = num.length - 1;
        int carry = 0;
        while(i >= 0 || k > 0 || carry > 0){
            int num_digit = i >= 0 ? num[i] : 0;
            int k_digit = k % 10;
            int sum = num_digit + k_digit + carry;
            int res_digit = sum % 10;
            res.addFirst(res_digit);
            carry = sum / 10;
            k /= 10;
            i--;
        }

        return res;
    }


/*solution 2:In this solution, we don't explicitly handle the carry separately. Instead, we add the values directly to K as we traverse through the array A

- we put the entire addend in the first column from the right.

Continuing the example of 123 + 912, we start with [1, 2, 3+912]. Then we perform the addition 3+912, leaving 915. The 5 stays as the digit, while we 'carry' 910 into the next column which becomes 91.

We repeat this process with [1, 2+91, 5]. We have 93, where 3 stays and 90 is carried over as 9. Again, we have [1+9, 3, 5] which transforms into [1, 0, 3, 5].
*/

    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        int i = num.length - 1;
        while(i >= 0 || k > 0){
            int num_digit = i >= 0 ? num[i] : 0;
            k += num_digit;
            int res_digit = k % 10;
            res.addFirst(res_digit);
            k /= 10;
            i--;
        }
        return res;
    }
 
      