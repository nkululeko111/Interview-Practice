package org.interview;

import java.util.HashMap;


/* **Problem Statement:**
Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

**Example:**
Input: `nums = [2, 7, 11, 15]`, `target = 9`
Output: `[0, 1]`
Explanation: `nums[0] + nums[1] = 2 + 7 = 9`.  */
import java.util.*;

public class TwoSumSolution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            else
                map.put(nums[i], i);
        return new int[0]; // No solution case (or throw an exception)
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }



   /*  **Explanation:**
- We use a `HashMap` to store the value and its index as we iterate through the array.
- For each element, we calculate its complement (`target - nums[i]`).
- If the complement exists in the map, we return the indices of the current element and its complement.
- If not, we add the current element to the map and continue.
 */
}


/* ### **2. Reverse a String (HackerRank)**
        **Problem Statement:**
Write a function that reverses a string. The input string is given as an array of characters `s`.
You must do this by modifying the input array in-place with `O(1)` extra memory.

        **Example:**
Input: `s = ["h", "e", "l", "l", "o"]`
Output: `["o", "l", "l", "e", "h"]`

        **Solution:** */

class ReverseString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}


/*
        **Explanation:**
- Use two pointers, `left` and `right`, initialized to the start and end of the array.
- Swap the characters at the `left` and `right` pointers.
- Move the `left` pointer forward and the `right` pointer backward until they meet.
*/

/*3. Fibonacci Number (LeetCode)
        **Problem Statement:**
The Fibonacci numbers, commonly denoted `F(n)`, form a sequence called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from `0` and `1`.
Given `n`, calculate `F(n)`.

        **Example:**
Input: `n = 4`
Output: `3`
Explanation: `F(4) = F(3) + F(2) = 2 + 1 = 3`.

        **Solution:** */

class Fibonacci {
    public int fib(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}


 /*        **Explanation:**
- Use an iterative approach to avoid the overhead of recursion.
- Initialize `a` and `b` to `0` and `1`, representing `F(0)` and `F(1)`.
- Iterate from `2` to `n`, updating `a` and `b` to store the last two Fibonacci numbers.

 */

//        ### **4. Valid Parentheses (LeetCode)**
//        **Problem Statement:**
//Given a string `s` containing just the characters `(`, `)`, `{`, `}`, `[`, and `]`, determine if the input string is valid.
//An input string is valid if:
//        1. Open brackets must be closed by the same type of brackets.
//2. Open brackets must be closed in the correct order.
//
//**Example:** */
/* Input: `s = "()[]{}"`
Output: `true`

        **Solution:**
         */

class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}


/*
        **Explanation:**
- Use a stack to keep track of opening brackets.
- For every closing bracket, check if it matches the top of the stack.
- If the stack is empty or the brackets don’t match, return `false`.
- Finally, ensure the stack is empty to confirm all brackets are closed.

*/


/* ### **5. Merge Two Sorted Lists (LeetCode)**
        **Problem Statement:**
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

**Example:**
Input: `l1 = [1, 2, 4]`, `l2 = [1, 3, 4]`
Output: `[1, 1, 2, 3, 4, 4]`

        **Solution:**
        ```java */
class ListNodes {
    int val;
    ListNodes next;
    ListNodes(int x) { val = x; }
}

class MergeTwoSortedLists {
    public ListNodes mergeTwoLists(ListNodes l1, ListNodes l2) {
        ListNodes dummy = new ListNodes(0);
        ListNodes current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}


/*
        **Explanation:**
- Use a dummy node to simplify the merging process.
- Compare the values of the nodes in both lists and link the smaller one to the result.
- Append the remaining nodes from the non-empty list.
*/



/* 1. Find the First Non-Repeating Character in a String
Problem Statement:
Given a string s, find the first non-repeating character and return its index. If it doesn't exist, return -1.
Example:
Input: "leetcode"
Output: 0
Input: "loveleetcode"
Output: 2
Solution: */

class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (countMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}

/* Explanation:
Use a HashMap to store character frequencies.
Traverse the string again to find the first character with a frequency of 1.

2. Check If a Number is Prime
Problem Statement:
Write a function to check whether a given integer n is prime.
Example:
Input: 7
Output: true
Input: 10
Output: false
Solution: */

class PrimeNumber {
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

/* Explanation:
Any number ≤1 is not prime.
Check divisibility from 2 to sqrt(n).
If n is divisible by any number in this range, it is not prime.

3. Find the Missing Number in an Array
Problem Statement:
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the missing number.
Example:
Input: [3, 0, 1]
Output: 2
Solution: */

class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}

/* Explanation:
The sum of first n natural numbers is n * (n + 1) / 2.
Subtract each number in the array from this sum to get the missing number.

4. Find the Longest Common Prefix in a Set of Strings
Problem Statement:
Write a function to find the longest common prefix among an array of strings.
Example:
Input: ["flower", "flow", "flight"]
Output: "fl"
Solution: */

 class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}

/* Explanation:
Start with the first string as the prefix.
Iterate over other strings and keep shortening the prefix until it matches all words.



/* 1. Find the First Non-Repeating Character in a String
Problem Statement:
Given a string s, find the first non-repeating character and return its index. If it doesn’t exist, return -1.
Example:
Input: "leetcode"
Output: 0 (The first non-repeating character is 'l' at index 0).
Solution:  */




//2. Check if a String is a Palindrome
//Problem Statement:
//Given a string s, return true if it is a palindrome, ignoring case and non-alphanumeric characters.
//Example:
//Input: "A man, a plan, a canal: Panama"
//Output: true
//Solution:
class PalindromeChecker {
    public boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}


