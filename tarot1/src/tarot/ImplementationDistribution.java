package tarot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImplementationDistribution implements Distribution
{
	private ArrayList<Joueur> liste_joueurs;
	private ArrayList<Carte> cannelle;
	private List<Carte> jeu;
	private int premier_joueur;
	private int compteur_chien;
	private ArrayList<Integer> liste_ecart;
	
	//private int nombreJoueurs;
	public ImplementationDistribution(ArrayList<Joueur> liste_joueurs, ArrayList<Carte> jeu)
	{
		this.liste_joueurs = liste_joueurs;
		this.jeu = jeu;
		cannelle = new ArrayList<Carte>();
		premier_joueur = 0;
		liste_ecart = new ArrayList<Integer>();
	}
	
	public ArrayList<Joueur> getListe_joueurs() {
		return liste_joueurs;
	}

	public void setListe_joueurs(ArrayList<Joueur> liste_joueurs) {
		this.liste_joueurs = liste_joueurs;
	}

	public List<Carte> getJeu() {
		return jeu;
	}

	public void setJeu(List<Carte> jeu2) {
		jeu.clear();
		this.jeu = jeu2;
		
		
		//this.jeu = new ArrayList<Carte>(jeu2);
	}

	@Override
	public List<Carte> getCartes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void donne3cartes(Joueur cible, int i)
	{
		cible.getMain().add(jeu.get(i) );
		cible.getMain().add(jeu.get(i+1) );
		cible.getMain().add(jeu.get(i+2) );
	}
	
	public void nourris_cannelle(int i)
	{
		Random rand = new Random();
		int chance_cannelle;
		chance_cannelle = rand.nextInt(10);
		if(chance_cannelle != 5 && i < 72) 
		{
			return ;
		}
		System.out.println("\ncompteur_chien: " + compteur_chien + "\nchance_cannelle: " + chance_cannelle +"\ni" + i);

		System.out.println("nourris chien");
		getCannelle().add(jeu.get(i) );
		this.liste_ecart.add(i);
		getCannelle().add(jeu.get(i+1) );
		this.liste_ecart.add(i+1);
		getCannelle().add(jeu.get(i+2) );
		this.liste_ecart.add(i+2);
		
		compteur_chien++;
		
		
	}

	//Efface les mains de touts les joueurs
	private void effacerMains() {
		for(Joueur joueur: liste_joueurs)
			joueur.effacerMain();	
	}

	//Efface le chien
	private void effacerChien() {
		cannelle.clear();	
	}

	private void retirerChien()
	{
		//for(Integer ichien: liste_ecart)
		//	jeu.remove(ichien.intValue());
		//liste_ecart.clear();
		
		int i;
		for(i = liste_ecart.size(); i == 0; i-- )
			jeu.remove(i);
		
		System.out.println("\njeu éclairci: " + jeu.size());
		
	}
	
	@Override
	public void distribue() {
		effacerMains();
		effacerChien();
		liste_ecart.clear();
		System.out.println("taille jeu 0: " + jeu.size() );
		
		int i;
		compteur_chien = 0;
		System.out.println("1er joueur: " + liste_joueurs.get(premier_joueur).getNom());
		liste_joueurs.get(premier_joueur).getNom();
		for(i = 0; i < 78; i = i +3)
		{
			if( compteur_chien < 2)
			{
				//chance de distribution random au chien
				nourris_cannelle(i);
			}			
		}
		System.out.println("taille chien: " + cannelle.size() );
		System.out.println("taille jeu 1: " + jeu.size() );
		retirerChien();
		for(i = 0; i < 72; i = i +3)
			donne3cartes(liste_joueurs.get(i%4), i);
		if(premier_joueur == liste_joueurs.size() - 1 )
			premier_joueur = 0;
		else
			premier_joueur++;
	}

	public int getPremier_joueur() {
		return premier_joueur;
	}

	public void setpremier_joueur(int premier_joueur) {
		this.premier_joueur = premier_joueur;
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

	public ArrayList<Carte> getCannelle() {
		return cannelle;
	}

	public void setCannelle(ArrayList<Carte> cannelle) {
		this.cannelle = cannelle;
	}
	
	public void afficherCannelle() 
	{
		int i;
		System.out.print("\n\nchien:\n\n");
		for(i = 0; i < 6; i++)
			System.out.print("carte:\n" + getCannelle().get(i) );
	}
	
}
