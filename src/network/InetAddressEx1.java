package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* InetAddress 클래스
 * - IP 주소 정보 저장하는 클래스
 * - 객체 생성위한 static 메서드
 *  InetAddress getByName("도메일이름")
 *  InetAddress[] getAllByName("도메인이름")
 *  InetAddress[] getByAddress(byte[])
 *  InetAddress[] getLocalHost()
 * */
public class InetAddressEx1 {
	public static void main(String[] args) throws UnknownHostException {
	 InetAddress ip = InetAddress.getByName("www.goodee.co.kr");
	 System.out.println("getByName 메서드");
	 System.out.println("hostName"+ip.getHostName());
	 System.out.println("hostaddreaa"+ip.getHostAddress());
	 //IPv4 : 32비트 => 4바이트
	 //IPv6 : 128비트 => 32바이트*4
	 byte[] ipAddr = ip.getAddress();
	 for(byte b : ipAddr) System.out.println(((b<0)?256+b:b )+".");
	 InetAddress[] ips = InetAddress.getAllByName("www.naver.com");
	 for(InetAddress a : ips) {
		 System.out.println("IP주소:" +a);
	 }
	 System.out.println("getByAddress 메서드 호출");
	 InetAddress ip2 = InetAddress.getByAddress(ipAddr);
	 System.out.println(ip2);
	 
	 System.out.println("getLocalHost 메서드 호출");
	 InetAddress local = InetAddress.getLocalHost();
	 System.out.println("내 컴퓨터: "+local);
	}
}
