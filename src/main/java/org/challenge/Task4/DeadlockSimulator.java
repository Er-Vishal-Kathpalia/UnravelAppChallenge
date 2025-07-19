package org.challenge.Task4;

public class DeadlockSimulator {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    // Acquire both locks in a consistent global order
    public void method1() {
        acquireLocks( lock1, lock2, () -> {
            System.out.println( "Method1: Acquired lock1 and lock2" );
        } );
    }

    public void method2() {
        acquireLocks( lock1, lock2, () -> {
            System.out.println( "Method2: Acquired lock1 and lock2" );
        } );
    }

    private void acquireLocks( Object l1, Object l2, Runnable action ) {
        Object first = System.identityHashCode( l1 ) < System.identityHashCode( l2 ) ? l1 : l2;
        Object second = ( first == l1 ) ? l2 : l1;

        synchronized ( first ) {
            synchronized ( second ) {
                action.run();
            }
        }
    }

    public static void main( String[] args ) {
        DeadlockSimulator simulator = new DeadlockSimulator();
        Thread t1 = new Thread( simulator::method1 );
        Thread t2 = new Thread( simulator::method2 );
        t1.start();
        t2.start();
    }
}

