import java.io.*;
import java.util.*;

/**
 * @author master_j
 */
public class Solution {
    private IO io;
    private static final String _localArg = "master_j";
    private final String _problemName = "";
    private final int _inMode = IO.STD_;
    private final int _outMode = IO.STD_;
    private final boolean _autoFlush = false;

    private void solve() throws IOException {
    }//2.2250738585072012e-308

    private void init(boolean local) throws IOException {
        if (local)
            io = new IO(IO._PUT_TXT, IO.STD_);
        else {
            if ((_inMode == IO.PROBNAME_ || _outMode == IO.PROBNAME_) && _problemName.length() == 0)
                throw new IllegalStateException("You imbecile. Where's my <_problemName>?");
            io = new IO(_inMode, _outMode);
        }

        long nanoTime = 0;
        if (local) {
            nanoTime -= System.nanoTime();
            if (_autoFlush)
                io.wln("NOTE: auto-flush is on.");
            io.wln("<output>");
            io.flush();
        }

        solve();
        io.flush();

        if (local) {
            io.wln("</output>");
            nanoTime += System.nanoTime();
            long d9 = 1000000000, d6 = 1000000, d3 = 1000;
            if (nanoTime >= d9)
                io.wf("%d.%d seconds\n", nanoTime / d9, nanoTime % d9);
            else if (nanoTime >= d6)
                io.wf("%d.%d millis\n", nanoTime / d6, nanoTime % d6);
            else if (nanoTime >= d3)
                io.wf("%d.%d micros\n", nanoTime / d3, nanoTime % d3);
            else
                io.wf("%d nanos\n", nanoTime);
            io.flush();
        }

        io.close();
    }

    /**
     * Input-output class
     *
     * @author master_j
     * @version 0.3.2
     */
    private class IO {
//     _____________________________ _________________
//    |  mode  |      from/to       |  variable name  |
//    |--------|--------------------|-----------------|
//    |    0   |      System.*      |       STD_      |
//    |    1   |      *put.txt      |     _PUT_TXT    |
//    |    2   |  <_problemName>.*  |     PROBNAME_   |
//    |________|____________________|_________________|
//

        static final int STD_ = 0;
        static final int _PUT_TXT = 1;
        static final int PROBNAME_ = 2;

        StreamTokenizer st;
        BufferedReader br;
        Reader reader;

        PrintWriter pw;
        Writer writer;

        IO(int inMode, int outMode) throws IOException {
            Locale.setDefault(Locale.US);

            if (inMode == IO.STD_)
                reader = new InputStreamReader(System.in);
            else if (inMode == IO._PUT_TXT)
                reader = new FileReader("input.txt");
            else if (inMode == IO.PROBNAME_)
                reader = new FileReader(_problemName + ".in");
            else
                throw new IllegalStateException("You imbecile. How did you do that?");

            if (outMode == IO.STD_)
                writer = new OutputStreamWriter(System.out);
            else if (outMode == IO._PUT_TXT)
                writer = new FileWriter("output.txt");
            else if (outMode == IO.PROBNAME_)
                writer = new FileWriter(_problemName + ".out");
            else
                throw new IllegalStateException("You imbecille. Why did you do that?");

            br = new BufferedReader(reader);
            st = new StreamTokenizer(br);

            pw = new PrintWriter(writer, _autoFlush);
        }

        void wln()          {pw.println(); }
        void wln(boolean x) {pw.println(x);}
        void wln(char x)    {pw.println(x);}
        void wln(char x[])  {pw.println(x);}
        void wln(double x)  {pw.println(x);}
        void wln(float x)   {pw.println(x);}
        void wln(int x)     {pw.println(x);}
        void wln(long x)    {pw.println(x);}
        void wln(Object x)  {pw.println(x);}
        void wln(String x)  {pw.println(x);}

        void wf(String f, Object...o){pw.printf(f, o);}

        void w(boolean x)   {pw.print(x);}
        void w(char x)      {pw.print(x);}
        void w(char x[])    {pw.print(x);}
        void w(double x)    {pw.print(x);}
        void w(float x)     {pw.print(x);}
        void w(int x)       {pw.print(x);}
        void w(long x)      {pw.print(x);}
        void w(Object x)    {pw.print(x);}
        void w(String x)    {pw.print(x);}

        int nI() throws IOException    {st.nextToken(); return (int)st.nval;}
        double nD() throws IOException {st.nextToken(); return st.nval;}
        float nF() throws IOException  {st.nextToken(); return (float)st.nval;}
        long nL() throws IOException   {st.nextToken(); return (long)st.nval;}
        String nS() throws IOException {st.nextToken(); return st.sval;}

        void wc(String x){ wc(x.toCharArray()); }
        void wc(char c1, char c2){for(char c = c1; c<=c2; c++)wc(c);}
        void wc(char x[]){
            for(char c : x)
                wc(c);
        }
        void wc(char x){st.ordinaryChar(x); st.wordChars(x, x);}

        public boolean eof() {return st.ttype == StreamTokenizer.TT_EOF;}
        public boolean eol() {return st.ttype == StreamTokenizer.TT_EOL;}

        void flush(){pw.flush();}
        void close() throws IOException{reader.close(); br.close(); flush(); pw.close();}
    }

    public static void main(final String args[]) throws IOException {
        new Solution().init(args.length == 1 && args[0].equals(_localArg));
    }
}
