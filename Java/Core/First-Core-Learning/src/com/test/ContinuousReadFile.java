package com.test;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ContinuousReadFile {

	 public static void main( String[] args ) {
	       String fileName = "D:\\Demo.log";
	       try {
	        RandomAccessFile bufferedReader = new RandomAccessFile( fileName, "r" );

	        long filePointer;
	        while ( true ) {
	            final String string = bufferedReader.readLine();

	            if ( string != null )
	                System.out.println( string );
	            else {
	                filePointer = bufferedReader.getFilePointer();
	                bufferedReader.close();
	                Thread.sleep( 2500 );
	                bufferedReader = new RandomAccessFile( fileName, "r" );
	                bufferedReader.seek( filePointer );
	            }

	        }
	    } catch ( IOException | InterruptedException e ) {
	        e.printStackTrace();
	    }

	}
}
