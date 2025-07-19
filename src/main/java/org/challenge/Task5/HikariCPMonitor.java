package org.challenge.Task5;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class HikariCPMonitor {

    private final HikariDataSource hikariDataSource;

    @Autowired
    public HikariCPMonitor( DataSource dataSource ) {
        if ( dataSource instanceof HikariDataSource ) {
            this.hikariDataSource = ( HikariDataSource ) dataSource;
        } else {
            throw new IllegalArgumentException( "Not a HikariDataSource" );
        }
    }

    // Log pool status every 30 seconds
    @Scheduled(fixedRate = 30000)
    public void monitorPool() {
        HikariPoolMXBean poolMXBean = hikariDataSource.getHikariPoolMXBean();
        if ( poolMXBean == null ) {
            System.err.println( "[HIKARI ERROR] HikariPoolMXBean is null, please check connection!!!" );
            return;
        }
        int active = poolMXBean.getActiveConnections();
        int idle = poolMXBean.getIdleConnections();
        int total = poolMXBean.getTotalConnections();
        int pending = poolMXBean.getThreadsAwaitingConnection();

        if ( pending > 5 ) {
            System.err.println( "[HIKARI WARNING] Too many threads waiting for a connection: " + pending );
        }

        if ( idle > 20 ) {
            System.out.println( "[HIKARI INFO] Connections underutilized. Idle connections: " + idle );
        }

        System.out.println( "[HIKARI METRICS] Total: " + total +
                ", Active: " + active +
                ", Idle: " + idle +
                ", Waiting: " + pending );
    }
}