//3. Implement Binary Search
//Problem Statement:
//Given a sorted array of integers and a target value, return the index of the target if found. Otherwise, return -1.
//Example:
//Input: nums = [-1, 0, 3, 5, 9, 12], target = 9
//Output: 4
//Solution:

class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}


//4. Remove Duplicates from a Sorted Array
//Problem Statement:
//Given a sorted array nums, remove the duplicates in-place such that each unique element appears only once.
//        Example:
//Input: nums = [1, 1, 2]
//Output: [1, 2]
//Solution:

class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}


//5. Find the Majority Element
//Problem Statement:
//Given an array nums, return the majority element (an element that appears more than n/2 times).
//Example:
//Input: nums = [3, 2, 3]
//Output: 3
//Solution:

class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) return num;
        }
        return -1;
    }
}


//6. Reverse an Integer
//Problem Statement:
//Given a signed 32-bit integer x, return its reversed digits. If reversing causes overflow, return 0.
//Example:
//Input: x = 123
//Output: 321
//Solution:

class ReverseInteger {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) return 0;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}


/* 8. Check if an Array is Sorted and Rotated
Problem Statement:
Given an array nums, check if it was originally sorted in non-decreasing order but then rotated.
        Example:
Input: nums = [3, 4, 5, 1, 2]
Output: true
Solution: */

class CheckRotatedSorted {
    public boolean check(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) count++;
            if (count > 1) return false;
        }
        return true;
    }
}


//9. Find the Intersection of Two Arrays
//Problem Statement:
//Given two integer arrays nums1 and nums2, return their intersection (common elements).
//Example:
//Input: nums1 = [1, 2, 2, 1], nums2 = [2, 2]
//Output: [2]
//Solution:

class IntersectionArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int num : nums1) set.add(num);
        for (int num : nums2) if (set.contains(num)) result.add(num);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}






/*         1. Find the Second Largest Number in an Array
Problem Statement:
Given an array of integers, return the second largest number.
Example:
Input: [10, 5, 8, 20, 15]
Output: 15
Solution: */

class SecondLargest {
    public int secondLargest(int[] nums) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num < first) {
                second = num;
            }
        }
        return second == Integer.MIN_VALUE ? -1 : second;
    }
}


/* 2. Merge Two Sorted Arrays Without Extra Space
Problem Statement:
Given two sorted arrays, merge them into one sorted array without using extra space.
        Example:
Input:
nums1 = [1, 3, 5, 7]
nums2 = [2, 4, 6, 8]

Output: [1, 2, 3, 4, 5, 6, 7, 8]
Solution: */

class MergeSortedArrays {
    public void merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}


/* 3. Find All Duplicates in an Array
Problem Statement:
Given an array of integers, return all duplicate numbers.
        Example:
Input: [4, 3, 2, 7, 8, 2, 3, 1]
Output: [2, 3]
Solution:
         */

class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int num : nums) {
            if (!set.add(num)) {
                duplicates.add(num);
            }
        }
        return duplicates;
    }
}


/* 4. Find the Maximum Subarray Sum (Kadane’s Algorithm)
Problem Statement:
Given an integer array, find the contiguous subarray with the largest sum.
        Example:
Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
Output: 6 (Subarray [4, -1, 2, 1])
Solution: */

class MaxSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}


/*
5. Check if Two Strings are Anagrams
Problem Statement:
Given two strings, return true if they are anagrams.
        Example:
Input: s = "listen", t = "silent"
Output: true
Solution:
*/

class AnagramCheck {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}


/* 6. Reverse a Linked List
Problem Statement:
Given a singly linked list, reverse it and return the new head.
        Example:
Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
Output: 5 -> 4 -> 3 -> 2 -> 1 -> null
Solution: */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}


/* 7. Find the Middle Node of a Linked List
Problem Statement:
Given a linked list, find the middle node.
        Example:
Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
Output: 3 -> 4 -> 5 -> null
Solution: */

class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}


//8. Find the Kth Largest Element in an Array
//Problem Statement:
//Given an array nums and an integer k, return the kth largest element.
//Example:
//Input: nums = [3, 2, 1, 5, 6, 4], k = 2
//Output: 5
//Solution:

class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}


//9. Implement a Queue Using Two Stacks
//Problem Statement:
//Implement a queue using two stacks.
//Solution:

class MyQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}


/* 10. Detect a Cycle in a Linked List
Problem Statement:
Given a linked list, return true if there is a cycle, otherwise false.
Solution: */
class DetectCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}


/*         1. Print the First N Fibonacci Numbers
📌 (Basic Iteration & Recursion)
        🔹 Problem:
Write a function that prints the first N Fibonacci numbers.
        🔹 Example:
Input: N = 6
Output: 0, 1, 1, 2, 3, 5
        🔹 Iterative Solution: */


//🔹 Recursive Solution:
class FibonacciSeriesRecursive {
    public static void printFibonacci(int n, int a, int b) {
        if (n == 0) return;
        System.out.print(a + " ");
        printFibonacci(n - 1, b, a + b);
    }

    public static void main(String[] args) {
        printFibonacci(6, 0, 1);
    }
}


/* 2. Find the Nth Fibonacci Number
📌 (Standard Interview Question)
        🔹 Problem:
Find the Nth Fibonacci number using recursion and iteration.
🔹 Example:
Input: N = 6
Output: 8
        🔹 Iterative Solution: */


//🔹 Recursive Solution:
class FibonacciNthRecursive {
    public static int findNthFib(int n) {
        if (n <= 1) return n;
        return findNthFib(n - 1) + findNthFib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(findNthFib(6));
    }
}


