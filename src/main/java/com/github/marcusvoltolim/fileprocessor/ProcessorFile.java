package com.github.marcusvoltolim.fileprocessor;

import java.io.*;
import java.util.List;

public final class ProcessorFile {

    private ProcessorFile() {
    }

    public static File decompress(final InputStream inputStream) throws IOException {
        return ProcessorFactory.getInstance().getDecompress().decompress(inputStream);
    }

    public static File compress(final List<File> files, final String mediaType) throws IOException {
        return ProcessorFactory.getInstance().getCompress(mediaType).compress(files);
    }

    public static void main(String[] args) throws IOException {
        if(args == null || args.length == 0){
            String name = new BufferedReader(new InputStreamReader(System.in)).readLine();
            System.out.println("file name:" + name);
            decompress(new FileInputStream(name));
        }
        for (String arg : args) {
            decompress(new FileInputStream(arg));
        }
    }
}