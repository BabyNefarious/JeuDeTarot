package tarot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Joueur 
{
	private String nom;
	private int score;
	private List<Carte> main;
	private List<Carte> plis;
	
	Joueur(String nom)
	{
		this.nom = nom;
		this.main = new ArrayList<Carte>(18);
		this.plis = new ArrayList<Carte>(78);
		this.score = 0;
	}

	public List<Carte> getMain() {
		return main;
	}

	public void setMain(List<Carte> main) {
		this.main = main;
	}

	// setters et getters
	public String getNom() 
	{
		return nom;
	}

	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	

	public int getScore() 
	{
		return score;
	}

	public void setScore(int score) 
	{
		this.score = score;
	}
	

	public List<Carte> getPlis() 
	{
		return plis;
	}

	public void setPlis(List<Carte> plis) 
	{
		this.plis = plis;
	}
	
	public List<Carte> listeCouleur(Carte.Couleur couleur)
	{
		List<Carte> liste_couleur = new ArrayList<Carte>();
		for(Carte carteEnCours: main)
		{
			if (carteEnCours.getCouleur() == couleur)
			{
				liste_couleur.add(carteEnCours);
			}
		}
		return liste_couleur;
	}
	
	// Affiche la main d'un joueur avec nombre de joueur = 4
	public void afficherMain()
	{
		System.out.print("\nmain du joueur: " + this.nom + "\n\n\n");
		int i;
		for(i = 0; i < 18; i++)
			System.out.print("carte:\n" + getMain().get(i) );
		
	}
	
	public void effacerMain()
	{
		this.main.clear();
	}
	
	public void rangeMain()
	{
		List<Carte> listeAtouts = listeCouleur(Carte.Couleur.ATOUT);
	}
	
	public int calculScore() 
	{
		for(Carte carteEnCours: plis)
		{
			this.score += carteEnCours.getPoints();
		}
		return score;
	}
	
}
