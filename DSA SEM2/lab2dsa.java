import java.util.*;
// import java.lang.*;

public class lab2dsa {
    public static void main(String[] args) {
        Scanner r=new Scanner(System.in);
        int n=r.nextInt();
        String space=r.nextLine();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=r.nextInt();
        }
        // int[] arr={4, 5, 1, 3};
        System.out.println(game(arr, 0, arr.length-1));        
    }

    public static int game(int arr[], int start, int end) {
        if (start==end) {
            return arr[start];
        }
        if (start==end-1) {
            if (arr[start]>arr[end]) {
                return arr[start];
            }
            else{
                return arr[end];
            }
        }
        int c11= game(arr, start+2, end);
        int c12=game(arr, start+1, end-1);
        int s1= arr[start] + (c11<c12? c11: c12);

        int c22=game(arr, start, end-2);
        int s2=arr[end] + (c12<c22?c12: c22); 

        return s1>s2? s1:s2;
    }
        
    // public static int ayush(int n) {
    //     // System.out.println(n);
    //     int[] ans = new int[n + 1];
    //     ans[0] = 1;
    //     ans[1] = 1;
 
    //     for (int i = 2; i <= n; i++){
    //         ans[i] = ans[i - 1] + ans[i - 2];}

    //     return ans[n];
    // }
}
// class Reader {
//     final private int BUFFER_SIZE = 1 << 16;
//     private DataInputStream din;
//     private byte[] buffer;
//     private int bufferPointer, bytesRead;

//     public Reader()
//     {
//         din = new DataInputStream(System.in);
//         buffer = new byte[BUFFER_SIZE];
//         bufferPointer = bytesRead = 0;
//     }

//     public Reader(String file_name) throws IOException
//     {
//         din = new DataInputStream(
//                 new FileInputStream(file_name));
//         buffer = new byte[BUFFER_SIZE];
//         bufferPointer = bytesRead = 0;
//     }

//     public String readLine() throws IOException
//     {
//         byte[] buf = new byte[64]; // line length
//         int cnt = 0, c;
//         while ((c = read()) != -1) {
//             if (c == '\n') {
//                 if (cnt != 0) {
//                     break;
//                 }
//                 else {
//                     continue;
//                 }
//             }
//             buf[cnt++] = (byte)c;
//         }
//         return new String(buf, 0, cnt);
//     }

//     public int nextInt() throws IOException
//     {
//         int ret = 0;
//         byte c = read();
//         while (c <= ' ') {
//             c = read();
//         }
//         boolean neg = (c == '-');
//         if (neg)
//             c = read();
//         do {
//             ret = ret * 10 + c - '0';
//         } while ((c = read()) >= '0' && c <= '9');

//         if (neg)
//             return -ret;
//         return ret;
//     }

//     public long nextLong() throws IOException
//     {
//         long ret = 0;
//         byte c = read();
//         while (c <= ' ')
//             c = read();
//         boolean neg = (c == '-');
//         if (neg)
//             c = read();
//         do {
//             ret = ret * 10 + c - '0';
//         } while ((c = read()) >= '0' && c <= '9');
//         if (neg)
//             return -ret;
//         return ret;
//     }

//     public double nextDouble() throws IOException
//     {
//         double ret = 0, div = 1;
//         byte c = read();
//         while (c <= ' ')
//             c = read();
//         boolean neg = (c == '-');
//         if (neg)
//             c = read();

//         do {
//             ret = ret * 10 + c - '0';
//         } while ((c = read()) >= '0' && c <= '9');

//         if (c == '.') {
//             while ((c = read()) >= '0' && c <= '9') {
//                 ret += (c - '0') / (div *= 10);
//             }
//         }

//         if (neg)
//             return -ret;
//         return ret;
//     }

//     private void fillBuffer() throws IOException
//     {
//         bytesRead = din.read(buffer, bufferPointer = 0,
//                 BUFFER_SIZE);
//         if (bytesRead == -1)
//             buffer[0] = -1;
//     }

//     private byte read() throws IOException
//     {
//         if (bufferPointer == bytesRead)
//             fillBuffer();
//         return buffer[bufferPointer++];
//     }

//     public void close() throws IOException
//     {
//         if (din == null)
//             return;
//         din.close();
//     }
// }