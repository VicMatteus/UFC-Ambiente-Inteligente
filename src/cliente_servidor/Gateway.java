package cliente_servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//o gateway precisa receber os objetos e imprimir os seus estados,
//por exemplo.
public class Gateway
{
	public static void main (String args[])
	{
		ServerSocket listenSocket;
		Atuador atuador = new Atuador();
		Termometro termometro = new Termometro();
		Autenticador autenticador = new Autenticador();
		
		Class atuaClass = atuador.getClass();
		Class termoClass = termometro.getClass();
		Class autentiClass = autenticador.getClass(); 
				
		try
		{
			listenSocket = new ServerSocket(9876);
			while(true)
			{
				Socket connectionSocket = listenSocket.accept();
				ObjectInputStream inClient = new ObjectInputStream(connectionSocket.getInputStream());
				Object obj = inClient.readObject();
				Class classe = obj.getClass();
				
				if(classe == atuaClass)
				{
					atuador = (Atuador) obj;
				}
				
				if(classe == termoClass)
				{
					termometro = (Termometro) obj;
				}
				
				if(classe == autentiClass)
				{
					ObjectOutputStream outClient = new ObjectOutputStream(connectionSocket.getOutputStream());
					outClient.writeObject(atuador);
				}
				//String informacao = inClient.readUTF();
				System.out.println(obj.toString());
				//System.out.println(informacao);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
