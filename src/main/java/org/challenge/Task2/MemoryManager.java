package org.challenge.Task2;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MemoryManager {

    // Max 1000 sessions, expire 30 mins after last access
    private static final Cache<String,byte[]> sessionCache =
            CacheBuilder.newBuilder()
                        .maximumSize( 1000 )
                        .expireAfterAccess( 30, TimeUnit.MINUTES )
                        .build();
    ;

    public static void addSessionData( String sessionId ) {
        sessionCache.put( sessionId, new byte[1024 * 1024 * 10] ); // 10MB per session
    }

    public static void removeSessionData( String sessionId ) {
        sessionCache.invalidate( sessionId );
    }

    public static int getCurrentSessionCacheSize() {
        return Math.toIntExact( sessionCache.size() );
    }
}
