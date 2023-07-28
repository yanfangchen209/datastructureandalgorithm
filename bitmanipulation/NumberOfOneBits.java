/*method 1: use java builtin methods, convert input integer to binarystring, then count char 1's.

In Java, there is no dedicated unsigned integer data type like those found in some other programming languages (e.g., C/C++). Java's primitive data types for integers (byte, short, int, and long) are all signed.

However, Java does support unsigned integer operations on these signed data types using the standard bit manipulation techniques. When you perform bitwise operations on Java's signed data types, the operations are performed as if the numbers were unsigned. 
Java does not have a built-in data type for representing unsigned integers. All primitive data types (byte, short, int, long, float, double, and char) are signed in Java.

In many other programming languages like C/C++, there are explicit data types for unsigned integers, which allow you to represent only non-negative values, effectively doubling the positive range of integers compared to signed data types of the same size.

For example, an unsigned 8-bit integer can represent values from 0 to 255, while a signed 8-bit integer (Java's byte) can represent values from -128 to 127.

While Java doesn't have an explicit unsigned integer type, bit manipulation techniques(and&, or|, xor ^, not ~, left shift<<, right shift>>, unsigned right shift>>>) allow you to work with unsigned operations on Java's signed data types.
*/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       //in java,the input will be given as a signed integer type
       /*convert signed integer to binary string
       Integer.toBinaryString(n):Returns a string representation of the integer argument as an unsigned integer in base 2.
       */

       //  String input = Integer.toString(n);//dones't work
       String input = Integer.toBinaryString(n);

       //count char 1 in string input
       int count = 0;
       for(char c: input.toCharArray()){
           if(c=='1'){
               count++;
           }
       }
       return count;


    }
}

method 2: bit manipulation
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       
       int count = 0;
        while(n != 0){
            //change rightmost 1 to 0
            n &= n - 1;
            count++;
        }
       
        return count;
    }
}
