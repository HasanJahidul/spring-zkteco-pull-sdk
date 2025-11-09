package io.github.hasanjahidul.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for ZKTeco device
 */
@Data
@ConfigurationProperties(prefix = "zkteco")
public class ZKTecoProperties {

    /**
     * Device IP address
     */
    private String ipAddress;

    /**
     * Device port (default: 4370)
     */
    private int port = 4370;

    /**
     * Connection timeout in milliseconds
     */
    private int timeout = 60000;

    /**
     * Auto-connect on startup
     */
    private boolean autoConnect = false;
}
