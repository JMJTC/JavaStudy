package algorithm.acwing.p1;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

public class DnsClient {
    private static final int DNS_PORT = 53;
    private static final byte[] DNS_HEADER = new byte[]{0x00, 0x01, 0x01, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
    private static final byte[] DNS_QUERY_TYPE = new byte[]{0x00, 0x01, 0x00, 0x01};

    public static void main(String[] args) {
        String domain = "www.baidu.com";
        try {
            byte[] dnsQuery = buildDNSQuery(domain);
            System.out.println("构造的DNS查询报文: " + bytesToHex(dnsQuery));

            DatagramPacket dnsPacket = new DatagramPacket(dnsQuery, dnsQuery.length, InetAddress.getByName("8.8.8.8"), DNS_PORT);
            DatagramSocket socket = new DatagramSocket();
            socket.send(dnsPacket);

            byte[] buffer = new byte[512];
            DatagramPacket dnsResponse = new DatagramPacket(buffer, buffer.length);
            socket.receive(dnsResponse);
            socket.close();

            System.out.println("接收的DNS响应报文: " + bytesToHex(dnsResponse.getData()));

            String ip = parseDNSResponse(dnsResponse.getData());
            System.out.println("域名 " + domain + " 对应的IP地址是：" + ip);
        } catch (IOException e) {
            System.out.println("无法解析域名");
        }
    }

    private static byte[] buildDNSQuery(String domain) {
        ByteBuffer buffer = ByteBuffer.allocate(512);
        buffer.put(DNS_HEADER);

        String[] parts = domain.split("\\.");
        for (String part : parts) {
            buffer.put((byte) part.length());
            buffer.put(part.getBytes());
        }

        buffer.put(DNS_QUERY_TYPE);
        return buffer.array();
    }

    private static String parseDNSResponse(byte[] data) throws UnknownHostException {
        ByteBuffer buffer = ByteBuffer.wrap(data);
        buffer.position(12); // Skip header

        // Skip domain name
        while (buffer.get() != 0) {
        }

        buffer.getShort(); // Skip type and class
        buffer.getInt(); // Skip TTL
        int ipLength = buffer.getShort() / 4;
        byte[] ipBytes = new byte[ipLength];
        buffer.get(ipBytes);

        return InetAddress.getByAddress(ipBytes).getHostAddress();
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}


