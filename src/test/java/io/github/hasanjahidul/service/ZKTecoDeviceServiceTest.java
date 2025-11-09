package io.github.hasanjahidul.service;

import io.github.hasanjahidul.exception.ZKTecoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZKTecoDeviceServiceTest {

    private ZKTecoDeviceService service;

    @BeforeEach
    void setUp() {
        // Using a non-existent IP for unit tests
        service = new ZKTecoDeviceService("192.168.1.201");
    }

    @Test
    void testInitialization() {
        assertNotNull(service);
        assertFalse(service.isConnected());
    }

    @Test
    void testGetAttendanceWithoutConnection() {
        assertThrows(ZKTecoException.class, () -> service.getAttendance());
    }

    @Test
    void testGetDeviceInfoWithoutConnection() {
        assertThrows(ZKTecoException.class, () -> service.getDeviceInfo());
    }

    @Test
    void testGetUsersWithoutConnection() {
        assertThrows(ZKTecoException.class, () -> service.getUsers());
    }

    @Test
    void testClose() {
        assertDoesNotThrow(() -> service.close());
    }
}
