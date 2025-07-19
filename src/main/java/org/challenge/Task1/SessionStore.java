package org.challenge.Task1;

interface SessionStore {
    boolean createSession( String userId, String sessionId );

    boolean removeSession( String userId );

    boolean isSessionActive( String userId );

    String getSession( String userId );

    long getSessionCount();
}
