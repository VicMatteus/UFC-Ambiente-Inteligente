package cliente_servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Cliente implements Serializable
{
	public static void main(String args[])
	{
		Atuador atuador = new Atuador();
		//System.out.println(atuador.toString());
		Socket clientSocket;
		
		try
		{
			clientSocket = new Socket("localhost", 9876);
			ObjectOutputStream outServer = new ObjectOutputStream(clientSocket.getOutputStream());
			outServer.writeObject(atuador/*.toString()*/);
			//System.out.println("Informações enviadas.");
			clientSocket.close();
		}
		catch(IOException e)
		{
			System.out.println("erro em algum canto do cliente atuador");
			//e.printStackTrace();
		}
	}
}
