package projAeroporto;

import javax.swing.*;

public class Page extends JFrame {
	Object[] options;
	
	JFrame btn1,btn2,btn3;
	
	public Page(String pageType) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		if(pageType.equals("MAINMENU"))  {
		JFrame mainMenu = new JFrame("Menu de Reserva");
		Object[] options = {"1. Parâmetros do Sistema", "2. Reserva de Passagens","3. Sair"};
		
		int n = JOptionPane.showOptionDialog(
		mainMenu, "Selecione a opção desejada:",
		"Menu Navegação",
		JOptionPane.YES_NO_CANCEL_OPTION,
		JOptionPane.QUESTION_MESSAGE,
		null,
		options,
		options[2]);
			    
		    switch(n) {
		    case 0:
		    Page sysParam = new Page("SYSPARAM");
		    break;
		    
		    case 1:
		    Form ticketRes = new Form("TICKET");
		    break;
		    
		    case 2:
		    System.exit(0);
		    }
	    }
		if(pageType.equals("SYSPARAM"))  {
			JFrame systemParam = new JFrame("Parâmetros do Sistema");
			Object[] options2 = {"1. Cadastrar Aeronave", "2. Cadastrar Voo","3. Voltar"};
			
	    	int s = JOptionPane.showOptionDialog(
	    	systemParam, "Selecione a opção desejada:",
	    	"Parâmetros do Sistema",
	    	JOptionPane.YES_NO_CANCEL_OPTION,
	    	JOptionPane.QUESTION_MESSAGE,
	    	null,
	    	options2,
	    	options2[2]);
			
			    switch(s) {
			    case 0:
			    Form Airplane = new Form("AIRPLANE");
			    break;
			    
			    case 1:
			    Form Flight = new Form("FLIGHT");
			    break;
			    
			    case 2:
				Page sysParam = new Page("MAINMENU");
			    }
		    }
		
	}
	
	
	

}
