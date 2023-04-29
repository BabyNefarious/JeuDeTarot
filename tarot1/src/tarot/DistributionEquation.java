package tarot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DistributionEquation implements Distribution
{
	
	// Attributs
	
	private ArrayList<Joueur> liste_joueurs;
	private ArrayList<Carte> cannelle;
	private List<Carte> jeu;
	private int compteur_chien;
	private int premier_joueur;
	
	// Constructeur
	
	public DistributionEquation(ArrayList<Joueur> liste_joueurs, ArrayList<Carte> jeu)
	{
		this.liste_joueurs = liste_joueurs;
		this.jeu = jeu;
		cannelle = new ArrayList<Carte>();
		compteur_chien = 0;
	}
	
	// Getters et setters
	
	public ArrayList<Joueur> getListe_joueurs() {
		return liste_joueurs;
	}

	public void setListe_joueurs(ArrayList<Joueur> liste_joueurs) {
		this.liste_joueurs = liste_joueurs;
	}

	public ArrayList<Carte> getCannelle() {
		return cannelle;
	}

	public void setCannelle(ArrayList<Carte> cannelle) {
		this.cannelle = cannelle;
	}

	public List<Carte> getJeu() {
		return jeu;
	}

	public void setJeu(List<Carte> jeu) {
		this.jeu = jeu;
	}

	public int getCompteur_chien() {
		return compteur_chien;
	}

	public void setCompteur_chien(int compteur_chien) {
		this.compteur_chien = compteur_chien;
	}
	
	public int getPremier_joueur() {
		return premier_joueur;
	}

	public void setpremier_joueur(int premier_joueur) {
		this.premier_joueur = premier_joueur;
	}
	
	// Méthodes de l'interface Distribution
	
	@Override
	public List<Carte> getCartes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void distribue() {
		effacerMains();
		effacerChien();
		Random rand = new Random();
		
		int i, chance_cannelle;
		compteur_chien = 0;
		System.out.println("1er joueur: " + liste_joueurs.get(premier_joueur).getNom());
		liste_joueurs.get(premier_joueur).getNom();
		for(i = 0; i < 78; i = i +3)
		{
			chance_cannelle = rand.nextInt(10);
			if(chance_cannelle == 5 && i >= 3 && i < 69 && getCannelle().size() < 6)
				nourrisCannelle(i);
			else if(i > 3 && getCannelle().size() < 6)
				nourrisCannelle(i);
			else
				donne3cartes(liste_joueurs.get( (i - getCannelle().size() )%4), i);
		}
		if(premier_joueur == liste_joueurs.size() - 1 )
			premier_joueur = 0;
		else
			premier_joueur++;
		
	}

	@Override
	public void melanger() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCartes(List<Carte> p1Cards, List<Carte> joueur2Cartes, List<Carte> joueur3Cards,
			List<Carte> joueur4Cards, List<Carte> chien) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cut(int i) {
		// TODO Auto-generated method stub
		
	}
	
	// Méthodes locales
	
	// Donne la carte d'indice i et les 2 cartes suivantes au chien
	public void donne3cartes(Joueur cible, int i)
	{
		cible.getMain().add(jeu.get(i) );
		cible.getMain().add(jeu.get(i+1) );
		cible.getMain().add(jeu.get(i+2) );
	}
	
	// Ajoute 3 cartes au chien avec une chance de 1/10 entre la carte 3 et la carte 72
	// Si le chien n'est pas fini à la carte 72, termine le chien
	public void nourrisCannelle(int i)
	{
		/*Random rand = new Random();
		int chance_cannelle;
		chance_cannelle = rand.nextInt(10);
		if(chance_cannelle != 5 && i < 72)
		{
			return ;
		}*/
		
		//System.out.println("\nnourris chien" + "\ncompteur_chien: " + compteur_chien + "\nchance_cannelle: " + chance_cannelle +"\ni" + i);
		getCannelle().add(jeu.get(i) );
		getCannelle().add(jeu.get(i+1) );
		getCannelle().add(jeu.get(i+2) );
		compteur_chien++;		
	}
	
	// Affichage du chien
	public void afficherCannelle() 
	{
		int i;
		System.out.print("\n\nchien:\n\n");
		for(i = 0; i < getCannelle().size(); i++)
			System.out.print("carte:\n" + getCannelle().get(i) );
	}
	
	// Efface la main de chaque joueur
	// Appel avant chaque nouvelle distribution
	private void effacerMains() 
	{
		for(Joueur joueur: liste_joueurs)
			joueur.effacerMain();	
	}
	
	// Efface le chien
	// Appel avant chaque nouvelle distribution
	private void effacerChien() 
	{
		cannelle.clear();	
	}
}
