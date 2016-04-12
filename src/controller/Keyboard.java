package controller;

import model.MainSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;

/**
 * Created by mmishanin on 11.03.2016.
 */
public class Keyboard {
    BufferedReader inp = new BufferedReader(new InputStreamReader( System.in));

    public int getSum() throws IOException{
        return Integer.parseInt(inp.readLine());
    }

    public boolean getPass() throws IOException{
        int pass = Integer.parseInt(inp.readLine());
        return pass == 1234;
    }

    public int readCommand() throws IOException{
        return Integer.parseInt(inp.readLine());
    }
}
