package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

public class Grafico extends JFrame {

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

	JLabel espaço;

	JList campo1;
	JList campo2;
	JList campo3;

	public Grafico() {

		// definições básicas da janela

		janela = new JFrame("PCD Google by Nagios Team");
		janela.setSize(1500, 800);
		janela.setResizable(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(new FlowLayout());

		// definição das Labels e acréscimo destas à janela

		texto_pesquisa = new JLabel("Campo de Pesquisa: ");
		texto_pesquisa.setLayout((new BorderLayout()));
		url = new JLabel("URL");
		num_crw = new JLabel("# of crawlers");
		prof_crw = new JLabel("Crawl Dept");
		espaço = new JLabel("   ");
		separador = new JSeparator();

		campo1 = new JList();
		campo1.setPreferredSize(new java.awt.Dimension(900, 500));

		campo2 = new JList();
		campo2.setPreferredSize(new java.awt.Dimension(250, 500));

		campo3 = new JList();
		campo3.setPreferredSize(new java.awt.Dimension(1200, 150));

		// definição dos campos de texto e acréscimo à janela

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

		// definição do botão Crawl e acréscimo

		// menu

		menubar = new JMenuBar();
		ficheiro = new JMenu("Ficheiro");
		index = new JMenu("Index");

		janela.add(texto_pesquisa);
		janela.add(campo_pesquisa);
		janela.add(separador);

		janela.add(url);
		janela.add(campo_url);
		janela.add(espaço);

		janela.add(num_crw);
		janela.add(campo_num_crw);
		janela.add(espaço);

		janela.add(prof_crw);
		janela.add(campo_prof);
		janela.add(crawl);

		janela.add(campo1);

		janela.add(barra1);

		janela.add(campo2);
		janela.add(barra2);

		janela.add(barra4);

		janela.add(campo3);
		janela.add(barra3);

		menubar.setVisible(true);

		// A partir daqui é que coloquei o código do Menu
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
				JTextField x = new JTextField("OLLO");
				x.requestFocus();
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

		// item.addActionListener(actionListener);
		menu1.add(exit);
		menu2.add(open);
		menu2.add(save);
		menu2.add(reset);

		// Install the menu bar in the frame
		// ContentPane.setJMenuBar(menuBar);
		janela.setJMenuBar(menuBar);

	}

	public void executa() {

		janela.setVisible(true);
	}

	public static void main(String[] args) {

		Grafico interfaceGráfica = new Grafico();
		interfaceGráfica.executa();

	}

}