/* 3. Check if a Number is a Fibonacci Number
📌 (Advanced Fibonacci Question)
        🔹 Problem:
Given a number X, check if it is a Fibonacci number.
🔹 Example:
Input: X = 8
Output: true
        🔹 Iterative Solution: */
class FibonacciCheck {
    public static boolean isFibonacci(int x) {
        int a = 0, b = 1;
        while (b < x) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b == x || a == x;
    }

    public static void main(String[] args) {
        System.out.println(isFibonacci(8));  // true
        System.out.println(isFibonacci(10)); // false
    }
}

//🔹 Recursive Solution:
class FibonacciCheckRecursive {
    public static boolean isFibonacci(int x, int a, int b) {
        if (b == x || a == x) return true;
        if (b > x) return false;
        return isFibonacci(x, b, a + b);
    }

    public static void main(String[] args) {
        System.out.println(isFibonacci(8, 0, 1));  // true
        System.out.println(isFibonacci(10, 0, 1)); // false
    }
}


/* 4. Sum of First N Fibonacci Numbers
📌 (Mathematical Approach)
        🔹 Problem:
Find the sum of the first N Fibonacci numbers.
🔹 Example:
Input: N = 6
Output: 0 + 1 + 1 + 2 + 3 + 5 = 12
        🔹 Iterative Solution: */


//🔹 Recursiveive Solution:
class FibonacciSumRecursive {
    public static int sumFibonacci(int n) {
        if (n <= 0) return 0;
        return findNthFib(n) + sumFibonacci(n - 1);
    }

    public static int findNthFib(int n) {
        if (n <= 1) return n;
        return findNthFib(n - 1) + findNthFib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(sumFibonacci(6)); // 12
    }
}


/* 5. Count Fibonacci Numbers in a Given Range
📌 (Variation of Fibonacci Problem)
        🔹 Problem:
Given a range [low, high], count how many Fibonacci numbers exist in that range.
🔹 Example:
Input: low = 5, high = 20
Output: 5, 8, 13 → Count = 3
        🔹 Iterative Solution: */
class FibonacciRangeRecursive {
    public static int countFibonacciInRange(int low, int high, int a, int b, int count) {
        if (b > high) return count;
        if (b >= low) count++;
        return countFibonacciInRange(low, high, b, a + b, count);
    }

    public static void main(String[] args) {
        System.out.println(countFibonacciInRange(5, 20, 0, 1, 0)); // 3
    }
}



////1. What are the key features of Java?
//        📌 Answer:
//Java is a high-level, object-oriented, platform-independent programming language. Its key features include:
//Platform Independence: Runs on any OS using the Java Virtual Machine (JVM).
//Object-Oriented: Everything is based on objects and classes.
//Automatic Memory Management (Garbage Collection): Java automatically manages memory using the Garbage Collector.
//Multi-threading: Supports multiple threads of execution for better performance.
//Security: Java provides runtime checks and security policies using the Security Manager.
//        Robustness: Strong memory management, exception handling, and type checking make Java reliable.

////2. What is the difference between JDK, JRE, and JVM?
//        📌 Answer:
//Component
//        Description
//JVM (Java Virtual Machine)
//Executes Java bytecode. It is platform-dependent.
//JRE (Java Runtime Environment)
//Contains JVM + essential libraries to run Java applications.
//JDK (Java Development Kit)
//JRE + development tools (compiler, debugger, etc.). Required for writing and compiling Java programs.

//👉 Example: You need the JDK to develop and compile Java programs, but only the JRE to run them.

////3. What is the difference between == and .equals() in Java?
//        📌 Answer:
//        == compares memory addresses (references).
//        .equals() compares the actual values inside the objects.
//        👉 Example:
//String s1 = new String("Hello");
//String s2 = new String("Hello");
//System.out.println(s1 == s2);
//System.out.println(s1.equals(s2));

//Use == for primitive types and .equals() for object comparison.
//
////4. What is the difference between final, finally, and finalize?
//        📌 Answer:
//Keyword
//        Meaning
//final
//Used with variables (constant values), methods (cannot be overridden), and classes (cannot be inherited).
//        finally
//A block in exception handling that always executes, regardless of whether an exception occurs.
//finalize()
//A method called by the Garbage Collector before an object is removed from memory.
//
//        👉 Example:
//final int x = 10;   // Cannot be changed
//try { /* code */ } finally { System.out.println("Always executes"); }
//@Override
//protected void finalize() { System.out.println("Garbage collected"); }
//
//
////5. What is method overloading and method overriding?
//        📌 Answer:
//Method Overloading: Same method name but different parameters (compile-time polymorphism).
//Method Overriding: A subclass provides a different implementation of a parent class method (runtime polymorphism).
//        👉 Example:
//// Method Overloading
class MathUtils {
    int add(int a, int b) { return a + b; }
    int add(int a, int b, int c) { return a + b + c; }
}
//
//// Method Overriding
class Animal {
    void makeSound() { System.out.println("Animal sound"); }
}
class Dog extends Animal {
    @Override
    void makeSound() { System.out.println("Bark!"); }
}
//
//
////6. What are the differences between an interface and an abstract class?
//        📌 Answer:
//Feature
//        Interface
//Abstract Class
//Methods
//Only abstract methods (before Java 8)
//Can have both abstract and concrete methods
//        Fields
//Only public static final constants
//Can have instance variables
//Multiple Inheritance
//Supported
//Not supported
//Constructors
//Not allowed
//Allowed
//
//👉 Example:
interface Animals {
    void makeSound();  // Abstract method
}
abstract class Bird {
    abstract void fly();
    void eat() { System.out.println("Eating..."); }
}

