package io.github.hasanjahidul;

import java.net.*;
import java.io.IOException;

/**
 * Network diagnostic test to verify connectivity to ZKTeco device
 */
public class NetworkDiagnosticTest {

    public static void main(String[] args) {
        String deviceIp = "192.168.68.222";
        int port = 4370;
        
        System.out.println("=".repeat(70));
        System.out.println("ZKTeco Device Network Diagnostic");
        System.out.println("Device: " + deviceIp + ":" + port);
        System.out.println("=".repeat(70));
        
        // Test 1: Check if IP is reachable
        System.out.println("\n[TEST 1] Testing IP reachability...");
        testReachability(deviceIp);
        
        // Test 2: DNS resolution
        System.out.println("\n[TEST 2] Testing DNS resolution...");
        testDnsResolution(deviceIp);
        
        // Test 3: UDP socket creation
        System.out.println("\n[TEST 3] Testing UDP socket creation...");
        testUdpSocket();
        
        // Test 4: Send test UDP packet
        System.out.println("\n[TEST 4] Testing UDP communication...");
        testUdpCommunication(deviceIp, port);
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("Diagnostic completed!");
        System.out.println("=".repeat(70));
    }
    
    private static void testReachability(String ip) {
        try {
            InetAddress address = InetAddress.getByName(ip);
            System.out.println("  IP Address: " + address.getHostAddress());
            
            // Try ICMP ping (may require root/admin privileges)
            boolean reachable = address.isReachable(5000);
            if (reachable) {
                System.out.println("  ✓ Device is reachable via ICMP");
            } else {
                System.out.println("  ⚠ Device is NOT reachable via ICMP (may be blocked by firewall)");
            }
        } catch (IOException e) {
            System.out.println("  ✗ Error: " + e.getMessage());
        }
    }
    
    private static void testDnsResolution(String ip) {
        try {
            InetAddress address = InetAddress.getByName(ip);
            System.out.println("  ✓ Successfully resolved: " + address.getHostAddress());
            System.out.println("  Hostname: " + address.getCanonicalHostName());
        } catch (UnknownHostException e) {
            System.out.println("  ✗ DNS resolution failed: " + e.getMessage());
        }
    }
    
    private static void testUdpSocket() {
        try {
            DatagramSocket socket = new DatagramSocket();
            System.out.println("  ✓ UDP socket created successfully");
            System.out.println("  Local port: " + socket.getLocalPort());
            socket.close();
        } catch (SocketException e) {
            System.out.println("  ✗ Failed to create UDP socket: " + e.getMessage());
        }
    }
    
    private static void testUdpCommunication(String ip, int port) {
        DatagramSocket socket = null;
        try {
            InetAddress address = InetAddress.getByName(ip);
            socket = new DatagramSocket();
            socket.setSoTimeout(5000); // 5 second timeout
            
            System.out.println("  Sending test packet to " + ip + ":" + port);
            
            // Create a simple ZKTeco connect packet
            byte[] connectPacket = createConnectPacket();
            DatagramPacket sendPacket = new DatagramPacket(
                connectPacket, 
                connectPacket.length, 
                address, 
                port
            );
            
            socket.send(sendPacket);
            System.out.println("  ✓ Packet sent successfully");
            
            // Try to receive response
            byte[] receiveBuffer = new byte[4096];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            
            System.out.println("  Waiting for response (5 second timeout)...");
            socket.receive(receivePacket);
            
            System.out.println("  ✓ Received response from device!");
            System.out.println("  Response length: " + receivePacket.getLength() + " bytes");
            System.out.println("  Response from: " + receivePacket.getAddress() + ":" + receivePacket.getPort());
            
            // Display response in hex
            System.out.print("  Response data (hex): ");
            for (int i = 0; i < Math.min(receivePacket.getLength(), 32); i++) {
                System.out.printf("%02X ", receiveBuffer[i]);
            }
            System.out.println();
            
        } catch (SocketTimeoutException e) {
            System.out.println("  ✗ Timeout: No response from device");
            System.out.println("  Possible causes:");
            System.out.println("    - Device is offline or unreachable");
            System.out.println("    - Firewall blocking UDP port " + port);
            System.out.println("    - Wrong IP address or port");
            System.out.println("    - Device not configured for network access");
        } catch (IOException e) {
            System.out.println("  ✗ Communication error: " + e.getMessage());
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
    
    private static byte[] createConnectPacket() {
        // Create a basic ZKTeco connect command packet
        // Protocol: [Start][Command][Checksum][Session][Reply][Data]
        byte[] packet = new byte[16];
        
        // Start marker (0x5050)
        packet[0] = 0x50;
        packet[1] = 0x50;
        packet[2] = (byte) 0x82;
        packet[3] = (byte) 0x7D;
        
        // Command (CMD_CONNECT = 1000 = 0x03E8)
        packet[4] = (byte) 0xE8;
        packet[5] = 0x03;
        
        // Checksum (0)
        packet[6] = 0x00;
        packet[7] = 0x00;
        
        // Session ID (0)
        packet[8] = 0x00;
        packet[9] = 0x00;
        
        // Reply number (0)
        packet[10] = 0x00;
        packet[11] = 0x00;
        
        // Data length (0)
        packet[12] = 0x00;
        packet[13] = 0x00;
        packet[14] = 0x00;
        packet[15] = 0x00;
        
        return packet;
    }
}
