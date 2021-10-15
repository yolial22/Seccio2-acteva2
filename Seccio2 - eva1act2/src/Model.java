import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * En la classe Model, utilizarem dos strings per a lectura i per ha escritura.
 * Un constructor que guarde el archiu descaregat i un altre amb el que creem nosaltres amb la interficie.
 * Un metode que es diu contingutFicher, on guarde tot el contingut del ficher que tenim.
 * Altre metode que es diu buscarText, on busque el text que enm recorregut del ficher que tenim.
 * Altre metode que es diu reemplazarText, on remplaze la pauraula que em buscat en el metode anterior i la sustituisca, per la que fiquen nosaltres, en aquest metode
 * i ens cree el mateix ficher que teniem, pero amb la sustitucio de la paraula remplaça.
 */

public class Model 
{
	private String lectura;
	private String escritura;
	
	Model() 
	{
		this.lectura = "AE02_T1_2_Streams_Groucho.txt";
		this.escritura = "Seccio2 - eva1act2.txt";
	}
	
	public ArrayList<String> contingutFicher(String ficher) 
	{
		ArrayList<String> contingutficher = new ArrayList<String>();
		
		File ficher1 = new File(ficher);
		
		try 
		{
			FileReader fr = new FileReader(ficher1);
			
			BufferedReader br = new BufferedReader(fr);
			
			String linea = br.readLine();
			
			while(linea != null) 
			{
				contingutficher.add(linea);
				linea = br.readLine();
			}
			br.close();
			fr.close();
		}
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
		}
		return contingutficher;
	}
	
	public String getlectura() 
	{
		return lectura;
	}
	
	public String getescritura() 
	{
		return escritura;
	}
	
	public int buscarText(String textbuscat) 
	{
		File lec = new File(lectura);
		
		int contaor = 0;
		
		try 
		{
			FileReader fr = new FileReader(lec);
			
			BufferedReader br = new BufferedReader(fr);
			
			String linea = br.readLine();
					
			while(linea != null)
			{
				contaor++;
				
				if(linea.indexOf(textbuscat) > -1)
				{
					contaor++;
				}
				linea = br.readLine();
			}
			
			br.close();
			fr.close();
			
			JOptionPane.showMessageDialog(new JFrame(), contaor, "INFOR", JOptionPane.INFORMATION_MESSAGE);
		}
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
		}
		return contaor;
	}
	
	public void reemplazarText(String textbuscat, String textnou) 
	{
		File lec = new File(lectura);
		
		File esc = new File(escritura);
		
		try 
		{
			FileReader fr = new FileReader(lec);
			
			BufferedReader br = new BufferedReader(fr);
			
			FileWriter fw = new FileWriter(esc);
			
			BufferedWriter bw = new BufferedWriter(fw);
			
			String linea = br.readLine();
			
			String linea2;
					
			while(linea != null)
			{
				linea2 = linea.replace(textbuscat, textnou);
					
				bw.write(linea2);
				
				bw.newLine();
					
				linea = br.readLine();
			}
			
			br.close();
			fr.close();
			bw.close();
			fw.close();
		}
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}