package com.github.fbrandes.slf4jgelf.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class ConsoleOutputCapturer {
    private ByteArrayOutputStream byteArrayOutputStream;
    private PrintStream previous;
    private boolean capturing;

    public void start() {
        if (capturing) {
            return;
        }

        capturing = true;
        previous = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();

        OutputStream outputStreamCombiner = new OutputStreamCombiner(Arrays.asList(previous, byteArrayOutputStream));
        PrintStream custom = new PrintStream(outputStreamCombiner);

        System.setOut(custom);
    }

    public String getOutput() {
        if (!capturing) {
            return "";
        }

        return byteArrayOutputStream.toString();
    }

    public void stop() {
        System.setOut(previous);
        byteArrayOutputStream = null;
        previous = null;
        capturing = false;
    }

    private static class OutputStreamCombiner extends OutputStream {
        private final List<OutputStream> outputStreams;

        public OutputStreamCombiner(List<OutputStream> outputStreams) {
            this.outputStreams = outputStreams;
        }

        public void write(int b) throws IOException {
            for (OutputStream os : outputStreams) {
                os.write(b);
            }
        }

        public void flush() throws IOException {
            for (OutputStream os : outputStreams) {
                os.flush();
            }
        }

        public void close() throws IOException {
            for (OutputStream os : outputStreams) {
                os.close();
            }
        }
    }
}