//🔹 Use interfaces for multiple inheritance and abstract classes when you need shared code.
//
////7. What is the difference between checked and unchecked exceptions?
//        📌 Answer:
//Type
//        Description
//Example
//Checked Exceptions
//Checked at compile-time. Must be handled with try-catch or throws.
//IOException, SQLException
//Unchecked Exceptions
//Occur at runtime and do not require handling.
//        NullPointerException, ArithmeticException
//
//👉 Example:
//// Checked Exception
//try {
//    FileReader file = new FileReader("file.txt"); // IOException
//} catch (
//    IOException e) {
//e.printStackTrace();
//}
//
//// Unchecked Exception
//int x = 5 / 0; // ArithmeticException
//
//
////8. What is the difference between a deep copy and a shallow copy?
//        📌 Answer:
//Shallow Copy: Copies object references (changes reflect in both objects).
//Deep Copy: Copies the entire object with a new memory allocation.
//        👉 Example:
class Person implements Cloneable {
    String name;
    Person(String name) { this.name = name; }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  // Shallow Copy
    }
}
//
//🔹 Use deep copy for immutable objects or when independent objects are needed.
//
//The four main principles of Object-Oriented Programming (OOP) are:
////        1. Encapsulation
//Definition: The concept of hiding the internal state of an object and providing a way to access and modify that state through methods (also called getters and setters).
//Purpose: Encapsulation ensures that an object's data is protected and only accessible through well-defined interfaces, preventing unintended modifications and enhancing maintainability.
//Example:
class Persons {
    private String name; // private field, encapsulated

    // Getter method
    public String getName() {
        return name;
    }

    // Setter method
    public void setName(String name) {
        this.name = name;
    }
}
//
class Test {
    public static void main(String[] args) {
        Persons person = new Persons();
        person.setName("John");  // Using setter to modify name
        System.out.println(person.getName());  // Using getter to access name
    }
}
//
//
////2. Abstraction
//Definition: The principle of simplifying complex systems by hiding the unnecessary implementation details and exposing only the essential features or functionality.
//Purpose: Abstraction helps in focusing on high-level functionality while hiding complex details that are irrelevant to the user.
//        Example:
abstract class Animalz {
    // Abstract method (does not have a body)
    public abstract void sound();
}

class Dogs extends Animalz {
    @Override
    public void sound() {
        System.out.println("Bark");
    }
}

class Testz {
    public static void main(String[] args) {
        Animalz animal = new Dogs();
        animal.sound();  // Outputs: Bark
    }
}
//
//
//Explanation: In this example, Animal is an abstract class with an abstract method sound(). The Dog class provides its own implementation for this method.
////3. Inheritance
//Definition: The mechanism that allows one class to inherit the properties and behavior (fields and methods) of another class. It facilitates code reusability and establishes a relationship between parent (superclass) and child (subclass) classes.
//        Purpose: Inheritance allows the creation of a new class based on an existing class, promoting code reuse and reducing redundancy.
//Example:
class Animalss {
    public void eat() {
        System.out.println("Eating...");
    }
}

class Dogss extends Animalss { // Dog inherits from Animal
    public void bark() {
        System.out.println("Barking...");
    }
}
//
class Testss {
    public static void main(String[] args) {
        Dogss dog = new Dogss();
        dog.eat();   // Inherited method from Animal
        dog.bark();  // Dog-specific method
    }
}



