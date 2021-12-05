package cliente_servidor;

import java.io.Serializable;

public class Termometro implements Serializable
{
	private float temperatura;

	
	public float getTemperatura()
	{
		return temperatura;
	}

	public void setTemperatura(float temperatura)
	{
		this.temperatura = temperatura;
	}
	
	public String toString()
	{
		String info = "Temperatura atual: " + this.getTemperatura();
		return info;
	}
}
