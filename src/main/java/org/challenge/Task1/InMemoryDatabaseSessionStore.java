package org.challenge.Task1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDatabaseSessionStore implements SessionStore {

    public static Map<String,String> sessionStore = new ConcurrentHashMap<>();

    @Override
    public boolean createSession( String userId, String sessionId ) {
        return sessionStore.putIfAbsent( userId, sessionId ) == null;
    }

    @Override
    public boolean removeSession( String userId ) {
        return sessionStore.remove( userId ) != null;
    }

    @Override
    public boolean isSessionActive( String userId ) {
        return sessionStore.containsKey( userId );
    }

    @Override
    public String getSession( String userId ) {
        return sessionStore.getOrDefault( userId, null );
    }

    @Override
    public long getSessionCount() {
        return sessionStore.size();
    }
}
