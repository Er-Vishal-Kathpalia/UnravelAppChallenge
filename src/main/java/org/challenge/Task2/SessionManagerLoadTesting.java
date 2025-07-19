package org.challenge.Task2;

import org.challenge.Task1.InMemoryDatabaseSessionStore;
import org.challenge.Task1.SessionManager;

public class SessionManagerLoadTesting {

    public static void main( String[] args ) {
        SessionManager manager = new SessionManager( new InMemoryDatabaseSessionStore() );

        // Simulate 2000 logins
        for ( int i = 0; i < 20; i++ ) {
            String userId = "user" + i;
            manager.login( userId );
        }

        System.out.println( "SessionManager active sessions: " + manager.getSessionCount() );
        System.out.println( "MemoryManager cache size: " + MemoryManager.getCurrentSessionCacheSize() );

        for ( int i = 0; i < 10; i++ ) {
            manager.logout( "user" + i );
        }

        System.out.println( "After logout" );
        System.out.println( "SessionManager active sessions: " + manager.getSessionCount() );
        System.out.println( "MemoryManager cache size: " + MemoryManager.getCurrentSessionCacheSize() );
    }
}
