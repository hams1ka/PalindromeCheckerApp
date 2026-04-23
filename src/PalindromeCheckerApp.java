//  FILE: PalindromeCheckerApp.java
//  All 13 Use Cases in ONE file 


import java.util.*;


// UC1: Application Entry & Welcome Message
// Concepts: class, main method, static keyword, System.out.println
 class UseCase1PalindromeCheckerApp {
    public static void main(String[] args) {
        // Display app name and version on startup
        System.out.println("====================================");
        System.out.println("  Welcome to Palindrome Checker App");
        System.out.println("  Version: 1.0");
        System.out.println("====================================");
        System.out.println("Application started successfully.");
    }
}

 // UC2: Print a Hardcoded Palindrome Result
// Concepts: String, String literal, if-else, console output
// Data Structure: String
class UseCase2PalindromeCheckerApp {
    public static void main(String[] args) {
        // Hardcoded string to check
        String word = "madam";

        // Reverse the string using StringBuilder
        String reversed = new StringBuilder(word).reverse().toString();

        // Check if original equals reversed
        if (word.equals(reversed)) {
            System.out.println("\"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + word + "\" is NOT a Palindrome.");
        }
    }
}

// UC3: Palindrome Check Using String Reverse (Manual Loop)
// Concepts: for loop, String immutability, concatenation, equals()
// Data Structure: String
class UseCase3PalindromeCheckerApp {
    public static void main(String[] args) {
        String word = "racecar";
        String reversed = ""; // Will build reversed string manually

        // Loop from last character to first and concatenate
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i); // String concatenation (creates new object each time)
        }

        // Compare original and reversed using equals() — not == (which checks reference)
        if (word.equals(reversed)) {
            System.out.println("\"" + word + "\" is a Palindrome. (String Reverse Method)");
        } else {
            System.out.println("\"" + word + "\" is NOT a Palindrome. (String Reverse Method)");
        }
    }
}

// UC4: Character Array Based Palindrome Check
// Concepts: char[], array indexing, two-pointer technique
// Data Structure: char[]
class UseCase4PalindromeCheckerApp {
    public static void main(String[] args) {
        String word = "level";

        // Convert string to character array
        char[] chars = word.toCharArray();

        // Two-pointer: one at start, one at end
        int left = 0;
        int right = chars.length - 1;
        boolean isPalindrome = true;

        while (left < right) {
            // If characters at left and right don't match → not a palindrome
            if (chars[left] != chars[right]) {
                isPalindrome = false;
                break;
            }
            left++;  // Move left pointer forward
            right--; // Move right pointer backward
        }

        if (isPalindrome) {
            System.out.println("\"" + word + "\" is a Palindrome. (Char Array / Two-Pointer)");
        } else {
            System.out.println("\"" + word + "\" is NOT a Palindrome. (Char Array / Two-Pointer)");
        }
    }
}

// UC5: Stack-Based Palindrome Checker
// Concepts: Stack, push, pop, LIFO
// Data Structure: Stack
class UseCase5PalindromeCheckerApp {
    public static void main(String[] args) {
        String word = "noon";

        // Stack follows LIFO — last pushed character comes out first (reversal)
        Stack<Character> stack = new Stack<>();

        // Push all characters onto the stack
        for (char c : word.toCharArray()) {
            stack.push(c);
        }

        // Pop characters and build reversed string
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop(); // Pop reverses the order
        }

        if (word.equals(reversed)) {
            System.out.println("\"" + word + "\" is a Palindrome. (Stack Method)");
        } else {
            System.out.println("\"" + word + "\" is NOT a Palindrome. (Stack Method)");
        }
    }
}

