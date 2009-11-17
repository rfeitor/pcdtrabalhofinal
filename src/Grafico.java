import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;





public class Grafico extends JFrame{
	
	JFrame janela;
	JButton crawl;
	JMenuBar menubar;
	JMenu ficheiro;
	JMenu index;
	JLabel texto_pesquisa;
	JLabel url;
	JLabel number_crawlers;
	JLabel crawl_Depth;
	JTextField texto_a_pesquisar;
	JTextField url2;
	JTextField num_crawlers;
	JTextField crawl_dpt;
	
	public Grafico(){
		
		
		//definições básicas da janela
		
		janela  = new JFrame ("PCD Google by Nagios Team");
		janela.setSize(800,400);
		janela.setResizable(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(new FlowLayout());
		
		
		//definição das Labels e acréscimo destas à janela
		
		texto_pesquisa = new JLabel ("Campo de Pesquisa: ");
		url = new JLabel("URL");
		number_crawlers = new JLabel("# of crawlers");
		
		janela.add(texto_pesquisa);
		janela.add(url);
		janela.add(number_crawlers);
		
		
		
		//definição dos campos de texto e acréscimo à janela
		
		texto_a_pesquisar = new JTextField(50);
		url2 = new JTextField(50);
		num_crawlers = new JTextField (3);
		crawl_dpt = new JTextField(3);
		

		
		
		//definição do botão Crawl e acréscimo
		
		crawl = new JButton ("Crawl!");
		janela.add(crawl);
		
		
		// menu
		
		menubar = new JMenuBar();
		ficheiro = new JMenu("Ficheiro");
		index = new JMenu("Index");
		
		janela.add(ficheiro);
		janela.add(index);
		janela.add(texto_a_pesquisar);
		janela.add(url2);
		janela.add(num_crawlers);
		janela.add(crawl_dpt);
		
		menubar.setVisible(true);
		
		
		// A partir daqui é que coloquei o código do Menu
		JMenuBar menuBar = new JMenuBar();

		// Create a menu
		JMenu menu1 = new JMenu("File");
		JMenu menu2 = new JMenu("Index");
		menuBar.add(menu1);
		menuBar.add(menu2);
	

		// Create a menu item
		JMenuItem item1 = new JMenuItem("Reset Index");
		JMenuItem item2 = new JMenuItem("Open");
		JMenuItem item3 = new JMenuItem("Save");
		JMenuItem item4 = new JMenuItem("Exit");
		
		
		item1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
//				
			}
		});
		item2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JTextField x = new JTextField("OLLO");
				x.requestFocus();
			}
		});
		item3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				janela.setVisible(false);
			}
		});
		
		
		
		
		item4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				janela.setVisible(false);
			}
		});
		
		
		
		
		
//		item.addActionListener(actionListener);
		menu1.add(item4);
		menu2.add(item2);
		menu2.add(item3);
		menu2.add(item1);

		// Install the menu bar in the frame
//		ContentPane.setJMenuBar(menuBar);
		janela.setJMenuBar(menuBar);
		
		
	}
		
		
	
	
	public void executa(){
		
		janela.setVisible(true);
	}
	
	
	
	public static void main (String [] args){
		
		Grafico interfaceGráfica = new Grafico();
		interfaceGráfica.executa();
		
		
		
	}

}


