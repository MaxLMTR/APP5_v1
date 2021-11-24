import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.* ;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
	public class MaFenetre extends JFrame implements ActionListener{
		public static void main (String args[]) {
			new MaFenetre(); 
			}
		
		
		private static final long serialVersionUID = 1L;
		private JPanel menu_pan, pan_creer_client, pan_creer_med, pan_afficher_client, pan_remplir_stock, pan_traiter_achat;
		private JButton bouton_titre, bouton_creer_client, bouton_creer_med, bouton_affiche_client, bouton_remplir_stock, bouton_traiter_achat,
		bouton_ajt_client, bouton_ajt_med, bouton_valider_afficher_client, bouton_ajt_stock, bouton_ajt_achat;
		private JLabel nom_lab, prenom_lab, adresse_lab, num_tel_lab, num_secu_soc_lab, ref_lab, libelle_lab, description_lab, prix_lab, quantite_lab,
		attention_nb_secu_soc, stock_lab;
		JTextField nom_txt, prenom_txt, num_secu_soc_txt, adresse_txt, num_tel_txt, ref_txt, libelle_txt,
		description_txt, prix_txt, quantite_txt, stock_txt;
		JOptionPane client_cree, infos_client, infos_ajt_stock, achat_valide;
		private static JComboBox<String> choix_med = new JComboBox<>();
		private static ArrayList<Client> liste_clients = new ArrayList<Client>();
		private static ArrayList<Medicament> liste_tous_medicament = new ArrayList<Medicament>();
		private Color rouge = new Color(140, 0, 0); private Color vert =new Color(235, 255, 235);
		private Color vert_1 = new Color(227, 247, 221); private Color rouge_l =new Color(255, 201, 201);
		private ImageIcon img_client = new ImageIcon(new ImageIcon("icones/client.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		private ImageIcon img_med = new ImageIcon(new ImageIcon("icones/medicament.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		private ImageIcon img_stock = new ImageIcon(new ImageIcon("icones/stock.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		private ImageIcon img_achat = new ImageIcon(new ImageIcon("icones/achat.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		private ImageIcon img_afficher = new ImageIcon(new ImageIcon("icones/afficher.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		private ImageIcon img_liste_achat = new ImageIcon(new ImageIcon("icones/liste_achat.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		private ImageIcon img_pharmacie = new ImageIcon(new ImageIcon("icones/pharmacie.png").getImage().getScaledInstance(380, 90, Image.SCALE_DEFAULT));
		
		public MaFenetre(){
			JFrame menu = new JFrame();  menu.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);  
			menu.setTitle("Gestion Clients & Medicaments");  menu.setSize(400, 800);
			menu_pan = new JPanel();  menu_pan.setLayout(new GridLayout(8,8));
			
			//affichage du titre
			bouton_titre = new JButton(""); bouton_titre.setBorderPainted(false); bouton_titre.setBackground(Color.WHITE);;
			bouton_titre.setVerticalTextPosition(JLabel.CENTER); bouton_titre.setIcon(img_pharmacie);
			//Creer client
			bouton_creer_client = new JButton("Creer un client"); set_bouton(bouton_creer_client);
			bouton_creer_client.setIcon(img_client);
			//Creer medicament
			bouton_creer_med = new JButton("Creer un medicament"); set_bouton(bouton_creer_med);
			bouton_creer_med.setIcon(img_med);
			//Remplir le stock d'un medicament
			bouton_remplir_stock = new JButton("Remplir le stock d'un medicament"); set_bouton(bouton_remplir_stock);
			bouton_remplir_stock.setIcon(img_stock);
			//Traiter un achat
			bouton_traiter_achat = new JButton("Traiter un achat"); set_bouton(bouton_traiter_achat);
			bouton_traiter_achat.setIcon(img_achat);
			//Afficher un client
			bouton_affiche_client = new JButton("Afficher un client"); set_bouton(bouton_affiche_client);
			bouton_affiche_client.setIcon(img_afficher);
		
			menu_pan.add(bouton_titre);     menu_pan.add(bouton_traiter_achat);  menu_pan.add(bouton_creer_client);  
			menu_pan.add(bouton_creer_med); menu_pan.add(bouton_remplir_stock);  menu_pan.add(bouton_affiche_client);
		
			menu.getContentPane().add(menu_pan); 
			menu.setLocationRelativeTo(null);
			menu.setVisible(true);
			}
		
			@Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource() == bouton_creer_client) {
				JFrame frame_creer_client = new JFrame ();  frame_creer_client.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
				frame_creer_client.setTitle("Ajouter client");  frame_creer_client.setSize(500, 220);
				pan_creer_client= new JPanel () ;
				
				nom_lab = new JLabel ("Nom : ");  nom_txt = new JTextField();  nom_txt.setColumns(16);
				
				prenom_lab = new JLabel ("Prenom :");  prenom_txt = new JTextField();  prenom_txt.setColumns(16);
				
				num_secu_soc_lab = new JLabel("Numero securite sociale :"); num_secu_soc_txt = new JTextField(); num_secu_soc_txt.setColumns(28);
				entre_0_et_9_only(num_secu_soc_txt);
				
				adresse_lab = new JLabel("Adresse : "); adresse_txt = new JTextField(); adresse_txt.setColumns(36);
				
				num_tel_lab = new JLabel("Numero de telephone :"); num_tel_txt = new JTextField(); num_tel_txt.setColumns(12);
				entre_0_et_9_only(num_tel_txt);
				
				bouton_ajt_client = new JButton ("Ajouter");  bouton_ajt_client.addActionListener(this);
				
				appuyer_entrer(bouton_ajt_client, nom_txt);  appuyer_entrer(bouton_ajt_client, prenom_txt);
				appuyer_entrer(bouton_ajt_client, num_secu_soc_txt);  appuyer_entrer(bouton_ajt_client, adresse_txt);
				appuyer_entrer(bouton_ajt_client, num_tel_txt);
				
				attention_nb_secu_soc = new JLabel("Le numero de securite sociale doit etre compose d'au moins 13 caracteres.");
				attention_nb_secu_soc.setForeground(rouge);
				
				pan_creer_client.add(nom_lab);         pan_creer_client.add(nom_txt);          pan_creer_client.add(prenom_lab);
				pan_creer_client.add(prenom_txt);      pan_creer_client.add(num_secu_soc_lab); pan_creer_client.add(num_secu_soc_txt);
				pan_creer_client.add(adresse_lab);     pan_creer_client.add(adresse_txt);  pan_creer_client.add(num_tel_lab);
				pan_creer_client.add(num_tel_txt);     pan_creer_client.add(bouton_ajt_client); pan_creer_client.add(attention_nb_secu_soc); 
				
				pan_creer_client.setBackground(vert_1);  frame_creer_client.getContentPane().add(pan_creer_client);
				frame_creer_client.setLocationRelativeTo(null);  frame_creer_client.setVisible(true);
			}
			if (e.getSource() == bouton_ajt_client) {
				try {
					champ_vide(nom_txt.getText());            champ_vide(prenom_txt.getText());
					champ_vide(num_secu_soc_txt.getText());   champ_vide(adresse_txt.getText()); champ_vide(num_tel_txt.getText());
					try {
						verif_num_secu_soc(num_secu_soc_txt.getText());
						try {
							verif_num_secu_soc_occupe(num_secu_soc_txt.getText());
							color_pane(vert_1);
							int valid_creer_client = JOptionPane.showConfirmDialog(null, "Nom : "+ nom_txt.getText() + "\nPrenom : "+ prenom_txt.getText() + 
										"\nNumero securite sociale : "+ num_secu_soc_txt.getText() + "\nAdresse : " + adresse_txt.getText() + "\nNumero de telephone : " + num_tel_txt.getText()
										+"\n\nVoulez-vous valider ?", "Demande de validation creation client", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, img_client);
							if(valid_creer_client == JOptionPane.YES_OPTION){
								Client client = new Client (num_secu_soc_txt.getText(), num_tel_txt.getText(), nom_txt.getText(), prenom_txt.getText(), 
											adresse_txt.getText(), new ArrayList<Medicament>());
								client_cree = new JOptionPane();
								color_pane(vert);
								JOptionPane.showMessageDialog(null, "Le client a bien ete cree !", "Information",JOptionPane.INFORMATION_MESSAGE, img_client);
								liste_clients.add(client);
							}
						}catch(Exception_num_secu_soc_occupe occupe) {}
					}catch(Exception_verif_num_secu_soc num_secu_soc) {}
				}catch(Exception_champ_vide champ) {}}
			
			if (e.getSource() == bouton_creer_med) {
				JFrame frame_creer_med = new JFrame ();  frame_creer_med.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
				frame_creer_med.setTitle("Ajouter medicament");  frame_creer_med.setSize(400, 220);
				pan_creer_med= new JPanel () ;
				
				ref_lab = new JLabel ("Reference :");  ref_txt = new JTextField();  ref_txt.setColumns(26);
				
				libelle_lab = new JLabel ("Libelle : ");  libelle_txt = new JTextField();  libelle_txt.setColumns(28);
				
				description_lab = new JLabel("Description :  "); description_txt = new JTextField(); description_txt.setColumns(25);
			
				prix_lab = new JLabel("Prix () : "); prix_txt = new JTextField(); prix_txt.setColumns(5);
				entre_0_et_9_only(prix_txt);
				
				quantite_lab = new JLabel("Quantite medicaments par boite :"); quantite_txt = new JTextField(); quantite_txt.setColumns(4);
				entre_0_et_9_only(quantite_txt);
				
				stock_lab = new JLabel("Quantite boites (stock) :"); stock_txt = new JTextField(); stock_txt.setColumns(12);
				entre_0_et_9_only(stock_txt);
				
				bouton_ajt_med = new JButton ("Ajouter");  bouton_ajt_med.addActionListener(this);
				
				appuyer_entrer(bouton_ajt_med, ref_txt);  appuyer_entrer(bouton_ajt_med, libelle_txt);
				appuyer_entrer(bouton_ajt_med, description_txt);  appuyer_entrer(bouton_ajt_med, prix_txt);
				appuyer_entrer(bouton_ajt_med, quantite_txt); appuyer_entrer(bouton_ajt_med, stock_txt);
				
				pan_creer_med.add(ref_lab);        pan_creer_med.add(ref_txt);         pan_creer_med.add(libelle_lab);
				pan_creer_med.add(libelle_txt);    pan_creer_med.add(description_lab); pan_creer_med.add(description_txt);
				pan_creer_med.add(prix_lab);       pan_creer_med.add(prix_txt);        pan_creer_med.add(quantite_lab);
				pan_creer_med.add(quantite_txt);   pan_creer_med.add(stock_lab) ;      pan_creer_med.add(stock_txt) ;
				pan_creer_med.add(bouton_ajt_med); 
				
				pan_creer_med.setBackground(vert_1);  frame_creer_med.getContentPane().add(pan_creer_med);
				frame_creer_med.setLocationRelativeTo(null);  frame_creer_med.setVisible(true);
			}
			if (e.getSource() == bouton_ajt_med) {
				try {
					champ_vide(ref_txt.getText());  champ_vide(libelle_txt.getText());  champ_vide(description_txt.getText());
					champ_vide(prix_txt.getText()); champ_vide(quantite_txt.getText()); champ_vide(stock_txt.getText());
					color_pane(vert_1);
					try {
						med_existe_deja(ref_txt.getText());
						int valid_creer_med = JOptionPane.showConfirmDialog(null, "Reference : "+ ref_txt.getText() + "\nLibelle : "+ libelle_txt.getText()  
								+"\nDescription : "+ description_txt.getText() + "\nPrix : " + prix_txt.getText() + "\nQuantite medicaments : " + quantite_txt.getText()
								+"\n\nVoulez-vous valider ?", "Demande de validation creation medicament", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, img_med);
						if(valid_creer_med == JOptionPane.YES_OPTION){
							Medicament medicament = new Medicament (ref_txt.getText(), libelle_txt.getText(), description_txt.getText(), Double.parseDouble(prix_txt.getText()), 
									Integer.parseInt(quantite_txt.getText()), Integer.parseInt(stock_txt.getText()));
							client_cree = new JOptionPane();
							color_pane(vert);
							JOptionPane.showMessageDialog(null, "Le médicament a été ajouté !", "Information",JOptionPane.INFORMATION_MESSAGE, img_med);
							liste_tous_medicament.add(medicament);
						}
					}catch(Exception_med_deja_existe med) {}
				}catch(Exception_champ_vide champ) {}}
			
			if (e.getSource() == bouton_affiche_client) {
				try {
					client_med_vide();
					JFrame frame_afficher_client = new JFrame ();
					frame_afficher_client.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
					frame_afficher_client.setTitle("Afficher Client");
					frame_afficher_client.setSize(400, 100);
					pan_afficher_client = new JPanel () ;
	
					num_secu_soc_lab = new JLabel ("Numero securite sociale :");  num_secu_soc_txt = new JTextField();  num_secu_soc_txt.setColumns(15);
					entre_0_et_9_only(num_secu_soc_txt);
					
					bouton_valider_afficher_client = new JButton ("Afficher");
					bouton_valider_afficher_client.addActionListener(this);
					appuyer_entrer(bouton_valider_afficher_client, num_secu_soc_txt);
					
					pan_afficher_client.add(num_secu_soc_lab);  pan_afficher_client.add(num_secu_soc_txt);
					pan_afficher_client.add(bouton_valider_afficher_client);
					
					pan_afficher_client.setBackground(vert_1);
					frame_afficher_client.getContentPane().add(pan_afficher_client);
					frame_afficher_client.setLocationRelativeTo(null);
					frame_afficher_client.setVisible(true);
					}catch(Exception_client_med_vide vide) {}
				}
	
			if (e.getSource() == bouton_valider_afficher_client) {
				try {
					champ_vide(num_secu_soc_txt.getText());
					try {
						verif_num_secu_soc(num_secu_soc_txt.getText());
						try {
							verif_num_secu_soc_appartient(num_secu_soc_txt.getText());
							String infos = "\nLes information du clients Numero securite sociale: "+num_secu_soc_txt.getText()+" sont : ";
							for(int i = 0; i<liste_clients.size(); i++) {
								if(liste_clients.get(i).getNum_securite_sociale().equals(num_secu_soc_txt.getText())) {
									infos = infos + "\nNom : " + liste_clients.get(i).getNom() + ", Prenom : "+ liste_clients.get(i).getPrenom()
											+ ". \nAdresse : " + liste_clients.get(i).getAdresse() +"\nNumero telephone: " + liste_clients.get(i).getNum_tel();
									infos = infos + "\n\nListe des achats effectués : ";
									for(int j = 0; j<liste_clients.get(i).getListe_Achats().size(); j++) {
										infos = infos + "\n Reference : " + liste_clients.get(i).getListe_Achats().get(j).getReference() 
												+ " | Libelle : " + liste_clients.get(i).getListe_Achats().get(j).getLibelle()
												+ " | Quantite achetee : " + liste_clients.get(i).getListe_Achats().get(j).getStock()
												+ " | Prix : " + liste_clients.get(i).getListe_Achats().get(j).getPrix()+ "  "
												+ "\n                                                                         "
												+ "Total : " + liste_clients.get(i).getListe_Achats().get(j).getStock()
												                         *liste_clients.get(i).getListe_Achats().get(j).getPrix()+ "  ";
									}
									infos_client = new JOptionPane();
									color_pane(vert_1);
									JOptionPane.showMessageDialog(null, infos, "Information", JOptionPane.INFORMATION_MESSAGE, img_liste_achat);
								}}
						}catch(Exception_num_secu_soc_appartient num_secu_soc) {}
					}catch(Exception_verif_num_secu_soc num_secu_soc) {}
				}catch(Exception_champ_vide champ) {}}
			
			if (e.getSource() == bouton_remplir_stock) {
				JFrame frame_remplir_stock = new JFrame ();  frame_remplir_stock.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
				frame_remplir_stock.setTitle("Remplir stock");  frame_remplir_stock.setSize(400, 140);
				pan_remplir_stock= new JPanel () ;
				
				ref_lab = new JLabel ("Reference :");  ref_txt = new JTextField();  ref_txt.setColumns(26);
				
				stock_lab = new JLabel("Quantite boites à ajouter (stock) :"); stock_txt = new JTextField(); stock_txt.setColumns(15);
				entre_0_et_9_only(stock_txt);
				
				bouton_ajt_stock = new JButton ("Ajouter");  bouton_ajt_stock.addActionListener(this);
				
				appuyer_entrer(bouton_ajt_stock, ref_txt);  appuyer_entrer(bouton_ajt_stock, stock_txt);
				
				pan_remplir_stock.add(ref_lab);         pan_remplir_stock.add(ref_txt);  
				pan_remplir_stock.add(stock_lab);       pan_remplir_stock.add(stock_txt);
				pan_remplir_stock.add(bouton_ajt_stock); 
				
				pan_remplir_stock.setBackground(vert_1);  frame_remplir_stock.getContentPane().add(pan_remplir_stock);
				frame_remplir_stock.setLocationRelativeTo(null);  frame_remplir_stock.setVisible(true);
			}
			if (e.getSource() == bouton_ajt_stock) {
				try {
					champ_vide(ref_txt.getText()); champ_vide(stock_txt.getText()); 
					for (int i =0; i<liste_tous_medicament.size(); i++) {
						if(liste_tous_medicament.get(i).getReference().equals(ref_txt.getText())){
							liste_tous_medicament.get(i).setStock(liste_tous_medicament.get(i).getStock() 
									                               + Integer.parseInt(stock_txt.getText()));
							infos_ajt_stock = new JOptionPane();
							color_pane(vert_1);
							JOptionPane.showMessageDialog(null, "Le stock a ete mis a jour", "Information", JOptionPane.INFORMATION_MESSAGE, img_stock);
						}
						else {
							infos_ajt_stock = new JOptionPane();
							infos_client = new JOptionPane();
							color_pane(rouge_l);
							int valid_creer_med = JOptionPane.showConfirmDialog(null, "Ce médicament n'existe pas, voulez vous le rajouter?", "Demande de création médicament", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, img_client);
							if(valid_creer_med == JOptionPane.YES_OPTION){
								bouton_creer_med.doClick();}}}
				}catch(Exception_champ_vide vide) {}
			}
			if (e.getSource() == bouton_traiter_achat) {
				try {
					client_med_vide();
					JFrame frame_traiter_achat = new JFrame ();  frame_traiter_achat.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
					frame_traiter_achat.setTitle("Achat");  frame_traiter_achat.setSize(400, 140);
					pan_traiter_achat= new JPanel () ;
					
					ArrayList<String> liste_medicament = new ArrayList<String>();
					for(int j = 0; j<liste_tous_medicament.size(); j++) {
						String nom_med = liste_tous_medicament.get(j).getLibelle() + ", Réf.: " + liste_tous_medicament.get(j).getReference();
						liste_medicament.add(nom_med);}
					
					choix_med.setModel(new DefaultComboBoxModel(liste_medicament.toArray()));
					
					num_secu_soc_lab = new JLabel ("Numero securite sociale :");  num_secu_soc_txt = new JTextField();  num_secu_soc_txt.setColumns(20);
					entre_0_et_9_only(num_secu_soc_txt);
					
					quantite_lab = new JLabel("Quantite : "); quantite_txt = new JTextField(); quantite_txt.setColumns(28);
					entre_0_et_9_only(quantite_txt);
					
					bouton_ajt_achat = new JButton ("Effectuer");  bouton_ajt_achat.addActionListener(this);
					
					appuyer_entrer(bouton_ajt_achat, quantite_txt);
					
					pan_traiter_achat.add(num_secu_soc_lab);   pan_traiter_achat.add(num_secu_soc_txt);  
					pan_traiter_achat.add(quantite_lab);       pan_traiter_achat.add(quantite_txt);  
					pan_traiter_achat.add(choix_med);          pan_traiter_achat.add(bouton_ajt_achat);
					
					pan_traiter_achat.setBackground(vert_1);  frame_traiter_achat.getContentPane().add(pan_traiter_achat);
					frame_traiter_achat.setLocationRelativeTo(null);  frame_traiter_achat.setVisible(true);
				}catch(Exception_client_med_vide vide2) {}
			}
			if (e.getSource() == bouton_ajt_achat) {
				try {
					champ_vide(num_secu_soc_txt.getText()); champ_vide(quantite_txt.getText());
					try {
						verif_num_secu_soc_appartient(num_secu_soc_txt.getText());
						try {
							verif_stock(Integer.parseInt(quantite_txt.getText()));
							
							int indice = choix_med.getSelectedIndex();
							for(int i =0; i<liste_clients.size();i++) {
								if(liste_clients.get(i).getNum_securite_sociale().equals(num_secu_soc_txt.getText())) {
									Medicament achat = new Medicament(liste_tous_medicament.get(indice).getReference(), 
											liste_tous_medicament.get(indice).getLibelle(), 
											liste_tous_medicament.get(indice).getDescription(), 
											liste_tous_medicament.get(indice).getPrix(), 
											liste_tous_medicament.get(indice).getQuantite(), 
											Integer.parseInt(quantite_txt.getText()));
									liste_tous_medicament.get(indice).setStock( liste_tous_medicament.get(indice).getStock() 
											- Integer.parseInt(quantite_txt.getText()));
									liste_clients.get(i).getListe_Achats().add(achat);
									achat_valide = new JOptionPane();
									color_pane(vert);
									JOptionPane.showMessageDialog(null, "Achat validé !\n Total à payer : "
									+(liste_tous_medicament.get(indice).getPrix())*(Integer.parseInt(quantite_txt.getText()))+ " "
									, "Information",JOptionPane.INFORMATION_MESSAGE, img_achat);
									
									}}
						}catch(Exception_stock_vide stock) {}
					}catch(Exception_num_secu_soc_appartient secu) {}
				}catch(Exception_champ_vide champ2) {}
			}
			
		}
				

		private void set_bouton(JButton bouton) {
			bouton.setBorderPainted(false);
			bouton.setHorizontalTextPosition(JLabel.CENTER);
			bouton.setVerticalTextPosition(JLabel.BOTTOM);
			bouton.addActionListener(this);}
		
		private void entre_0_et_9_only(JTextField txt) {
			txt.addKeyListener(new KeyAdapter() {
			    public void keyTyped(KeyEvent e) {
			        char c = e.getKeyChar();
			        if ( ((c < '0') || (c > '9') ) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.')) {
			             e.consume();}}});}
		
		private void color_pane(Color couleur) {
			UIManager.put("OptionPane.background", couleur);
			UIManager.put("Panel.background", couleur);}
		
		private void appuyer_entrer(JButton bouton, JTextField zone) {
			zone.addKeyListener(new KeyListener() {
				public void keyTyped(KeyEvent evt) {}
				public void keyPressed(KeyEvent evt) {
					if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
						bouton.doClick();}}public void keyReleased(KeyEvent e) {}});;}
		
		private void verif_num_secu_soc(String num_secu_soc) throws Exception_verif_num_secu_soc {
			if (num_secu_soc.length() > 13) {
				throw new Exception_verif_num_secu_soc();}}
		
		private void champ_vide(String champ)throws Exception_champ_vide{
			if (champ.equals("")) {
				throw new Exception_champ_vide();}}
		
		private void med_existe_deja(String libelle) throws Exception_med_deja_existe {
			for(int i=0; i<liste_tous_medicament.size(); i++) {
				if (libelle.equals(liste_tous_medicament.get(i).getReference())){
					throw new Exception_med_deja_existe();}}}
			
		private void verif_num_secu_soc_occupe(String num_secu_soc) throws Exception_num_secu_soc_occupe{
			ArrayList<String> liste_num_secu_soc = new ArrayList<>();
			for(int j = 0; j<liste_clients.size(); j++) {
				liste_num_secu_soc.add(liste_clients.get(j).getNum_securite_sociale());}
			if( liste_num_secu_soc.contains(num_secu_soc)) {
				throw new Exception_num_secu_soc_occupe();}}
		
		private void verif_num_secu_soc_appartient(String num_secu_soc) throws Exception_num_secu_soc_appartient{
			ArrayList<String> liste_num_secu_soc = new ArrayList<>();
			for(int j = 0; j<liste_clients.size(); j++) {
				liste_num_secu_soc.add(liste_clients.get(j).getNum_securite_sociale());}
			if( !liste_num_secu_soc.contains(num_secu_soc)) {
				throw new Exception_num_secu_soc_appartient();}}
		
		private void client_med_vide() throws Exception_client_med_vide{
			if(liste_clients.size() == 0 || liste_tous_medicament.size() == 0) {
				throw new Exception_client_med_vide();}}
		
		private void verif_stock(int nb_boite) throws Exception_stock_vide{
			int indice = choix_med.getSelectedIndex();
			if(nb_boite > liste_tous_medicament.get(indice).getStock()) {
				throw new Exception_stock_vide();
			}
			
		}
		
		
	}



