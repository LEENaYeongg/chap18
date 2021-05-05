package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* InetAddress Ŭ����
 * - IP �ּ� ���� �����ϴ� Ŭ����
 * - ��ü �������� static �޼���
 *  InetAddress getByName("�������̸�")
 *  InetAddress[] getAllByName("�������̸�")
 *  InetAddress[] getByAddress(byte[])
 *  InetAddress[] getLocalHost()
 * */
public class InetAddressEx1 {
	public static void main(String[] args) throws UnknownHostException {
	 InetAddress ip = InetAddress.getByName("www.goodee.co.kr");
	 System.out.println("getByName �޼���");
	 System.out.println("hostName"+ip.getHostName());
	 System.out.println("hostaddreaa"+ip.getHostAddress());
	 //IPv4 : 32��Ʈ => 4����Ʈ
	 //IPv6 : 128��Ʈ => 32����Ʈ*4
	 byte[] ipAddr = ip.getAddress();
	 for(byte b : ipAddr) System.out.println(((b<0)?256+b:b )+".");
	 InetAddress[] ips = InetAddress.getAllByName("www.naver.com");
	 for(InetAddress a : ips) {
		 System.out.println("IP�ּ�:" +a);
	 }
	 System.out.println("getByAddress �޼��� ȣ��");
	 InetAddress ip2 = InetAddress.getByAddress(ipAddr);
	 System.out.println(ip2);
	 
	 System.out.println("getLocalHost �޼��� ȣ��");
	 InetAddress local = InetAddress.getLocalHost();
	 System.out.println("�� ��ǻ��: "+local);
	}
}