//Explanation: The Dog class inherits from the Animal class, so it can call the eat() method, which is inherited from Animal.
////        4. Polymorphism
//Definition: The ability for different objects to respond to the same message (method call) in different ways. There are two types of polymorphism:
//
//
//Compile-time (Static) Polymorphism: Achieved by method overloading or operator overloading.
//Runtime (Dynamic) Polymorphism: Achieved by method overriding.
//Purpose: Polymorphism allows one interface to be used for a general class of actions, making the code more flexible and extensible.
//
//
//Example of Runtime Polymorphism (Method Overriding):
class Anima {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Do extends Anima {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}
//
class Cat extends Anima {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
}

//public class Tests {
//    public static void main(String[] args) {
//        Anima animal1 = new Dog();  // Animal reference, Dog object
//        animal1.sound();  // Outputs: Dog barks

//        Anima animal2 = new Cat();  // Animal reference, Cat object
//        animal2.sound();  // Outputs: Cat meows
//    }
//}

//Explanation: Here, the sound() method is overridden in both the Dog and Cat subclasses. When we use the Animal reference, Java determines the appropriate method to call at runtime, based on the actual object type (Dog or Cat).
//
//Summary of OOP Principles:
////Encapsulation: Protects the object's state by keeping it private and exposing only necessary methods.
////Abstraction: Hides unnecessary implementation details and exposes only the essential features.
////Inheritance: Promotes code reusability by allowing one class to inherit properties and behaviors from another class.
////Polymorphism: Allows one interface to represent different actions, making the code more flexible and extensible.
////These principles form the foundation of OOP and are used together to create well-organized, maintainable, and reusable code in Java.
//
////9. What is the difference between HashMap and HashSet?
//        📌 Answer:
//Feature
//        HashMap
//HashSet
//Data Storage
//Key-Value pairs
//Only unique values
//        Duplicates
//Keys must be unique, values can be duplicated
//No duplicates allowed
//        Performance
//O(1) for get/put
//O(1) for add/remove
//
//👉 Example:
//Map<String, Integer> map = new HashMap<>();
//map.put("A", 1);
//map.put("B", 2);
//
//Set<Integer> set = new HashSet<>();
//set.add(10);
//set.add(20);
//
//🔹 Use HashMap when you need key-value storage; HashSet for unique collections.
//
////        10. What is a Singleton Class in Java?
//        📌 Answer:
//A Singleton class ensures that only one instance of a class exists in the JVM.
//        👉 Example (Lazy Initialization Singleton):
//class Singleton {
//    private static Singleton instance;
//
//    private Singleton() {}  // Private Constructor
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
//}
//
//🔹 Use Singletons for shared resources like database connections.
//
//        Final Thoughts
//Question
//        Difficulty
//Key Concept
//Features of Java
//        Easy
//Java basics
//JDK vs JRE vs JVM
//        Easy
//Java execution model
//== vs .equals()
//Medium
//Object comparison
//final, finally, finalize
//        Medium
//Keywords
//Overloading vs Overriding
//        Medium
//Polymorphism
//Interface vs Abstract Class
//Hard
//        Inheritance
//Checked vs Unchecked Exceptions
//Medium
//Exception handling
//Shallow vs Deep Copy
//Hard
//Object cloning
//HashMap vs HashSet
//        Medium
//Collections
//Singleton Pattern
//Hard
//Design pattern

////        1. What is Polymorphism in Java? Explain with examples.
//📌 Answer:
//Polymorphism in Java is the ability of an object to take many forms. It allows one interface to be used for different data types or methods. There are two types of polymorphism:
//Compile-time Polymorphism (Method Overloading): Achieved by method overloading (same method name, different parameters).
//Runtime Polymorphism (Method Overriding): Achieved by method overriding (same method signature in a subclass).
//        👉 Example (Compile-time Polymorphism):
class Calculator {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}
//
//👉 Example (Runtime Polymorphism):
class Animald {
    void sound() { System.out.println("Animal sound"); }
}
class Dogg extends Animald {
    @Override
    void sound() { System.out.println("Bark"); }
}

class Tes {
    public static void main(String[] args) {
        Animald myDog = new Dogg();
        myDog.sound();  // Output: Bark
    }
}


////2. What is the use of super keyword in Java?
//        📌 Answer:
//The super keyword in Java is used to:
//Access Parent Class Constructor: It can invoke the parent class's constructor.
//Access Parent Class Methods: It can call methods of the parent class that are overridden in the subclass.
//Access Parent Class Variables: It is used to access parent class fields when there is a naming conflict with subclass fields.
//        👉 Example:
class Animall {
    void makeSound() { System.out.println("Animal sound"); }
}

class Doggs extends Animall {
    void makeSound() {
        super.makeSound();  // Calling parent class method
        System.out.println("Bark!");
    }
}

class Testt {
    public static void main(String[] args) {
        Doggs dog = new Doggs();
        dog.makeSound();
    }
}
//
//Output:
//Animal sound
//Bark!
//
//
////        3. What is the significance of the this keyword in Java?
//        📌 Answer:
//The this keyword in Java refers to the current instance of the class. It is used to:
//Refer to instance variables or methods of the current object.
//Differentiate between instance variables and parameters with the same name.
//Invoke current class constructor.
//        👉 Example:
class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;  // 'this' refers to instance variable
        this.age = age;
    }
}
//
class Testzz {
    public static void main(String[] args) {
        Student student = new Student("John", 21);
        System.out.println(student.name + " is " + student.age + " years old.");
    }
}
//
//Output:
//John is 21 years old.
//
//
////        4. What is the difference between ArrayList and LinkedList in Java?
//        📌 Answer:
//Feature
//        ArrayList
//LinkedList
//Data Structure
//Uses a dynamic array
//Uses a doubly-linked list
//Access Time
//O(1) for random access (index-based)
//O(n) for accessing an element by index
//Insertion/Deletion
//O(n) for insertion/deletion (middle)
//O(1) for insertion/deletion (at beginning or end)
//Performance
//Faster for iteration
//Better for frequent insertions and deletions
//
//👉 Example:
//
//
class run {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Adding elements
        arrayList.add(1);
        linkedList.add(1);

        // Performance test (e.g., for large lists)
    }
}
//
//
////5. What is the concept of Encapsulation in Java?
//        📌 Answer:
//Encapsulation is the OOP principle of bundling data (variables) and methods that operate on the data within a single unit (class). It also restricts direct access to some of the object’s components by using access modifiers like private, protected, or public, and provides getter and setter methods to access private variables.
//👉 Benefits of Encapsulation:
//Control over data: You can control how data is accessed or modified.
//Improved maintainability: Changes can be made to the internal workings of a class without affecting other classes.
//Enhanced security: Sensitive data can be hidden from outside access.
//        👉 Example:
class Perso {
    private String name; // private variable

    public String getName() { return name; }  // Getter
    public void setName(String name) { this.name = name; }  // Setter
}

class Testing {
    public static void main(String[] args) {
        Perso person = new Perso();
        person.setName("John");
        System.out.println(person.getName());
    }
}
//
//Output:
//John

//These concepts delve deeper into Object-Oriented Programming in Java, emphasizing polymorphism, inheritance, encapsulation, and abstraction, which are fundamental principles of OOP. Let me know if you'd like more elaboration or examples!

//        ## **Non-Technical Questions (10 Questions)**

////        ### **1. Tell me about yourself.**
//        **Answer:**
//        - Focus on your education, relevant projects, and internships.
//        - Highlight your passion for Java development and problem-solving.
//- Example: "I recently graduated with a degree in Computer Science, where I focused on Java programming. I’ve worked on projects like a library management system and a chat application, which helped me strengthen my skills in Java, Spring Boot, and database management."

////        ### **2. Why do you want to work here?**
//        **Answer:**
//        - Research the company and mention specific projects or values that align with your interests.
//        - Example: "I admire your company’s commitment to innovation and its use of cutting-edge technologies. I’m excited about the opportunity to contribute to your team and grow as a Java developer."

