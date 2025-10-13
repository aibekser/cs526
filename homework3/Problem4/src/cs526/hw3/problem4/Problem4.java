package cs526.hw3.problem4;

import java.io.*;
import java.util.*;

public class Problem4 {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream in) { br = new BufferedReader(new InputStreamReader(in)); }
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
        long nextLong() throws IOException { return Long.parseLong(next()); }
    }

    public static void main(String[] args) throws Exception {
        String path = (args.length > 0) ? args[0] : "inputs/ghostbusters_input_3.txt";

        try (InputStream in = new FileInputStream(path)) {
            FastScanner fs = new FastScanner(in);

            String first = fs.next();
            if (first == null) {
                System.out.println("All Ghosts: were not eliminated");
                return;
            }
            int n = Integer.parseInt(first);

            long baseDx = 0, baseDy = 0;
            boolean allParallel = true;

            for (int i = 0; i < n; i++) {
                fs.next();
                long bx = fs.nextLong();
                long by = fs.nextLong();
                fs.next();
                long gx = fs.nextLong();
                long gy = fs.nextLong();

                long dx = gx - bx;
                long dy = gy - by;

                if (i == 0) {
                    baseDx = dx;
                    baseDy = dy;
                } else if (baseDx * dy != baseDy * dx) {
                    allParallel = false;
                }
            }

            System.out.println("All Ghosts: " + (allParallel ? "were eliminated" : "were not eliminated"));
        }
    }
}

