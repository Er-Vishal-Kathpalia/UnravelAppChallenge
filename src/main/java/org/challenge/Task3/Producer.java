package org.challenge.Task3;

class Producer extends Thread {
    private LogProcessor processor;
    private final int producerId;

    public Producer( LogProcessor processor, int producerId ) {
        this.processor = processor;
        this.producerId = producerId;
    }

    public void run() {
        for ( int i = 0; i < 30; i++ ) {
            int priority = ( int ) ( Math.random() * 3 ); // 0 = high, 1 = medium, 2 = low
            String log = "Producer-" + producerId + " Log " + i + " [Priority " + priority + "]";
            processor.produceLog( log, priority );
            try {
                Thread.sleep( 50 );
            } catch ( InterruptedException e ) {
                Thread.currentThread().interrupt();
            }
        }
    }
}