////        ### **3. How do you handle tight deadlines?**
//        **Answer:**
//        - Emphasize prioritization, time management, and communication.
//        - Example: "I break tasks into smaller, manageable parts and prioritize them based on urgency and importance. I also communicate proactively with my team to ensure we meet deadlines without compromising quality."
////        ### **4. Describe a challenging project and how you overcame it.**
//        **Answer:**
//        - Choose a technical project and explain the problem, your approach, and the outcome.
//- Example: "During my final year project, I faced performance issues with my Java application. I profiled the code, identified bottlenecks, and optimized the database queries, which improved the application’s response time by 40%."
//
////        ### **5. What is your greatest strength?**
//        **Answer:**
//        - Highlight a technical or soft skill relevant to the job.
//        - Example: "My greatest strength is my problem-solving ability. I enjoy tackling complex challenges and finding efficient solutions, which I’ve demonstrated through my projects and coding competitions."
//

////        ### **6. What is your greatest weakness?**
//        **Answer:**
//        - Be honest but frame it positively.
//        - Example: "I tend to be a perfectionist, which sometimes slows me down. However, I’ve learned to balance quality with efficiency by setting clear goals and deadlines."
//
////        ### **7. How do you stay updated with new technologies?**
//        **Answer:**
//        - Mention blogs, online courses, and communities.
//        - Example: "I regularly follow Java blogs like Baeldung and DZone. I also take online courses on platforms like Coursera and participate in coding challenges on LeetCode and HackerRank."
//
////        ### **8. Describe a time you worked in a team.**
//        **Answer:**
//        - Highlight collaboration and communication.
//        - Example: "In my internship, I worked with a team of five developers to build a web application. I was responsible for the backend logic, and we used Agile methodologies to ensure smooth collaboration and timely delivery."
//
////        ### **9. Where do you see yourself in 5 years?**
//        **Answer:**
//        - Show ambition and alignment with the company.
//- Example: "In five years, I see myself as a senior Java developer, leading projects and mentoring junior developers. I hope to contribute significantly to your company’s growth and innovation."
//
////        ### **10. Do you have any questions for us?**
//        **Answer:**
//        - Ask thoughtful questions about the role, team, or company.
//          - Example: "Can you tell me more about the team I’ll be working with? What are the biggest challenges the team is currently facing?"


////        1. What is the difference between == and .equals() in Java?
//        📌 Answer:
//        == checks reference equality (whether two references point to the same object in memory).
//        .equals() checks content equality (whether two objects have the same content). It is usually overridden in a class to compare objects based on their values.
//        👉 Example:
//String s1 = new String("Hello");
//String s2 = new String("Hello");
//
//System.out.println(s1 == s2);        // false (different objects)
//System.out.println(s1.equals(s2));   // true (same content)
//
//
////        2. What are access modifiers in Java?
//        📌 Answer:
//Java has four types of access modifiers that control the visibility of classes, methods, and variables:
//public: Accessible from any class.
//private: Accessible only within the same class.
//protected: Accessible within the same package and by subclasses.
//default (no modifier): Accessible only within the same package.
//        👉 Example:
class MyClass {
    public int publicVar;
    private int privateVar;
    protected int protectedVar;
    int defaultVar;  // default (no modifier)

    public void printVars() {
        System.out.println(publicVar);
        System.out.println(privateVar);
        System.out.println(protectedVar);
        System.out.println(defaultVar);
    }
}

////3. What is the difference between ArrayList and Vector in Java?
//        📌 Answer:
//ArrayList is not synchronized, making it faster but not thread-safe.
//Vector is synchronized, making it thread-safe but slower due to the synchronization overhead.
//        👉 Example:
//ArrayList<Integer> list = new ArrayList<>();
//list.add(1); // No synchronization overhead
//
//Vector<Integer> vector = new Vector<>();
//vector.add(1); // Synchronization overhead present
//
//
////4. Explain the concept of final in Java.
//        📌 Answer:
//The final keyword in Java is used to restrict the user:
//Final variable: The value of the variable cannot be changed once initialized.
//Final method: The method cannot be overridden by subclasses.
//        Final class: The class cannot be subclassed.
//        👉 Example:
//final int x = 10;  // x cannot be reassigned
//final class MyClass {}  // This class cannot be subclassed
//
//
////5. What is a Constructor in Java?
//        📌 Answer:
//A constructor is a special method that is used to initialize objects. It is called when an object of the class is created. Constructors have the same name as the class and do not have a return type.
//Default constructor: Provided automatically if no constructor is defined by the programmer.
//Parameterized constructor: A constructor with parameters used to initialize an object with specific values.
//        👉 Example:
class MyClasss {
    int x;

    // Constructor
    MyClasss(int y) {
        x = y;
    }

    void display() {
        System.out.println("Value of x: " + x);
    }
}

class Testings {
    public static void main(String[] args) {
        MyClasss obj = new MyClasss(5);  // Parameterized constructor
        obj.display();
    }
}

