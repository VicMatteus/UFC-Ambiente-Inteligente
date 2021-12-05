package cliente_servidor;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class ClienteTerm implements Serializable
{
	public static void main(String args[]) throws InterruptedException
	{
		Termometro termometro = new Termometro();
		//System.out.println(atuador.toString());
		Socket clientSocket;
		
		try
		{
			while(true)
			{ 
				clientSocket = new Socket("localhost", 9876);
				ObjectOutputStream outServer = new ObjectOutputStream(clientSocket.getOutputStream());
				outServer.writeObject(termometro/*.toString()*/);
				//System.out.println("Informações enviadas.");
				clientSocket.close();
				new Thread().sleep(3000); //tempo x em que o termometro atualiza sua temperatura
			}
		}
		catch(IOException e)
		{
			System.out.println("erro em algum canto do cliente termometro");
			//e.printStackTrace();
		}
	}

}
