// FILE: PalindromeCheckerApp.java
// Base application setup

import java.util.*;

// ============================================================
// UC1: Application Entry & Welcome Message
// Concepts: class, main method, static keyword, System.out.println
// ============================================================
class UseCase1PalindromeCheckerApp {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("  Welcome to Palindrome Checker App");
        System.out.println("  Version: 1.0");
        System.out.println("====================================");
        System.out.println("Application started successfully.");
    }
}
// ============================================================
// UC2: Print a Hardcoded Palindrome Result
// Concepts: String, String literal, if-else, console output
// Data Structure: String
// ============================================================
class UseCase2PalindromeCheckerApp {
    public static void main(String[] args) {
        String word = "madam";
        String reversed = new StringBuilder(word).reverse().toString();
        if (word.equals(reversed)) {
            System.out.println("\"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + word + "\" is NOT a Palindrome.");
        }
    }
}
// ============================================================
// UC3: Palindrome Check Using String Reverse (Manual Loop)
// Concepts: for loop, String immutability, concatenation, equals()
// Data Structure: String
// ============================================================
class UseCase3PalindromeCheckerApp {
    public static void main(String[] args) {
        String word = "racecar";
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }
        if (word.equals(reversed)) {
            System.out.println("\"" + word + "\" is a Palindrome. (String Reverse Method)");
        } else {
            System.out.println("\"" + word + "\" is NOT a Palindrome. (String Reverse Method)");
        }
    }
}
// ============================================================
// UC4: Character Array Based Palindrome Check
// Concepts: char[], array indexing, two-pointer technique
// Data Structure: char[]
// ============================================================
class UseCase4PalindromeCheckerApp {
    public static void main(String[] args) {
        String word = "level";
        char[] chars = word.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        boolean isPalindrome = true;
        while (left < right) {
            if (chars[left] != chars[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        if (isPalindrome) {
            System.out.println("\"" + word + "\" is a Palindrome. (Char Array / Two-Pointer)");
        } else {
            System.out.println("\"" + word + "\" is NOT a Palindrome. (Char Array / Two-Pointer)");
        }
    }
}
// ============================================================
// UC5: Stack-Based Palindrome Checker
// Concepts: Stack, push, pop, LIFO
// Data Structure: Stack
// ============================================================
class UseCase5PalindromeCheckerApp {
    public static void main(String[] args) {
        String word = "noon";
        Stack<Character> stack = new Stack<>();
        for (char c : word.toCharArray()) {
            stack.push(c);
        }
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }
        if (word.equals(reversed)) {
            System.out.println("\"" + word + "\" is a Palindrome. (Stack Method)");
        } else {
            System.out.println("\"" + word + "\" is NOT a Palindrome. (Stack Method)");
        }
    }
}
// ============================================================
// UC6: Queue + Stack Based Palindrome Check
// Concepts: Queue (FIFO), Stack (LIFO), enqueue, dequeue
// Data Structures: Queue, Stack
// ============================================================
class UseCase6PalindromeCheckerApp {
    public static void main(String[] args) {
        String word = "civic";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (char c : word.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }
        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            if (!queue.poll().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("\"" + word + "\" is a Palindrome. (Queue + Stack Method)");
        } else {
            System.out.println("\"" + word + "\" is NOT a Palindrome. (Queue + Stack Method)");
        }
    }
}
// ============================================================
// UC7: Deque-Based Optimized Palindrome Checker
// Concepts: Deque, front/rear access
// Data Structure: Deque
// ============================================================
class UseCase7PalindromeCheckerApp {
    public static void main(String[] args) {
        String word = "radar";
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : word.toCharArray()) {
            deque.addLast(c);
        }
        boolean isPalindrome = true;
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear  = deque.removeLast();
            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("\"" + word + "\" is a Palindrome. (Deque Method)");
        } else {
            System.out.println("\"" + word + "\" is NOT a Palindrome. (Deque Method)");
        }
    }
}
// ============================================================
// UC8: Linked List Based Palindrome Checker
// Concepts: Singly Linked List, fast/slow pointer, in-place reversal
// Data Structure: Singly Linked List
// ============================================================
class UseCase8PalindromeCheckerApp {
    static class Node {
        char data;
        Node next;
        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        String word = "madam";
        Node head = null, tail = null;
        for (char c : word.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null, curr = slow;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        Node left = head, right = prev;
        boolean isPalindrome = true;
        while (right != null) {
            if (left.data != right.data) {
                isPalindrome = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        if (isPalindrome) {
            System.out.println("\"" + word + "\" is a Palindrome. (Linked List Method)");
        } else {
            System.out.println("\"" + word + "\" is NOT a Palindrome. (Linked List Method)");
        }
    }
}
// ============================================================
// UC9: Recursive Palindrome Checker
// Concepts: Recursion, base condition, call stack
// Data Structure: Call Stack
// ============================================================
class UseCase9PalindromeCheckerApp {
    static boolean isPalindrome(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return isPalindrome(s, start + 1, end - 1);
    }
    public static void main(String[] args) {
        String word = "refer";
        boolean result = isPalindrome(word, 0, word.length() - 1);
        if (result) {
            System.out.println("\"" + word + "\" is a Palindrome. (Recursive Method)");
        } else {
            System.out.println("\"" + word + "\" is NOT a Palindrome. (Recursive Method)");
        }
    }
}
