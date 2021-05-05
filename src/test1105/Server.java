package test1105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class Server {
   static List<PrintWriter> outs = 
         new ArrayList<PrintWriter>();
   static List<BaseBallThread> threads =
         new ArrayList<BaseBallThread>();
   static List<Integer> arr = numberSelect();
   
   public static void main(String[] args) throws IOException {
      ServerSocket server = new ServerSocket(9000);
      while(true) {
         System.out.println("야구게임 클라이언트 대기 중");
         Socket client = server.accept();
         System.out.println("클라이언트 : " + client.getInetAddress());
         outs.add(new PrintWriter(client.getOutputStream()));
         BaseBallThread bt = new BaseBallThread(client, arr);
         threads.add(bt);
         bt.start();
      }
   }
   static List<Integer> numberSelect() {  //정답을 설정하는 구간
      LinkedHashSet<Integer> answer = new LinkedHashSet<Integer>();
      int data;
      while(answer.size() < 4) {
         data = (int)(Math.random()*10);
         answer.add(data);
      }
      System.out.println(answer);
      return new ArrayList<Integer>(answer);
   }
}
class BaseBallThread extends Thread {
   Socket client;
   List<Integer> answer;
   BufferedReader br;
   PrintWriter bw;
   String number;
   boolean able = true;
   BaseBallThread(Socket client, List<Integer> answer) {
      this.client = client;
      this.answer = answer;
      try {
         br = new BufferedReader
               (new InputStreamReader(client.getInputStream()));
         bw = new PrintWriter(client.getOutputStream());
      } catch(IOException e) {
         e.printStackTrace();
      }
   }
   public void run() {
      while(able) {
         try {
            number = br.readLine();
         } catch(IOException e) {
            e.printStackTrace();
         }
         char[] carr = number.toCharArray();
         int rcvData[] = new int [4];
         for(int i = 0; i < carr.length; i++)
            rcvData[i] = carr[i] - '0';
         int strike = 0;
         int ball = 0;
         int i, j;
         for(i = 0; i < rcvData.length; i++) {
            for(j = 0; j < rcvData.length; j++) {
               if(rcvData[i] == answer.get(j)) {
                  if(i == j) strike++;
                  else       ball++;
               }
            }
            if(strike == 4) {
               bw.println(number + "정답입니다. 게임을 종료합니다.");
               bw.flush();
               allClientClose();
               break;
            } else {
               bw.println(number + " : " + strike + "스트라이크, "
                      + ball + "볼");
               bw.flush();
            }
         }
      }
   }
   private void allClientClose() {
      Iterator<PrintWriter> list = Server.outs.iterator();
      Server.arr = Server.numberSelect();
      while(list.hasNext()) {
         PrintWriter w = list.next();
         w.println("다른 사용자가 이겼습니다. 게임을 종료합니다.");
         w.flush();
         list.remove();
      }
      Server.outs.clear();
      for(BaseBallThread t : Server.threads)
         t.able = false;
      Server.threads.clear();
   }
}