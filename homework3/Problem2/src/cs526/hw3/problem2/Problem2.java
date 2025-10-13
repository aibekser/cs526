package cs526.hw3.problem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.Set;

public class Problem2 {

 private static void collect(String s, int i, int j, Set<String> out) {
     int n = s.length();
     if (i == n) return;
     if (j > n) {
         collect(s, i + 1, i + 1, out);
         return;
     }
     if (j > i) out.add(s.substring(i, j));
     collect(s, i, j + 1, out);
 }

 private static Result uniqueSubstrings(String s) {
     Set<String> set = new LinkedHashSet<>();
     collect(s, 0, 0, set);
     return new Result(set);
 }

 private record Result(Set<String> set) { }

 public static void main(String[] args) {
     String filename = (args.length > 0) ? args[0] : "inputs/recursion_2.txt";
     try (BufferedReader br = Files.newBufferedReader(Paths.get(filename))) {
         String line;
         while ((line = br.readLine()) != null) {
             Result res = uniqueSubstrings(line);
             StringBuilder sb = new StringBuilder();
             boolean first = true;
             for (String sub : res.set) {
                 if (!first) sb.append(", ");
                 sb.append(sub);
                 first = false;
             }
             System.out.println(sb + " -> " + res.set.size());
         }
     } catch (IOException e) {
         System.err.println("Error: " + e.getMessage());
         System.exit(1);
     }
 }
}
