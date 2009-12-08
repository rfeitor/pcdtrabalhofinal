package gui;

import index.Indexação;

import java.awt.BorderLayout;
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
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Grafico extends JFrame {

	BufferedReader f = null;

	DefaultListModel model = new DefaultListModel();

	String[] lista;
	int x = 0;

	String pesquisa;

	String[] lista_12;

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

	// TODO deixei isto aqui só para confirmar que isto era mesmo para apagar
	// JScrollBar barra1;
	// JScrollBar barra2;
	// JScrollBar barra3;
	// JScrollBar barra4;
	JScrollPane painel_lista, painel_texto, painel_consola;

	JLabel espaço;

	JTextArea campo_texto;
	// JTextField campo1;
	// JList campo_texto = new JList(listagem);
	JList campo_lista = new JList(model);
	JTextArea campo_consola;

	ListSelectListener list_listener;
	ActListener sentinela;

	public Grafico() {

		// definições básicas da janela

		janela = new JFrame("PCD Google by Nagios Team");
		janela.setSize(1300, 800);
		janela.setResizable(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(new FlowLayout());
		janela.setExtendedState(MAXIMIZED_BOTH);

		// definição das Labels e acréscimo destas à janela

		texto_pesquisa = new JLabel("Campo de Pesquisa: ");
		texto_pesquisa.setLayout((new BorderLayout()));
		url = new JLabel("URL");
		num_crw = new JLabel("# of crawlers");
		prof_crw = new JLabel("Crawl Dept");
		espaço = new JLabel("   ");
		separador = new JSeparator();

		lista_12 = new String[] { "a.txt", "b.txt", "c.txt", "dica" };

		lista = new String[] { "A", "B", "C" };
		// campo_texto = new JList(lista);
		campo_texto = new JTextArea();
		campo_texto.setPreferredSize(new java.awt.Dimension(900, 500));

		campo_lista = new JList(model);
		campo_lista.setPreferredSize(new java.awt.Dimension(250, 500));
		campo_lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		campo_lista.setSelectedIndex(-1);
		campo_lista.setLayoutOrientation(JList.VERTICAL);

		campo_consola = new JTextArea();
		campo_consola.setPreferredSize(new java.awt.Dimension(1200, 150));

		// definição dos campos de texto e acréscimo à janela

		campo_pesquisa = new JTextField(30);
		campo_url = new JTextField(30);
		campo_num_crw = new JTextField(2);
		campo_prof = new JTextField(2);

		crawl = new JButton("CRAWL");

		painel_lista = new JScrollPane();
		painel_lista.setPreferredSize(new java.awt.Dimension(250, 500));
		painel_lista.getViewport().setView(campo_lista);
		painel_texto = new JScrollPane();
		painel_texto.setPreferredSize(new java.awt.Dimension(900, 500));
		painel_texto.getViewport().setView(campo_texto);
		painel_consola = new JScrollPane();
		painel_consola.setPreferredSize(new java.awt.Dimension(1200, 150));
		painel_consola.getViewport().setView(campo_consola);

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

		janela.add(painel_texto);
		janela.add(painel_lista);
		janela.add(painel_consola);

		menubar.setVisible(true);

		// TODO inicializacao das sentinelas
		list_listener = new ListSelectListener();
		sentinela = new ActListener();

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

		campo_lista.addListSelectionListener(list_listener);
		crawl.addActionListener(sentinela);
		campo_pesquisa.addActionListener(sentinela);
		campo_url.addActionListener(sentinela);

		// item.addActionListener(actionListener);
		menu1.add(exit);
		menu2.add(open);
		menu2.add(save);
		menu2.add(reset);

		// Install the menu bar in the frame
		// ContentPane.setJMenuBar(menuBar);
		janela.setJMenuBar(menuBar);

	}

	public void tira_da_lista() {
		if (!model.isEmpty()) {
			model.removeAllElements();
			campo_lista.removeListSelectionListener(list_listener);
		}
	}

	public void poe_Na_Lista(HashSet<String> item) {
		try {
			if (!item.isEmpty()) {
				Iterator<String> it = item.iterator();
				while (it.hasNext()) {
					model.addElement(it.next());
				}
			}
		} catch (NullPointerException e) {
			// TODO Isto é a pedreiro, mas pelo menos não rebenta :-P
			campo_texto.setText("Nenhum ficheiro encontrado");
		}
	}

	private class ListSelectListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			// TODO Auto-generated method stub
			if (arg0.getSource() == campo_lista) {
				if (!campo_lista.isSelectionEmpty()) {
					try {
						BufferedReader br = new BufferedReader(new FileReader(
								campo_lista.getSelectedValue().toString()));
						String text = "";
						String text2 = null;
						while ((text2 = br.readLine()) != null)
							text += text2 + "\n";
						campo_texto.setText(text);
						br.close();
					} catch (IOException io) {
						// TODO Possíveis erros são tratados aqui
					}
				}
			}
		}

	}

	private class ActListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (arg0.getSource() == crawl || arg0.getSource() == campo_pesquisa
					|| arg0.getSource() == campo_url)
				if (campo_pesquisa.getText() != null
						&& campo_url.getText() != null) {
					tira_da_lista();
					campo_lista.addListSelectionListener(list_listener);
					File user_dir = new File(campo_url.getText());
					Indexação ind = new Indexação();
					ind.indexaFicheiros(user_dir);
					if (ind.getFileAvailable())
						poe_Na_Lista(ind.findSourcesForWord(campo_pesquisa
								.getText()));
					else
						campo_texto.setText("FILE NOT AVAILABLE");
						janela.getContentPane().validate();
				} else
					// TODO não esta a funcionar
					campo_texto.setText("BURRO FALTA PREENCHER UM CAMPO");
		}

	}

	public void executa() {

		janela.setVisible(true);
	}

	public static void main(String[] args) {
		Grafico interfaceGráfica = new Grafico();
		interfaceGráfica.executa();

	}
}
