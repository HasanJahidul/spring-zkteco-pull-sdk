package io.github.hasanjahidul.protocol;

/**
 * ZKTeco device command constants
 */
public class ZKTecoCommand {

    // Connection commands
    public static final int CMD_CONNECT = 1000;
    public static final int CMD_EXIT = 1001;
    public static final int CMD_ENABLE_DEVICE = 1002;
    public static final int CMD_DISABLE_DEVICE = 1003;

    // Device information commands
    public static final int CMD_DEVICE = 11;  // Get device info with parameter string
    public static final int CMD_GET_VERSION = 1100;
    public static final int CMD_GET_DEVICE_NAME = 1101;
    public static final int CMD_GET_SERIAL_NUMBER = 1102;
    public static final int CMD_GET_PLATFORM = 1103;
    public static final int CMD_GET_OS_VERSION = 1104;
    public static final int CMD_GET_TIME = 201;
    public static final int CMD_SET_TIME = 202;
    public static final int CMD_CHANGE_SPEED = 1101;
    public static final int CMD_TEST_TEMP = 1011;
    public static final int CMD_TESTVOICE = 1017;

    // LCD commands
    public static final int CMD_WRITE_LCD = 66;
    public static final int CMD_CLEAR_LCD = 67;

    // User management commands
    public static final int CMD_SET_USER = 8;
    public static final int CMD_USER_TEMP_RRQ = 9;
    public static final int CMD_USER_TEMP_WRQ = 10;
    public static final int CMD_DELETE_USER = 18;
    public static final int CMD_DELETE_USER_TEMP = 19;
    public static final int CMD_CLEAR_DATA = 14;
    public static final int CMD_CLEAR_ADMIN = 20;

    // Attendance commands
    public static final int CMD_ATT_LOG_RRQ = 13;
    public static final int CMD_CLEAR_ATT_LOG = 15;
    public static final int CMD_GET_FREE_SIZES = 50;

    // Device control commands
    public static final int CMD_RESTART = 1004;
    public static final int CMD_POWEROFF = 1005;
    public static final int CMD_SLEEP = 1006;
    public static final int CMD_RESUME = 1007;
    
    // Function codes
    public static final int FCT_ATTLOG = 1;
    public static final int FCT_FINGERTMP = 2;
    public static final int FCT_OPLOG = 4;
    public static final int FCT_USER = 5;
    public static final int FCT_SMS = 6;
    public static final int FCT_UDATA = 7;
    public static final int FCT_WORKCODE = 8;
    
    // User levels
    public static final int LEVEL_USER = 0;
    public static final int LEVEL_ADMIN = 14;

    // Command types
    public static final int COMMAND_TYPE_GENERAL = 1;
    public static final int COMMAND_TYPE_DATA = 2;

    // Response codes
    public static final int CMD_ACK_OK = 2000;
    public static final int CMD_ACK_ERROR = 2001;
    public static final int CMD_ACK_DATA = 2002;
    public static final int CMD_ACK_UNAUTH = 2005;
    
    // Data commands
    public static final int CMD_PREPARE_DATA = 1500;
    public static final int CMD_DATA = 1501;
    public static final int CMD_FREE_DATA = 1502;

    private ZKTecoCommand() {
        // Utility class
    }
}
