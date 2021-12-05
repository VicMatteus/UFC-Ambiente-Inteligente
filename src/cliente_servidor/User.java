package cliente_servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Scanner;

public class User implements Serializable
{
	
	public static void main(String[] args)
	{
		Scanner ler = new Scanner(System.in);
		Atuador atuador;
		Socket userSocket;
		Autenticador autenticador = new Autenticador();
		
		while (true)
		{
			System.out.println("Para checar o atuador, selecione 1");
			if(ler.nextInt() == 1)
			{
				try
				{
					userSocket = new Socket("localhost", 9876);
					ObjectOutputStream outServer = new ObjectOutputStream(userSocket.getOutputStream());
					outServer.writeObject(autenticador);
					ObjectInputStream inFromServer = new ObjectInputStream(userSocket.getInputStream());
					System.out.println(inFromServer.readObject().toString());
					userSocket.close();
				}
				catch(IOException e)
				{
					System.out.println("Erro no cliente do usuario");
				}
				catch (ClassNotFoundException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
}
