package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class BashRunner
{
    public static final String BASH_PATH = "C:/Program Files/Git/bin/sh.exe";
    public static final String SCRIPT_NAME = "C:/temp/test-script.sh";

    public static void main(String[] args)
    {
        String output = runCommand(BASH_PATH, "-c", SCRIPT_NAME);
        System.out.println(output);
    }

    public static String runCommand(String... params)
    {
        ProcessBuilder pb = new ProcessBuilder(params);
        Process p;
        StringJoiner joiner = new StringJoiner(System.getProperty("line.separator"));
        try
        {
            p = pb.start();

            final BufferedReader reader = new BufferedReader(
                new InputStreamReader(p.getInputStream()));

            reader.lines().iterator().forEachRemaining(joiner::add);

            p.waitFor();
            p.destroy();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return joiner.toString();
    }
}