////6. What is an Interface in Java and how is it different from an Abstract Class?
//        📌 Answer:
//Interface: Defines a contract that a class can implement. It can only contain abstract methods (until Java 8, which allows default and static methods).
//Abstract Class: A class that cannot be instantiated and may contain both abstract methods and concrete methods (methods with a body).
//        👉 Key Differences:
//A class can implement multiple interfaces but can inherit only one abstract class.
//Interfaces are used to represent a contract, while abstract classes are used for shared code.
//        👉 Example:
//interface Animal {
//    void sound();
//}
//
//class Dog implements Animal {
//    public void sound() {
//        System.out.println("Bark");
//    }
//}
//
//
////7. What are the main differences between String, StringBuilder, and StringBuffer in Java?
//        📌 Answer:
//String: Immutable. Every time you modify a string, a new string object is created.
//StringBuilder: Mutable and not synchronized. It is faster when manipulating strings in single-threaded environments.
//StringBuffer: Mutable and synchronized. It is thread-safe but slower than StringBuilder.
//👉 Example:
//String str1 = "Hello";
//str1 = str1 + " World";  // Creates a new String
//
//StringBuilder sb = new StringBuilder("Hello");
//sb.append(" World");  // Modifies the existing StringBuilder
//
//StringBuffer sbf = new StringBuffer("Hello");
//sbf.append(" World");  // Modifies the existing StringBuffer
//
//
////8. What is the difference between throw and throws in Java?
//        📌 Answer:
//        throw: Used to explicitly throw an exception from a method or block of code.
//throws: Used in the method signature to declare that a method may throw exceptions, allowing the caller to handle them.
//        👉 Example:
//// Using throw
//public void checkAge(int age) {
//    if (age < 18) {
//        throw new IllegalArgumentException("Age must be 18 or older.");
//    }
//}
//
//// Using throws
//public void readFile() throws IOException {
//    FileReader fr = new FileReader("file.txt");
//}
//
//
////9. What is a HashMap in Java?
//        📌 Answer:
//HashMap is a Map implementation that stores key-value pairs. It allows null values and one null key. It does not guarantee the order of the elements.
//Key features:
//It is not synchronized, so it is not thread-safe.
//It uses a hashing mechanism for quick lookups.
//        👉 Example:
//        import java.util.*;
//
//public class Test {
//    public static void main(String[] args) {
//        HashMap<String, Integer> map = new HashMap<>();
//        map.put("A", 1);
//        map.put("B", 2);
//
//        System.out.println(map.get("A"));  // Output: 1
//    }
//}
//
//
////10. What is the purpose of the static keyword in Java?
//        📌 Answer:
//The static keyword is used to indicate that a particular member (variable or method) belongs to the class rather than an instance of the class. It can be accessed without creating an object of the class.
//Static variables: Shared by all instances of the class.
//Static methods: Can be called without an object and can access only static variables or methods.
//👉 Example:
//class MyClass {
//    static int counter = 0;  // Static variable
//
//    static void incrementCounter() {  // Static method
//        counter++;
//    }
//}
//
//public class Test {
//    public static void main(String[] args) {
//        MyClass.incrementCounter();
//        System.out.println(MyClass.counter);  // Output: 1
//    }
//}
//
//
//These questions cover a range of important concepts for a junior Java developer role, focusing on core Java fundamentals, OOP principles, and common collections. Would you like more details or examples on any of these topics?
//
//
//You can expand this into a full PDF document by adding more questions and solutions. Let me know if you need further assistance!
//
//
//Presentation Script
//Slide 1: Title Slide
//👋 "Good [morning/afternoon], everyone! My name is [Your Name], and today I’ll be presenting our Environmental Management System. This project focuses on helping users manage waste efficiently by providing categorized waste information, disposal guidelines, and recycling tips."
//
//Slide 2: Project Overview
//💡 "Our system provides users with structured waste management data through a RESTful API. Users can retrieve, create, update, and delete information about waste categories, disposal methods, and recycling tips."
//        🔹 Key Features:
//Organized waste categories
//Disposal guidelines and recycling tips
//CRUD operations via a REST API
//Robust exception handling
//
//Slide 3: Project Architecture
//🛠 "Our system is built using Spring Boot for backend development, with data persistence handled by Spring Data JPA and a database."
//        🔹 Main Components:
//Controllers (Handle API requests)
//Services (Business logic)
//Repositories (Database operations)
//Entities (Data models)
//Exception Handling (Manages errors)
//
//Slide 4: Core Features & API
//📌 "Let's take a look at how the API works."
//        ✅ Waste Categories API
//GET /api/waste-categories → Retrieve all categories
//POST /api/waste-categories → Create a category
//PUT /api/waste-categories/{id} → Update a category
//DELETE /api/waste-categories/{id} → Remove a category
//✅ Similar API endpoints exist for Disposal Guidelines and Recycling Tips.
//
//        Slide 5: Exception Handling
//⚠️ "One of the key aspects of our API is proper error handling. If a user tries to retrieve a non-existent category, the system throws a ResourceNotFoundException with a proper HTTP response."
//Example response for a missing record:
//        {
//        "timestamp": "2024-02-23T10:00:00Z",
//        "message": "Waste Category not found",
//        "status": 404
//        }
//
//
//Slide 6: Live Demo
//🚀 "Now, let's see the API in action!"
//Switch to Postman or Swagger UI for the demo. (See the demo guide below.)
//
//Slide 7: Future Improvements
//🔮 "Looking ahead, we plan to enhance the system by adding:"
//A frontend interface for easy user interaction
//AI-powered waste sorting recommendations
//Integration with municipal waste management systems
//
//Slide 8: Conclusion & Q&A
//🙌 "To summarize, our Environmental Management System provides structured waste management data via a RESTful API, enabling users to manage waste categories, disposal guidelines, and recycling tips effectively."
//        "Thank you for your time! I’d love to answer any questions."
//
//Demo Guide 🎬
//Step 1: Open Postman or Swagger UI
//Ensure your Spring Boot app is running (mvn spring-boot:run).
//Use http://localhost:8080/api/ as the base URL.
//Step 2: Retrieve All Waste Categories
//Request: GET /api/waste-categories
//Expected Response:
//        [
//        {
//        "id": 1,
//        "name": "Plastic",
//        "description": "Non-biodegradable waste"
//        },
//        {
//        "id": 2,
//        "name": "Organic Waste",
//        "description": "Biodegradable waste"
//        }
//        ]
//
//Step 3: Create a New Waste Category
//Request: POST /api/waste-categories
//Body:
//        {
//        "name": "Glass",
//        "description": "Recyclable material"
//        }
//
//Expected Response: HTTP 201 Created
//Step 4: Update a Category
//Request: PUT /api/waste-categories/1
//Body:
//        {
//        "name": "Plastic Waste",
//        "description": "Recyclable plastic materials"
//        }
//
//Expected Response: HTTP 200 OK
//Step 5: Delete a Category
//Request: DELETE /api/waste-categories/2
//Expected Response: HTTP 204 No Content
//Step 6: Error Handling Demonstration
//Try to retrieve a non-existent category: GET /api/waste-categories/999
//Expected Response: HTTP 404 Not Found
//
//Final Touches
//✅ Keep your demo quick and focused (5-7 minutes).
//        ✅ Have your Spring Boot application running before the presentation.
// ✅ Be prepared for questions about future improvements and potential integrations.
//



