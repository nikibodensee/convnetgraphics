package main.java.handleexe;

import java.awt.*;
import java.io.*;
import java.util.stream.Stream;

public class CRexe {

    private ProcessBuilder processbuild;
    private  Process process;
    private BufferedReader error;
    private BufferedWriter write;
    private BufferedReader read;

    public CRexe(String[] args) {
        this.processbuild = new ProcessBuilder(args);
    }

    public void startexe() throws IOException {

        //        this.process = processbuild.start();
        this.process = processbuild.redirectInput(ProcessBuilder.Redirect.INHERIT).start();

        this.error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        this.write = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
        this.read = new BufferedReader(new InputStreamReader(process.getInputStream()));

//        getOutputstream().forEach(System.out::println);

    }

    public void stopexe() {
        process.destroyForcibly();
    }

    public boolean alive() {
        return process.isAlive();
    }

    public Stream<String> getOutputstream() {
        return read.lines();
    }

    public void pressEnter() throws AWTException {

//        buf.write("\\h");
//        buf.newLine();
//        buf.flush();
//        buf.write("\\q");
//        buf.newLine();
//        buf.flush();

        Robot rob = new Robot();

        rob.keyPress(10);


    }

    public void leftMouseclick(boolean state) throws AWTException, InterruptedException {

        Robot rob = new Robot();
//        rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        rob.keyPress(17);
        rob.keyPress(83);
        rob.keyRelease(17);
        rob.keyRelease(83);
//        if(!state)
//        this.process.waitFor();
//
//        else
//            this.process.notify();
    }

}
