package org.challenge.Task3;

public class Task implements Comparable<Task> {

    private final String log;
    private final int priority; // Lower value = higher priority
    private final long timestamp;

    public Task(String log, int priority) {
        this.log = log;
        this.priority = priority;
        this.timestamp = System.currentTimeMillis();
    }

    public String getLog() {
        return log;
    }

    public int getPriority() {
        return priority;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public int compareTo( Task o ) {
        if ( this.priority != o.priority ) {
            return Integer.compare( this.priority, o.priority );
        }
        return Long.compare( this.timestamp, o.timestamp );
    }
}