// UC6: Queue + Stack Based Palindrome Check
// Concepts: Queue (FIFO), Stack (LIFO), enqueue, dequeue, push, pop
// Data Structures: Queue, Stack
class UseCase6PalindromeCheckerApp {
    public static void main(String[] args) {
        String word = "civic";

        // Queue gives characters in original order (FIFO)
        Queue<Character> queue = new LinkedList<>();
        // Stack gives characters in reversed order (LIFO)
        Stack<Character> stack = new Stack<>();

        // Enqueue and push all characters
        for (char c : word.toCharArray()) {
            queue.add(c);   // Enqueue
            stack.push(c);  // Push
        }

        boolean isPalindrome = true;

        // Dequeue from queue (front = original order)
        // Pop from stack (top = reversed order)
        // If they always match → palindrome
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

// UC7: Deque-Based Optimized Palindrome Checker
// Concepts: Deque (Double Ended Queue), front/rear access
// Data Structure: Deque
class UseCase7PalindromeCheckerApp {
    public static void main(String[] args) {
        String word = "radar";

        // Deque allows access from both front and rear
        Deque<Character> deque = new ArrayDeque<>();

        // Add all characters to deque
        for (char c : word.toCharArray()) {
            deque.addLast(c); // Add to rear
        }

        boolean isPalindrome = true;

        // Remove from front and rear simultaneously and compare
        while (deque.size() > 1) {
            char front = deque.removeFirst(); // First character
            char rear  = deque.removeLast();  // Last character
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

// UC8: Linked List Based Palindrome Checker
// Concepts: Singly Linked List, fast/slow pointer, in-place reversal
// Data Structure: Singly Linked List
class UseCase8PalindromeCheckerApp {

    // Node class for singly linked list
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

        // Build linked list from string
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

        // Find middle using slow and fast pointers
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Moves 1 step
            fast = fast.next.next;  // Moves 2 steps → when fast reaches end, slow is at middle
        }

        // Reverse second half of linked list
        Node prev = null, curr = slow;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        // prev is now the head of the reversed second half

        // Compare first half and reversed second half
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

// UC9: Recursive Palindrome Checker
// Concepts: Recursion, base condition, call stack
// Data Structure: Call Stack
class UseCase9PalindromeCheckerApp {

    // Recursive method: compares characters at start and end positions
    static boolean isPalindrome(String s, int start, int end) {
        // Base condition: if pointers meet or cross → it's a palindrome
        if (start >= end) return true;

        // If characters don't match → not a palindrome
        if (s.charAt(start) != s.charAt(end)) return false;

        // Recursive call: move both pointers inward
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

// UC10: Case-Insensitive & Space-Ignored Palindrome
// Concepts: String preprocessing, regular expressions, toLowerCase()
// Data Structure: String / Array
class UseCase10PalindromeCheckerApp {
    public static void main(String[] args) {
        String word = "A man a plan a canal Panama";

        // Step 1: Normalize — remove all non-alphanumeric characters and convert to lowercase
        String normalized = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Step 2: Check palindrome using two-pointer on normalized string
        int left = 0, right = normalized.length() - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("Original : \"" + word + "\"");
        System.out.println("Normalized: \"" + normalized + "\"");
        if (isPalindrome) {
            System.out.println("Result: It IS a Palindrome. (Case-Insensitive & Space-Ignored)");
        } else {
            System.out.println("Result: It is NOT a Palindrome. (Case-Insensitive & Space-Ignored)");
        }
    }
}

// UC11: Object-Oriented Palindrome Service
// Concepts: Encapsulation, Single Responsibility Principle, OOP
// Data Structure: Internal (Stack / Array)
class UseCase11PalindromeCheckerApp {

    // PalindromeChecker class — encapsulates palindrome logic
    static class PalindromeChecker {
        private String word;

        // Constructor sets the word to check
        public PalindromeChecker(String word) {
            this.word = word;
        }

        // Public method exposes the palindrome check (hides internal logic)
        public boolean checkPalindrome() {
            Stack<Character> stack = new Stack<>();
            for (char c : word.toCharArray()) {
                stack.push(c); // Push each character
            }
            String reversed = "";
            while (!stack.isEmpty()) {
                reversed += stack.pop(); // Pop to reverse
            }
            return word.equals(reversed);
        }

        public String getWord() {
            return word;
        }
    }

    public static void main(String[] args) {
        // Create object of PalindromeChecker — OOP style
        PalindromeChecker checker = new PalindromeChecker("deified");

        if (checker.checkPalindrome()) {
            System.out.println("\"" + checker.getWord() + "\" is a Palindrome. (OOP Encapsulation)");
        } else {
            System.out.println("\"" + checker.getWord() + "\" is NOT a Palindrome. (OOP Encapsulation)");
        }
    }
}

// UC12: Strategy Pattern for Palindrome Algorithms
// Concepts: Interface, Polymorphism, Strategy Design Pattern
// Data Structure: Varies per strategy
class UseCase12PalindromeCheckerApp {

    // Strategy interface — defines the contract
    interface PalindromeStrategy {
        boolean check(String word);
    }

    // Strategy 1: Stack-based implementation
    static class StackStrategy implements PalindromeStrategy {
        @Override
        public boolean check(String word) {
            Stack<Character> stack = new Stack<>();
            for (char c : word.toCharArray()) stack.push(c);
            String reversed = "";
            while (!stack.isEmpty()) reversed += stack.pop();
            return word.equals(reversed);
        }
    }

    // Strategy 2: Deque-based implementation
    static class DequeStrategy implements PalindromeStrategy {
        @Override
        public boolean check(String word) {
            Deque<Character> deque = new ArrayDeque<>();
            for (char c : word.toCharArray()) deque.addLast(c);
            while (deque.size() > 1) {
                if (!deque.removeFirst().equals(deque.removeLast())) return false;
            }
            return true;
        }
    }

    // Context class — uses whichever strategy is injected
    static class PalindromeContext {
        private PalindromeStrategy strategy;

        // Strategy injected at runtime (dependency injection)
        public PalindromeContext(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean execute(String word) {
            return strategy.check(word); // Delegates to chosen strategy
        }
    }

    public static void main(String[] args) {
        String word = "rotator";

        // Use Stack Strategy
        PalindromeContext ctx1 = new PalindromeContext(new StackStrategy());
        System.out.println("[Stack Strategy]  \"" + word + "\" → " + (ctx1.execute(word) ? "Palindrome" : "Not Palindrome"));

        // Use Deque Strategy
        PalindromeContext ctx2 = new PalindromeContext(new DequeStrategy());
        System.out.println("[Deque Strategy]  \"" + word + "\" → " + (ctx2.execute(word) ? "Palindrome" : "Not Palindrome"));
    }
}

// UC13: Performance Comparison
// Concepts: System.nanoTime(), algorithm benchmarking
class UseCase13PalindromeCheckerApp {

    // Method 1: String reverse
    static boolean stringReverse(String word) {
        return word.equals(new StringBuilder(word).reverse().toString());
    }

    // Method 2: Char array two-pointer
    static boolean charArrayTwoPointer(String word) {
        char[] c = word.toCharArray();
        int l = 0, r = c.length - 1;
        while (l < r) { if (c[l++] != c[r--]) return false; }
        return true;
    }

    // Method 3: Stack-based
    static boolean stackMethod(String word) {
        Stack<Character> stack = new Stack<>();
        for (char ch : word.toCharArray()) stack.push(ch);
        String rev = "";
        while (!stack.isEmpty()) rev += stack.pop();
        return word.equals(rev);
    }

    // Method 4: Deque-based
    static boolean dequeMethod(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : word.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) { if (!deque.removeFirst().equals(deque.removeLast())) return false; }
        return true;
    }

    // Method 5: Recursive
    static boolean recursive(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return recursive(s, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String word = "amanaplanacanalpanama"; // Long palindrome for measurable timing

        System.out.println("Performance Comparison for: \"" + word + "\"");
        System.out.println("=".repeat(55));

        // Benchmark each method using System.nanoTime()
        long start, end;

        start = System.nanoTime();
        stringReverse(word);
        end = System.nanoTime();
        System.out.printf("%-30s : %d ns%n", "String Reverse (StringBuilder)", (end - start));

        start = System.nanoTime();
        charArrayTwoPointer(word);
        end = System.nanoTime();
        System.out.printf("%-30s : %d ns%n", "Char Array Two-Pointer", (end - start));

        start = System.nanoTime();
        stackMethod(word);
        end = System.nanoTime();
        System.out.printf("%-30s : %d ns%n", "Stack Method", (end - start));

        start = System.nanoTime();
        dequeMethod(word);
        end = System.nanoTime();
        System.out.printf("%-30s : %d ns%n", "Deque Method", (end - start));

        start = System.nanoTime();
        recursive(word, 0, word.length() - 1);
        end = System.nanoTime();
        System.out.printf("%-30s : %d ns%n", "Recursive Method", (end - start));

        System.out.println("=".repeat(55));
        System.out.println("Note: Lower ns = faster execution.");
    }
}