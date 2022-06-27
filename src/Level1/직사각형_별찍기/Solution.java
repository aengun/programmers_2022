package Level1.직사각형_별찍기;

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < b; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < a; j++) {
                sb.append("*");
            }
            bw.write(sb.toString() + "\n");
            bw.flush();
        }
        bw.close();
        System.out.println(a + b);
    }
}