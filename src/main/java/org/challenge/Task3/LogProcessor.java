package org.challenge.Task3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class LogProcessor {

    private final PriorityBlockingQueue<Task> logQueue = new PriorityBlockingQueue<>();

    public void produceLog( String log, int priority ) {
        logQueue.put( new Task( log, priority ) );
    }

    public Task consumeLog() throws InterruptedException {
        return logQueue.take();
    }
}
