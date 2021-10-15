/*
 * En la classe Principal, utilitzarem les classes que hem creat, per ha poder utilitzar i vore la interficie.
 */

public class Principal 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Model modelo = new Model();
		Vista vista = new Vista();
		Controlador controlador = new Controlador(modelo, vista);
	}
}