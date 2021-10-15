import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * En la classe Controlador, utilizarem cuatre coses, dos per ha la classe Model i Vista,
 * un ActionListener per als botons de buscar i reemplazar
 * i dos string per a la lectura i escritura del ficher.
 * Tambe utilitzarem un metode que es diu Control, per ha poder visualitzar el ficher cuant
 * activem la interficie i cuant utilitzem el dos botons creats, gracies als ActionListener.
 * Per ultim un metode privat (no acesible desde fora de la classe) que es diu voreFicher, que depenguent del boto que utilizem,
 * el ficher se vore en un camp o en altre.
 */

public class Controlador 
{
	private Model model;
	private Vista vista;
	private ActionListener actionListenerBuscar, actionListenerReemplazar;
	private String lectura, escritura;
	
	Controlador(Model model, Vista vista) 
	{
		this.model = model;
		this.vista = vista;
		control();
	}
	
	private void control() 
	{
		lectura = model.getlectura();
		escritura = model.getescritura();
		
		voreficher(lectura,1);
		
		actionListenerBuscar = new ActionListener() 
		{
			public void actionPerformed(ActionEvent actionevent) 
			{
				String text1 = vista.getTextFieldBuscar().getText();
				model.buscarText(text1);
			}
		};
		vista.getBtnBuscar().addActionListener(actionListenerBuscar);
		
		actionListenerReemplazar = new ActionListener() 
		{
			public void actionPerformed(ActionEvent actionevent) 
			{
				String text1 = vista.getTextFieldBuscar().getText();
				String text2 = vista.getTextFieldReemplazar().getText();
				model.reemplazarText(text1, text2);
				voreficher(escritura,2);
			}
		};
		vista.getBtnReemplazar().addActionListener(actionListenerReemplazar);
	}
	
	private void voreficher(String ficher, int numerodeCamp) 
	{
		ArrayList<String> arrayContingut = model.contingutFicher(ficher);
		
		for(String contingut : arrayContingut) 
		{
			if(numerodeCamp == 1) 
			{
				vista.getTextAreaOriginal().append(contingut + "\n");
			}
			else 
			{
				vista.getTextAreaModificado().append(contingut + "\n");
			}
		}
	}
}