package Domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by emmabaddeley on 16/04/2016.
 */
public class Console {

    private BufferedReader reader;

    public Console(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void printLine(String text){
        System.out.println(text);;
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }
}
