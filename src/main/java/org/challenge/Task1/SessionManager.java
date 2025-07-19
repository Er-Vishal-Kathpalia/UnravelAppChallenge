package org.challenge.Task1;

import org.challenge.Task2.MemoryManager;

import java.util.UUID;

public class SessionManager {

    private final SessionStore sessionStore;

    public SessionManager( SessionStore sessionStore ) {
        this.sessionStore = sessionStore;
    }

    public String login( String userId ) {
        try {
            if ( sessionStore.isSessionActive( userId ) ) {
                return "User already logged in.";
            }
            String sessionId = "SESSION_" + UUID.randomUUID();
            MemoryManager.addSessionData( sessionId );
            boolean success = sessionStore.createSession( userId, sessionId );
            if ( success ) {
                return "Login successful. Session ID: " + sessionId;
            }
            return "Login failed. Please try again later.";
        } catch ( Exception exception ) {
            return "Login failed due to internal error: " + exception.getMessage();
        }
    }

    public String logout( String userId ) {
        try {
            if ( !sessionStore.isSessionActive( userId ) ) {
                return "User not logged in.";
            }
            MemoryManager.removeSessionData( sessionStore.getSession( userId ) );
            boolean removed = sessionStore.removeSession( userId );
            if ( !removed ) {
                return "User not logged in.";
            }
            return "Logout successful.";
        } catch ( Exception e ) {
            return "Logout failed due to internal error: " + e.getMessage();
        }
    }


    public String getSessionDetails( String userId ) {
        try {
            String sessionId = sessionStore.getSession( userId );
            if ( sessionId == null ) {
                return "Session not found for user: " + userId;
            }
            return "Session ID for user " + userId + ": " + sessionId;
        } catch ( Exception e ) {
            return "Error fetching session details: " + e.getMessage();
        }
    }

    public long getSessionCount() {
        return sessionStore.getSessionCount();
    }

}
