package cs526.hw3.problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Problem1 {

 private static boolean isPalindrome(String s) {
     int i = 0, j = s.length() - 1;
     while (i < j) {
         if (s.charAt(i) != s.charAt(j)) return false;
         i++; j--;
     }
     return true;
 }

 public static void main(String[] args) {
     String filename = (args.length > 0) ? args[0] : "inputs/palendrome_1.txt";
     int total = 0;

     try (BufferedReader br = Files.newBufferedReader(Paths.get(filename))) {
         String line;
         StringBuilder out = new StringBuilder();
         while ((line = br.readLine()) != null) {
             boolean ok = isPalindrome(line);
             if (ok) total++;
             out.append(ok ? "true" : "false").append('\n');
         }
         System.out.print(out.toString());
         System.out.println(total);
     } catch (IOException e) {
         System.err.println("Error reading file: " + e.getMessage());
         System.exit(1);
     }
 }
}
