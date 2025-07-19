package org.challenge.Task3;

class Consumer extends Thread {
    private LogProcessor processor;
    private final int consumerId;

    public Consumer( LogProcessor processor, int consumerId ) {
        this.processor = processor;
        this.consumerId = consumerId;
    }

    public void run() {
        try {
            while ( true ) {
                Task task = processor.consumeLog();
                System.out.println( "Consumer- " + consumerId + " processed: " + task.getLog() );
                Thread.sleep( 100 ); // Simulate processing time
            }
        } catch ( InterruptedException e ) {
            Thread.currentThread().interrupt();
        }
    }
}