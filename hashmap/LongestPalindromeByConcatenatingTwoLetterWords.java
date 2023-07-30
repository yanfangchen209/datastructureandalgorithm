solution 1:
/**
1.to construct a palindrome, If we prepend the word "ab" on the left, we must append
"ba" on the right to keep it a palindrome; and The number of times we can do this is the minimum of (occurrences of "ab") and (occurrences of "ba"). eg. ab: 4 count, ba: 5 count, we only have 4 count ab and 4 count ba in the final palindrome
2.For words that are already palindromes, e.g. "aa", we can prepend and append these in pairs as described in the previous steps. We can also use exactly one in the middle to form an even longer palindrome.eg. cc: 3, dd: 5 we can only keep
cc:2, dd :4 and any one of cc, dd in the final palindrome, 
 */
class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String s: words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int len = 0;
        boolean oddFlag = false;
        for(String word: map.keySet()){
            //if it's 'aa' word, only one word "aa" can be in center
            if(word.charAt(0) == word.charAt(1)){
                if(map.get(word) % 2 == 0){
                    len += map.get(word);
                }else{
                    len += map.get(word) - 1;
                    oddFlag = true;
                }
            }else if(word.charAt(0) < word.charAt(1)){
                String reversedWord = "" + word.charAt(1) + word.charAt(0);
                if(map.containsKey(reversedWord)){
                    len += 2 * Math.min(map.get(word), map.get(reversedWord));
                }
            }
        }//for end

        if(oddFlag){
            len++;
        } 
        return len * 2;
    }
}


solution2:
class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String s: words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int len = 0;
        boolean flag = false;
        for(String s: map.keySet()){
            //if it's 'aa' word, only one word "aa" can be in center
            if(isPalindrome(s)){
                int count = map.get(s);
                if(count % 2 == 0){
                    len += count;
                    System.out.println(len);
                }else{
                    flag = true;
                    len += count - 1;
                    System.out.println(len);
                }
            }else{
                //if it's "ab" word
                String reversedString = reversed(s);
                System.out.println(reversedString);
                if(map.containsKey(reversedString)){
                    len += Math.min(map.get(s), map.get(reversedString));
                }
            }
        }//for end

        if(flag){
            len++;
        } 
        return len*2;
    }

    //reverse on word of length 2
    public String reversed(String t){
        String reversedString = "" +  t.charAt(1) + t.charAt(0);
        return reversedString;
    }//

    //check if a string of length 2 has same characters
    public boolean isPalindrome(String s){
        if(s.charAt(0) != s.charAt(1)){
            return false;
        }else{
            return true;
        }
    }//
}