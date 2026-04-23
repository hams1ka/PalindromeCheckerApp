// FILE: PalindromeCheckerApp.java
// Base application setup

import java.util.*;

// Use cases will be added here 
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