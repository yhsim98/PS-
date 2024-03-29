import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner sc = new Scanner(System.in);

//        st = new StringTokenizer(br.readLine());
//        int t = Integer.parseInt(st.nextToken());

        Solve solve = new Solve();
        int t = 1;

        while(t > 0){
            solve.solve();
            t--;
        }
    }


}

class Solve {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    private int n;


    public void solve() throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());

        long[] a = new long[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            a[i] = Long.valueOf(st.nextToken());
        }

        Arrays.sort(a);

        //System.out.println(a.toString());
        long ans = 3000000001L;
        int ansL = 0, ansH = 0, ansM = 0;

        for(int i = 0; i < n; i++){
            int low = i != 0 ? 0 : 1;
            int high = i != n - 1 ? n - 1 : n - 2;

            while(low < high) {

                long sum = a[low] + a[high];
                //System.out.println(sum);
                if (ans >= Math.abs(sum + a[i])) {
                    ansL = low;
                    ansH = high;
                    ansM = i;
                    ans = Math.abs(sum + a[i]);
                }

                if(sum + a[i] < 0){
                    low++;
                    if(low == i) low++;

                } else if(sum + a[i] > 0){
                    high--;
                    if(high == i) high--;

                } else{
                    break;
                }
            }
        }

        long[] answer = new long[]{a[ansL], a[ansM], a[ansH]};
        Arrays.sort(answer);
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }


}