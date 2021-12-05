package cliente_servidor;

import java.io.Serializable;

public class Autenticador implements Serializable
{
	private int id = 1;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	
	public String toString()
	{
		String info = "" + this.getId();
		return info;
	}
}