//📌 Technical Questions & Best Responses
////1. Tell us about yourself.
//Structure:
//Brief intro (education, experience, passion)
//Relevant skills (Java, API development, databases)
//Current projects (mention your Robot World API, gaming, or trading projects)
//Why you're excited about this role
//Example Response:
//        "I have a degree in Film and TV and am currently completing a diploma in Software Engineering at WeThinkCode_. My background combines storytelling with software development, and I’m passionate about creating innovative solutions, particularly in API development and backend systems. I recently worked on a Robot World API, where I developed endpoints for managing robots in a simulated world, ensuring efficient data handling and error management. I’m excited about this role at Enviro365 because it aligns with my interests in backend development and scalable applications, and I’d love to contribute my skills to the team."
//
////        2. Explain the project you’re presenting.
//Structure:
//Problem Statement: What issue does your project solve?
//Tech Stack: What tools did you use? (Java, Javalin, Gson, databases, etc.)
//Key Features: What functionality did you implement?
//Challenges & Solutions: Any major problems and how you solved them.
//Scalability: How could this be expanded?
//Example Response:
//        "The project I’m presenting is a Robot World API, designed to manage multiple robots in a simulated world with obstacles and objects. The system allows users to send commands to robots via HTTP requests, and it maintains a persistent world state using a database. I used Java with Javalin for the backend, Gson for JSON serialization, and a relational database for state management. One major challenge was handling concurrent robot interactions while maintaining world consistency, which I solved using synchronized state updates. If scaled, this could be expanded into a real-world IoT system for robotics simulations."
//
////        3. How do you handle errors in your API?
//Example Response:
//        "I use structured error handling with HTTP status codes and custom error messages. For example, if a user tries to move a robot to an occupied space, the API returns a 409 Conflict response. For unexpected errors, I implement global exception handling to log errors and return meaningful messages. This ensures that clients receive clear feedback and debugging is easier."
//
////        4. How do you optimize API performance?
//Example Response:
//        "I optimize API performance by implementing caching where needed, using pagination for large datasets, and reducing redundant database queries. For example, in the Robot World API, I optimized query execution by indexing frequently accessed fields and minimizing the number of database hits per request. Additionally, I use asynchronous processing for non-critical tasks to improve responsiveness."
//
///        5. How do you ensure database consistency in a multi-user environment?
//Example Response:
//        "I use ACID-compliant transactions to maintain data integrity, ensuring that concurrent requests don’t result in inconsistent states. In my Robot World API, I implemented optimistic locking to prevent conflicting updates, ensuring that users don’t overwrite each other’s changes."
//
//        📌 Behavioral & Soft Skill Questions
////6. How do you approach debugging a difficult problem?
//Example Response:
//        *"I follow a structured approach:
//Reproduce the issue to understand its scope.
//Check logs and error messages to identify patterns.
//Isolate the problem by testing different components.
//Use debugging tools like breakpoints and logging.
//Research similar issues in documentation or forums.
//        Try small, controlled fixes and validate the solution before deploying."*
//
////        7. Tell us about a time you worked in a team and faced a challenge.
//Example Response (STAR Method):
//Situation: While working on a team project at WeThinkCode, we had a major issue integrating our backend API with the frontend.
//        Task: My role was to ensure seamless API responses and data handling.
//        Action: I collaborated with the frontend team to understand their expected response formats and refactored our API to ensure compatibility.
//        Result: This improved efficiency, reduced integration bugs, and allowed us to meet our deadline successfully.
//
////        8. Why should we hire you?
//Example Response:
//        "I bring a combination of strong technical skills and adaptability. My experience with Java, API development, and database management aligns with this role. I’m also highly collaborative and thrive in agile teams. Beyond just coding, I focus on writing maintainable and scalable solutions. Given my passion for backend development and problem-solving, I’m confident I’d add value to your team."
//
////        9. Where do you see yourself in 5 years?
//Example Response:
//        "I see myself as a strong backend developer, specializing in scalable system design and API architecture. I’d like to grow into a role where I contribute to designing robust enterprise-level applications. I’m also interested in leadership opportunities, mentoring junior developers, and continuously learning new technologies."


/*
### **2.**
**"What is the company's approach to mentorship and team collaboration, particularly for new hires?"**

### **3.**
**"Can you share what success looks like for a graduate developer at Enviro 365 IT Solutions, and what factors contribute to career advancement?"**

### **4.**
**"After the completion of a contract role, what are the typical next steps for someone in my position? Is there a chance for permanent placement or other opportunities within the company?"**

"What is the company’s approach to feedback and performance reviews? How often do they occur?"
"How does the company approach work-life balance, especially for employees in development roles?" */

