package tarot;

import java.util.ArrayList;
import java.util.List;

public class TestTarotOld {

	public static void main(String[] args) 
	{
		JeuDeTarot jeu_de_tarot = new JeuDeTarot();
		//JeuDeTarot jeu_de_tarotneuf = new JeuDeTarot();
		//System.out.println("taille neuf "+ jeu_de_tarotneuf.getJeu().size());
		
		jeu_de_tarot.melangerJeu();
		//jeu_de_tarot.afficherJeu();
		Joueur joueur0 = new Joueur("007");
		Joueur joueur1 = new Joueur("Betise1");
		Joueur joueur2 = new Joueur("Hirsute");
		Joueur joueur3 = new Joueur("Dragon");
		ArrayList<Joueur> liste_joueurs = new ArrayList<Joueur>();
		liste_joueurs.add(joueur0);
		liste_joueurs.add(joueur1);
		liste_joueurs.add(joueur2);
		liste_joueurs.add(joueur3);
		ImplementationDistribution distribution_jeu_de_tarot = new ImplementationDistribution(liste_joueurs, jeu_de_tarot.getJeu() );
		distribution_jeu_de_tarot.distribue();
		ArrayList<Joueur>  test_liste_joueurs = distribution_jeu_de_tarot.getListe_joueurs();
		
		int parties = 0;
		while(parties < 10)
		{
			// On r�affecte le jeu de 78 cartes
			JeuDeTarot jeu_de_tarotneuf = new JeuDeTarot();
			distribution_jeu_de_tarot.setJeu(jeu_de_tarot.getJeu() );
			distribution_jeu_de_tarot.distribue();
			
			distribution_jeu_de_tarot.afficherCannelle();
			
			test_liste_joueurs = distribution_jeu_de_tarot.getListe_joueurs();
			int premier = distribution_jeu_de_tarot.getPremier_joueur();
			System.out.println("fin main-test");
			
			parties++;
			
		}
		
		//contrat.calculeCouleur();
		//contrat.calculePoints();
		
		
		
		
	}

}
