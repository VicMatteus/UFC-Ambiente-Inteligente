package cliente_servidor;

import java.io.Serializable;

public class Atuador implements Serializable
{
	private boolean estado;

	public boolean isEstado()
	{
		return estado;
	}

	public void setEstado(boolean estado)
	{
		this.estado = estado;
	}
	
	public String toString()
	{
		String info = "Atuador aberto?" + this.isEstado();
		return info;
	}
}
