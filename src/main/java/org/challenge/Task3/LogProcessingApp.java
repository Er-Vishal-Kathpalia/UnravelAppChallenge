package org.challenge.Task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LogProcessingApp {
    public static void main( String[] args ) {
        LogProcessor processor = new LogProcessor();

        for ( int i = 1; i <= 3; i++ ) {
            new Producer( processor, i ).start();
        }

        ExecutorService consumerPool = Executors.newFixedThreadPool( 2 );
        for ( int i = 1; i <= 2; i++ ) {
            consumerPool.submit( new Consumer( processor, i ) );
        }
    }
}
