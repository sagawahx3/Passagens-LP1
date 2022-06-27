package projAeroporto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class Form extends JFrame {
	
	Voo newVoo;
	JLabel lFil;
	JLabel lAss;
	boolean flag = false;
	boolean flag2 = false;
	
	JScrollPane frame;
	JScrollPane newframe;

	
	public Form(String formType) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		if(formType.equals("AIRPLANE")) 
			setPlaneForm();
		
		else if(formType.equals("FLIGHT")) 
			setFlightForm();
		
		else if(formType.equals("TICKET")) 
			setTicketRes();
	}
	
	public void setPlaneForm() {
		
		setSize(300,300);
		revalidate();
		repaint();
		setTitle("Cadastrar Avião");	
		JLabel lMod = new JLabel("Modelo: ");
		JLabel lFil = new JLabel("Fileiras: ");
		JLabel lAss = new JLabel("Assentos/fileira: ");
		JTextField tMod = new JTextField();
		JTextField tFil = new JTextField();
		JTextField tAss = new JTextField();
		JButton btnSet = new JButton("Cadastrar");
		JButton btnBack = new JButton("Retornar");
		lMod.setBounds(10,10,260,30);
		tMod.setBounds(10,35,260,30);
		lFil.setBounds(10,70,260,30);
		tFil.setBounds(10,95,260,30);
		lAss.setBounds(10,130,260,30);
		tAss.setBounds(10,155,260,30);
		btnSet.setBounds(10,200,120,30);
		btnBack.setBounds(150,200,120,30);		
		add(lMod);
		add(tMod);
		add(lFil);
		add(tFil);
		add(lAss);
		add(tAss);
		add(btnSet);
		add(btnBack);
		
		btnSet.addActionListener((event) -> {
			
			try {
				
				String mod = tMod.getText().trim();
				int fil = Integer.parseInt(tFil.getText());
				int ass = Integer.parseInt(tAss.getText());
							
				if(mod.isEmpty())
				{
					throw new Exception();
				}
				else {
				Aviao aviao = new Aviao(mod, fil, ass);
				main.avioes.add(aviao);
				JOptionPane.showMessageDialog(this, "Modelo cadastrado com sucesso!");
				}
				tMod.setText("");
				tFil.setText("");
				tAss.setText("");
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this, "Informações inválidas.",  "Erro!", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		btnBack.addActionListener((event) -> {
			remove(lMod);
			remove(tMod);
			remove(lFil);
			remove(tFil);
			remove(lAss);
			remove(tAss);
			remove(btnSet);
			remove(btnBack);
			setVisible(false);

		Page mainMenu = new Page("SYSPARAM");	
		});
		
	setLayout(null);
	setVisible(true);
	
	}		
			
	public void setFlightForm(){
		
		revalidate();
		repaint();
		setSize(300,300);
		setTitle("Cadastrar Vôo");	
		
		JLabel lAvi = new JLabel("Aviao: ");
		JLabel lDat = new JLabel("Data: ");
		JLabel lHor = new JLabel("Hora: ");
		JComboBox<String> boxAvioes = new JComboBox<>(main.getAvioesbyName());
		JComboBox<Integer> boxDateDay = new JComboBox<>(main.getDateValues("Day"));
		JComboBox<Integer> boxDateMonth = new JComboBox<>(main.getDateValues("Month"));
		JComboBox<Integer> boxDateYear = new JComboBox<>(main.getDateValues("Year"));
		JComboBox<Integer> boxTimeHour = new JComboBox<>(main.getTimeValues("Hour"));
		JComboBox<Integer> boxTimeMinute = new JComboBox<>(main.getTimeValues("Minute"));
		JButton btnSet = new JButton("Cadastrar");
		JButton btnBack = new JButton("Retornar");
		lAvi.setBounds(10,10,260,30);
		boxAvioes.setBounds(10,35,260,30);
		lDat.setBounds(10,70,100,30);
		boxDateDay.setBounds(10, 100, 80, 30);
		boxDateMonth.setBounds(90, 100, 80, 30);
		boxDateYear.setBounds(170, 100, 80, 30);
		lHor.setBounds(10,140,100,30);
		boxTimeHour.setBounds(10,170,80,30);
		boxTimeMinute.setBounds(90,170,80,30);
		btnSet.setBounds(10,220,120,30);
		btnBack.setBounds(150,220,120,30);
		add(lAvi);
		add(lDat);
		add(lHor);
		add(boxAvioes);
		add(boxDateDay);
		add(boxDateMonth);
		add(boxDateYear);
		add(boxTimeHour);
		add(boxTimeMinute);
		add(btnSet);
		add(btnBack);
		
btnSet.addActionListener((event) -> {
			try {
				String avi = boxAvioes.getSelectedItem().toString().trim();
				String dateDay = boxDateDay.getSelectedItem().toString().trim();
				String dateMonth = boxDateMonth.getSelectedItem().toString().trim();
				String dateYear = boxDateYear.getSelectedItem().toString().trim();
				String timeHour = boxTimeHour.getSelectedItem().toString().trim();
				String timeMinute = boxTimeMinute.getSelectedItem().toString().trim();
				
				String bar = "/";
				String hourSep = ":";

				String date = dateDay;
				date = date.concat(bar);
				date = date.concat(dateMonth);
				date = date.concat(bar);
				date = date.concat(dateYear);
			//	System.out.print(date);
				String hour = timeHour;
				hour = hour.concat(hourSep);
				hour = hour.concat(timeMinute);


				if(avi.isEmpty())
				{
					throw new Exception("Dados inválidos!");
				}
				
				Aviao newAviao = null;
								
			    for (Aviao aviao : main.avioes) {
			    	if(aviao.modelo.equals(avi)) {
			    		newAviao = aviao;
			    		break;
			    	}
			    }
			    
			    
				Voo newVoo = new Voo(newAviao, main.vooCounter, date, hour);
				main.voos.add(newVoo);
			    main.vooCounter++;

			JOptionPane.showMessageDialog(this, "Vôo cadastrado com sucesso!");

			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this, "Dados inválidos.",  "Erro!", JOptionPane.ERROR_MESSAGE);
			}
			
			
		});
		
		btnBack.addActionListener((event) -> {
			remove(lAvi);
			remove(lDat);
			remove(lHor);
			remove(boxAvioes);
			remove(boxDateDay);
			remove(boxDateMonth);
			remove(boxDateYear);
			remove(boxTimeHour);
			remove(boxTimeMinute);
			remove(btnSet);
			remove(btnBack);
			setVisible(false);	
			Page sysParam = new Page("SYSPARAM");

		});
	setLayout(null);
	setVisible(true);	
	}
	
	public void setTicketRes(){
		try {
		if(main.voos.get(0) == null) throw new Exception();
		}
		catch(Exception e)
		{
		JOptionPane.showMessageDialog(this, "Não existem vôos cadastrados.",  "Erro!", JOptionPane.ERROR_MESSAGE);
		Page mainMenu = new Page("MAINMENU");
		}
				
		setSize(700,350);
		revalidate();
		repaint();
		setTitle("Passageiro - Realizar Reserva");
	
		JLabel lNom = new JLabel("Nome: ");
		JLabel lCpf = new JLabel("CPF: ");
		JLabel lVoo = new JLabel("Vôo: ");
		JTextField tNom = new JTextField();
		JTextField tCpf = new JTextField();
		JButton btnBack = new JButton("Voltar");
		JButton btnSet = new JButton("Registrar");
		JButton btnFree = new JButton("Mostrar Livres");

		String arrFil[] = {};
		String arrAss[] = {};
		JComboBox<String> boxFil = new JComboBox<>(arrFil);
		JComboBox<String> boxAss = new JComboBox<>(arrAss);

		String arrVoos[] = main.listFlights();
		JComboBox<String> boxVoos = new JComboBox<>(arrVoos);
		
		newVoo = null;

		lNom.setBounds(10,10,360,30);
		tNom.setBounds(10,35, 360,30);
		lCpf.setBounds(10,70,360,30);
		tCpf.setBounds(10,95,360,30);
		lVoo.setBounds(10,130,360,30);
		boxVoos.setBounds(10, 155, 360, 30);
		btnBack.setBounds(235,260,135,30);
		
		add(lNom);
		add(lCpf);
		add(lVoo);
		add(tNom);
		add(tCpf);
		add(boxVoos);
		add(btnBack);

		
			boxVoos.addActionListener((event) ->{
			
			
			int nroVoo = boxVoos.getSelectedIndex();
			
		    for (Voo v : main.voos) {
		    //	System.out.print("index" + nroVoo + "\n");

		    	if(v.getNro() == nroVoo) {
				    newVoo = v;
				//	System.out.print("break");
					break;
					} 
		    }
		    
		 //    for (Voo v : main.voos) 
		 //   	System.out.print(v.getNro() + "\n");
		    
			String[] newArrFil = main.createRowsArray(newVoo);
			String[] newArrAss = main.createColumnsArray(newVoo);
			

		    DefaultComboBoxModel<String> newBoxFil = new DefaultComboBoxModel<>(newArrFil);
			DefaultComboBoxModel<String> newBoxAss = new DefaultComboBoxModel<>(newArrAss);
			boxFil.setModel( newBoxFil );
			boxAss.setModel( newBoxAss );

			lFil = new JLabel("Fileira: ");
			lAss = new JLabel("Assento: ");
			
			if(flag) 
				remove(frame);
			
			String[] fields = {"Passageiro:", "Fileira:", "Assento:"};
			Object[][] tableData = main.getOccupiedSeats(newVoo);
			JTable tableVoos = new JTable(tableData, fields);
			frame = new JScrollPane(tableVoos);
			
			frame.setBounds(380, 10, 280, 280);
			btnFree.setBounds(380, 290, 150, 30);
			lFil.setBounds(10,190,135,30);
			lAss.setBounds(220,190,135,30);
			boxFil.setBounds(10, 215, 150, 30);
			boxAss.setBounds(220, 215, 150, 30);
			lFil.setBounds(10,190,135,30);
			
			btnSet.setBounds(10,260,135,30);
			add(btnSet);
			add(boxFil);
			add(boxAss);
			add(btnFree);			
			add(lFil);
			add(lAss);
			add(frame);
			revalidate();
			repaint();
			flag = true;

		});
			
		btnSet.addActionListener((event) -> {
			
				try {
					
				int nroVoo = boxVoos.getSelectedIndex();
				   for (Voo v : main.voos) {

				    if(v.getNro() == nroVoo) {
						    newVoo = v;
							break;
						} 
				   }
									
				String nome = tNom.getText();
				String cpf = tCpf.getText();
				String fil = boxFil.getSelectedItem().toString();
				String ass = boxAss.getSelectedItem().toString();
				
				if(nome.isEmpty() || cpf.isEmpty() || fil.isEmpty() || ass.isEmpty())
				{
					throw new Exception();
				}
				
				int nroFil = Integer.parseInt(fil);
				int nroAss = Integer.parseInt(ass);
				Passageiro passageiro = new Passageiro(nome, cpf);

				if(!(newVoo.getAeronave().verificaLugarOcupado(nroFil, nroAss)))
				{
					newVoo.getAeronave().setPassageiro(nroFil, nroAss, passageiro);
					JOptionPane.showMessageDialog(this, "Ticket reservado com sucesso!");
					tNom.setText("");
					tCpf.setText("");
					boxVoos.setSelectedIndex(0);
					boxFil.setSelectedIndex(0);
					boxAss.setSelectedIndex(0);
				}
				else {
					JOptionPane.showMessageDialog(this, "Lugar ocupado.",  "Erro!", JOptionPane.ERROR_MESSAGE);
				}

			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this, "Dados inválidos.",  "Erro!", JOptionPane.ERROR_MESSAGE);
			}	
				remove(frame);
				String[] fields = {"Passageiro:", "Fileira:", "Assento:"};
				Object[][] tableData = main.getOccupiedSeats(newVoo);
				JTable newTable = new JTable(tableData, fields);
				frame = new JScrollPane(newTable);
				frame.setBounds(380, 10, 280, 280);
				add(frame);	
				revalidate();
				repaint();
			});		
		
		btnFree.addActionListener((event) -> {
			
			remove(frame);
			String[] fields = {"Passageiro:", "Fileira:", "Assento:"};
			Object[][] tableData = main.getFreeSeats(newVoo);
			JTable newTable = new JTable(tableData, fields);
			frame = new JScrollPane(newTable);
			frame.setBounds(380, 10, 280, 280);
			add(frame);	
			revalidate();
			repaint();
		});	
		
		btnBack.addActionListener((event) -> {	
			remove(lNom);
			remove(lCpf);
			remove(lVoo);
			remove(tNom);
			remove(tCpf);
			remove(boxVoos);
			remove(btnBack);
			if(flag) {
			remove(btnFree);			
			remove(btnSet);
			remove(frame);
			remove(boxFil);
			remove(boxAss);
			remove(lFil);
			remove(lAss);
			}
			setVisible(false);
			Page mainMenu = new Page("MAINMENU");
			
		});
		setLayout(null);
		setVisible(true);	
		}
	
}
