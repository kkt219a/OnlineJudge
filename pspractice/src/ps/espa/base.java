package ps.espa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class base {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".inp"));
        PrintWriter pw = new PrintWriter(".out");
        while(true){
            String row = br.readLine();
            if(row==null) break;

        }
    }
}
