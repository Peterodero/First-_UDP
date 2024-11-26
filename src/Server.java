import java.io.IOException;
import java.net.*;

public class Server {
    public  static  void  main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(1234);

        while (true){
            byte[] b = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(b,b.length);
            datagramSocket.receive(datagramPacket);

            String string = new String(datagramPacket.getData());

            System.out.println("Client: "+string.trim());

            //Sending

            byte[] b1 = string.getBytes();
            InetAddress inetAddress = InetAddress.getLocalHost();
            DatagramPacket datagramPacket1 = new DatagramPacket(b1, b1.length,inetAddress, datagramPacket.getPort());

            datagramSocket.send(datagramPacket1);
        }








    }
}
