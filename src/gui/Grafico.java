package gui;

import index.Indexa��o;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Grafico extends JFrame {

	BufferedReader f = null;

	DefaultListModel model = new DefaultListModel();

	String[] lista;
	int x = 0;
	
	String pesquisa;
	
	String [] lista_12;

	JFrame janela;
	JButton crawl;
	JMenuBar menubar;
	JMenu ficheiro;
	JMenu index;

	JLabel texto_pesquisa;
	JLabel url;
	JLabel num_crw;
	JLabel prof_crw;

	JTextField campo_pesquisa;
	JTextField campo_url;
	JTextField campo_num_crw;
	JTextField campo_prof;

	JSeparator separador;

	JScrollBar barra1;
	JScrollBar barra2;
	JScrollBar barra3;
	JScrollBar barra4;

	JLabel espa�o;

	JTextArea campo1;
	// JTextField campo1;
	// JList campo1 = new JList(listagem);
	JList campo_lista = new JList(model);
	JTextArea campo3;

	public Grafico() {

		// defini��es b�sicas da janela

		janela = new JFrame("PCD Google by Nagios Team");
		janela.setSize(1500, 800);
		janela.setResizable(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(new FlowLayout());

		// defini��o das Labels e acr�scimo destas � janela

		texto_pesquisa = new JLabel("Campo de Pesquisa: ");
		texto_pesquisa.setLayout((new BorderLayout()));
		url = new JLabel("URL");
		num_crw = new JLabel("# of crawlers");
		prof_crw = new JLabel("Crawl Dept");
		espa�o = new JLabel("   ");
		separador = new JSeparator();

		lista_12 = new String[] {"a.txt", "b.txt", "c.txt", "dica"};
		
		lista = new String []{"A", "B", "C"};
		// campo1 = new JList(lista);
		campo1 = new JTextArea();
		campo1.setPreferredSize(new java.awt.Dimension(900, 500));

		campo_lista = new JList(model);
		campo_lista.setPreferredSize(new java.awt.Dimension(250, 500));
		campo_lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		campo_lista.setSelectedIndex(-1);
		campo_lista.setLayoutOrientation(JList.VERTICAL);

		campo3 = new JTextArea();
		campo3.setPreferredSize(new java.awt.Dimension(1200, 150));

		// defini��o dos campos de texto e acr�scimo � janela

		campo_pesquisa = new JTextField(30);
		campo_url = new JTextField(30);
		campo_num_crw = new JTextField(2);
		campo_prof = new JTextField(2);

		crawl = new JButton("CRAWL");

		barra1 = new JScrollBar();
		barra1.setPreferredSize(new java.awt.Dimension(20, 500));

		barra2 = new JScrollBar();
		barra2.setPreferredSize(new java.awt.Dimension(20, 500));

		barra3 = new JScrollBar();
		barra3.setPreferredSize(new java.awt.Dimension(20, 150));

		barra4 = new JScrollBar();
		barra4.setPreferredSize(new java.awt.Dimension(1200, 20));
		barra4.setOrientation(0);

		// defini��o do bot�o Crawl e acr�scimo

		// menu

		menubar = new JMenuBar();
		ficheiro = new JMenu("Ficheiro");
		index = new JMenu("Index");

		janela.add(texto_pesquisa);
		janela.add(campo_pesquisa);
		janela.add(separador);

		janela.add(url);
		janela.add(campo_url);
		janela.add(espa�o);

		janela.add(num_crw);
		janela.add(campo_num_crw);
		janela.add(espa�o);

		janela.add(prof_crw);
		janela.add(campo_prof);
		janela.add(crawl);

		janela.add(campo1);

		janela.add(barra1);

		janela.add(campo_lista);
		janela.add(barra2);

		janela.add(barra4);

		janela.add(campo3);
		janela.add(barra3);

		menubar.setVisible(true);

		// A partir daqui � que coloquei o c�digo do Menu
		JMenuBar menuBar = new JMenuBar();

		// Create a menu
		JMenu menu1 = new JMenu("File");
		JMenu menu2 = new JMenu("Index");
		menuBar.add(menu1);
		menuBar.add(menu2);

		// Create a menu item
		JMenuItem reset = new JMenuItem("Reset Index");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem exit = new JMenuItem("Exit");

		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//				
			}
		});
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janela.setVisible(false);
			}
		});

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janela.setVisible(false);
			}
		});
		
	
		
		 campo_lista.addListSelectionListener( new ListSelectionListener() {  
			            public void valueChanged(ListSelectionEvent e) {  
			               Object object = campo_lista.getSelectedValue();
			               

			               try {

			                    BufferedReader in = new BufferedReader(new FileReader((String) object));
			                    String str, texto = "";
			                    while((str = in.readLine()) != null){
			                        texto += str + "\n";
			                    }

		                    	campo1.setText(texto);

			                    in.close();
			                 }
			               catch (IOException ioe){
			                    // possiveis erros s�o tratatos aqui
			                 }
			               
//			               campo1.setText((String) object);  
			            }  
			         });
		 	
		 
		crawl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				apaga_lista();
					
//				 pesquisa = new String (campo_url.getText());
//				
//				for(int i =0; i!=lista_12.length;i++){
//					ProcuraFicheiro2.retira_encontradas();
//					
//				System.out.println(lista_12[i]);
//				
//				ProcuraFicheiro2.Palav(pesquisa);
//
//				ProcuraFicheiro2.lerFicheiro(lista_12[i]);
//				ProcuraFicheiro2.lerToken();
				
				File user = new File(campo_url.getText());
				Indexa��o ind = new Indexa��o();
				ind.indexaFicheiros(user);
				poe_Na_Lista(ind.findSourcesForWord("rato"));
//				try {
//                    BufferedReader in = new BufferedReader(new FileReader(lista_12[i]));
//                    String str, texto = "";
//                    while((str = in.readLine()) != null){
//                        texto += str + "\n";
//                    }
//                    if(ProcuraFicheiro2.encontradas>0){
////                    	campo1.setText(texto);
//                    	  poe_Na_Lista(lista_12[i]);
//
//                    }
//
// 
//                    in.close();
//                 } 
//                 catch (IOException ioe){
//                    // possiveis erros s�o tratatos aqui
//                 }
		//	}
                 

//                 poe_Na_Lista(pesquisa);

				janela.getContentPane().validate();

				if ((ProcuraFicheiro2.encontradas != 0))
					ProcuraFicheiro2.encontradas--;
			}
		});
		

		// item.addActionListener(actionListener);
		menu1.add(exit);
		menu2.add(open);
		menu2.add(save);
		menu2.add(reset);

		// Install the menu bar in the frame
		// ContentPane.setJMenuBar(menuBar);
		janela.setJMenuBar(menuBar);

	}

	public void poe_Na_Lista(HashSet<String> item){
		if(!item.isEmpty()){
			Iterator<String> it = item.iterator();
			while(it.hasNext()){
				model.addElement(it.next());
				campo_lista.setSelectedIndex(campo_lista.getModel().getSize() - 1);
			}
		}
		else
			System.out.println("Null");
	}
	public void apaga_lista(){
		if(!model.isEmpty())
			model.removeAllElements();
	}
	
	public void executa() {

		janela.setVisible(true);
	}

	public static void main(String[] args) {

		Grafico interfaceGr�fica = new Grafico();
		interfaceGr�fica.executa();

	}

}
