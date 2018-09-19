import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {


        InputStream inputStream =  new BufferedInputStream( new FileInputStream( "tet"));

        //inputStream.read();

        int[] a = {1, 5, 9, 4, 3, 2, 6};

        int k = a.length;
        int i = 0;
        while ( i < k  ) {

            for (int n = k - 1 ; n > i; n --) {
                if ( a[n-1] > a[n]) {
                    int temp = a[n];
                    a[n] = a[n-1];
                    a[n-1] = temp;
                }
            }

            i++;
        }

        System.out.println(Arrays.toString(a));

    }
}
