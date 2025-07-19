package org.challenge.Task1;

public class TestSessionManager {
    public static void main( String[] args ) {
        SessionManager manager = new SessionManager( new InMemoryDatabaseSessionStore() );
        System.out.println( manager.login( "User_1" ) );
        System.out.println( manager.getSessionDetails( "User_1" ) );
        System.out.println( manager.logout( "User_1" ) );
    }
}
