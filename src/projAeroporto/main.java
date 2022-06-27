package projAeroporto;
import java.util.*;


public class main {
	
	static ArrayList<Aviao> avioes = new ArrayList<Aviao>();
	static ArrayList<Voo> voos = new ArrayList<Voo>();	
	static int vooCounter = 0;

	public static void main(String[] args) {
		
	Page mainMenu = new Page("MAINMENU");	
	
	}
			
	public static String[] getAvioesbyName() {
		
		String arr[] = new String[avioes.size()];
		
		for(int i = 0; i < avioes.size(); i++)
		{	
			Aviao a = avioes.get(i);
			arr[i] = a.getModelo();
		}
		
		return arr;		
	}		
	public static Integer[] getDateValues(String type) {
		
		Integer[] arr = {};
		
		if(type.equals("Day")) {
			Integer[] arr2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
			return arr2;		
		}
		if(type.equals("Month")) {
			Integer[] arr2 = {1,2,3,4,5,6,7,8,9,10,11,12};
			return arr2;		
		}
		if(type.equals("Year")) {
			Integer[] arr2 = {2022,2023,2024,2025,2026,2027,2028,2029,2030,2031,2032};
			return arr2;		
		}
		return arr;
	}		
	
public static Integer[] getTimeValues(String type) {
		
		Integer[] arr = {};
		
		if(type.equals("Hour")) {
			Integer[] arr2 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
			return arr2;		
		}
		if(type.equals("Minute")) {
			Integer[] arr2 = {0,15,30,45};
			return arr2;		
		}
		return arr;
	}

public static String[] listFlights()
{
	String arr[] = new String[voos.size()];
	for(int i = 0; i < voos.size(); i++) {
		Voo v = voos.get(i);
		arr[i] = v.getNro() + " - " + v.getAeronave().getModelo() + " - " + v.getData() + " - " + v.getHora();
	}
	
	return arr;
	
}

public static String[] createRowsArray(Voo voo)
{
	int nroFileiras = voo.getAeronave().getFileiras();
	String Fileiras[] = new String[nroFileiras];
	int i = 0;
	
	for(i =0; i < nroFileiras; i++)
	{
		Fileiras[i] = Integer.toString(i+1);
	}
	
	
	return Fileiras;
}

public static String[] createColumnsArray(Voo voo)
{
	int nroAssentos = voo.getAeronave().getAssentos();
	String Assentos[] = new String[nroAssentos];
	int i = 0;
	
	for(i =0; i < nroAssentos; i++)
	{
		Assentos[i] = Integer.toString(i+1);
	}
	
	
	return Assentos;
}

public static Object[][] getOccupiedSeats(Voo voo)
{
	
	int fil = voo.getAeronave().getFileiras();
	int ass = voo.getAeronave().getAssentos();
	Object[][] tableData  = new Object[fil*ass][3];
	int linha = 0;
	for(int i = 1; i <= fil; i++)
	{
		for(int j = 1; j <= ass; j++)
		{
			if(voo.getAeronave().verificaLugarOcupado(i, j))
			{
				tableData[linha][0] = voo.getAeronave().getPassageiro(i, j).getNome();
				tableData[linha][1] = Integer.toString(i);
				tableData[linha][2] = Integer.toString(j);
				linha++;
			}
			
		}
	}

	return tableData;
}

public static Object[][] getFreeSeats(Voo voo)
{
	
	int fil = voo.getAeronave().getFileiras();
	int ass = voo.getAeronave().getAssentos();
	Object[][] tableData  = new Object[fil*ass][3];
	int linha = 0;
	for(int i = 1; i <= fil; i++)
	{
		for(int j = 1; j <= ass; j++)
		{
			if(!(voo.getAeronave().verificaLugarOcupado(i, j)))
			{
				tableData[linha][0] = "";
				tableData[linha][1] = Integer.toString(i);
				tableData[linha][2] = Integer.toString(j);
				linha++;
			}
			
		}
	}

	return tableData;
}			

}
