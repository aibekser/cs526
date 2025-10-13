package cs526.hw3.problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Problem3 {

 static class ArrayStack {
     private int[] a;
     private int n;

     ArrayStack(int cap) { a = new int[Math.max(1, cap)]; n = 0; }

     boolean isEmpty() { return n == 0; }
     int size() { return n; }

     void push(int x) {
         if (n == a.length) grow();
         a[n++] = x;
     }
     int pop() {
         if (isEmpty()) throw new RuntimeException("Underflow");
         return a[--n];
     }
     private void grow() {
         int[] b = new int[a.length * 2];
         System.arraycopy(a, 0, b, 0, a.length);
         a = b;
     }
     String toBottomTopString() {
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < n; i++) {
             if (i > 0) sb.append(", ");
             sb.append(a[i]);
         }
         return sb.toString();
     }
 }

 static void reverse(ArrayStack s) {
     if (s.isEmpty()) return;
     int x = s.pop();
     reverse(s);
     insertAtBottom(s, x);
 }
 static void insertAtBottom(ArrayStack s, int x) {
     if (s.isEmpty()) { s.push(x); return; }
     int t = s.pop();
     insertAtBottom(s, x);
     s.push(t);
 }

 static class SinglyStack {
     static class Node { int v; Node next; Node(int v){this.v=v;} }
     private Node top;
     private int n;

     boolean isEmpty(){ return top == null; }
     int size(){ return n; }

     void push(int x){ Node nd = new Node(x); nd.next = top; top = nd; n++; }
     int pop(){
         if (isEmpty()) throw new RuntimeException("Underflow");
         int v = top.v; top = top.next; n--; return v;
     }
     String toBottomTopString() {
         int[] buf = new int[n];
         int i = n - 1;
         for (Node cur = top; cur != null; cur = cur.next) buf[i--] = cur.v;
         StringBuilder sb = new StringBuilder();
         for (int k = 0; k < buf.length; k++) {
             if (k > 0) sb.append(", ");
             sb.append(buf[k]);
         }
         return sb.toString();
     }
 }

 static void reverse(SinglyStack s) {
     if (s.isEmpty()) return;
     int x = s.pop();
     reverse(s);
     insertAtBottom(s, x);
 }
 static void insertAtBottom(SinglyStack s, int x) {
     if (s.isEmpty()) { s.push(x); return; }
     int t = s.pop();
     insertAtBottom(s, x);
     s.push(t);
 }

 static class DoublyStack {
     static class Node { int v; Node prev, next; Node(int v){this.v=v;} }
     private Node top;
     private int n;

     boolean isEmpty(){ return top == null; }
     int size(){ return n; }

     void push(int x){
         Node nd = new Node(x);
         nd.next = top;
         if (top != null) top.prev = nd;
         top = nd; n++;
     }
     int pop(){
         if (isEmpty()) throw new RuntimeException("Underflow");
         int v = top.v;
         top = top.next;
         if (top != null) top.prev = null;
         n--; return v;
     }
     String toBottomTopString() {
         // Walk to bottom
         Node cur = top;
         if (cur == null) return "";
         while (cur.next != null) cur = cur.next;
         StringBuilder sb = new StringBuilder();
         while (cur != null) {
             if (sb.length() > 0) sb.append(", ");
             sb.append(cur.v);
             cur = cur.prev;
         }
         return sb.toString();
     }
 }

 static void reverse(DoublyStack s) {
     if (s.isEmpty()) return;
     int x = s.pop();
     reverse(s);
     insertAtBottom(s, x);
 }
 static void insertAtBottom(DoublyStack s, int x) {
     if (s.isEmpty()) { s.push(x); return; }
     int t = s.pop();
     insertAtBottom(s, x);
     s.push(t);
 }

 private static int[] readNumbers(String filename) throws IOException {
     try (BufferedReader br = Files.newBufferedReader(Paths.get(filename))) {
         String line = br.readLine();
         if (line == null) return new int[0];
         String[] parts = line.split(",");
         int[] nums = new int[parts.length];
         for (int i = 0; i < parts.length; i++) {
             nums[i] = Integer.parseInt(parts[i].trim());
         }
         return nums;
     }
 }

 public static void main(String[] args) {
     String filename = (args.length > 0) ? args[0] : "inputs/recursion2_2.txt";
     try {
         int[] nums = readNumbers(filename);

         ArrayStack a = new ArrayStack(nums.length);
         SinglyStack s = new SinglyStack();
         DoublyStack d = new DoublyStack();
         for (int x : nums) { a.push(x); s.push(x); d.push(x); }

         reverse(a);
         reverse(s);
         reverse(d);

         System.out.println(a.toBottomTopString());

     } catch (Exception e) {
         System.err.println("Error: " + e.getMessage());
         System.exit(1);
     }
 }
}
