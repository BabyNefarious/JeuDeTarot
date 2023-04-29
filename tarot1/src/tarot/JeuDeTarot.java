package tarot;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import tarot.Carte.Couleur;


public class JeuDeTarot 
{
	private ArrayList<Carte> jeu = new ArrayList<Carte>();

	public JeuDeTarot()
	{
		int i;
		for(i = 0; i < 78; i++)
		{
			switch(i)
			{
				case  0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21:
					Carte nouvel_atout =  new ImplementationCarte(Couleur.ATOUT, i );
					getJeu().add(nouvel_atout);
					break;
				case  22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35:
					Carte nouveau_carreau =  new ImplementationCarte(Couleur.CARREAU, i - 21 );
					getJeu().add(nouveau_carreau);
					break;
				case  36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49:
					Carte nouveau_pique =  new ImplementationCarte(Couleur.PIQUE, i - (21 + 14) );
					getJeu().add(nouveau_pique);
					break;
				case  50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63:
					Carte nouveau_coeur =  new ImplementationCarte(Couleur.COEUR, i - (21 + 2*14) );
					getJeu().add(nouveau_coeur);
					break;
				case  64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77:
					Carte nouveau_trefle =  new ImplementationCarte(Couleur.TREFLE, i - (21 + 3*14) );
					getJeu().add(nouveau_trefle);
					break;
			}
			//System.out.print("nouvelle_carte:\n" + jeu.get(i) );
		}
	}
	public void melangerJeu()
	{
		Collections.shuffle(getJeu());
	}
	
	public void afficherJeu()
	{
		int i;
		for(i = 1; i < 78; i++)
			System.out.print("nouvelle_carte:\n" + getJeu().get(i) );
	}
	public ArrayList<Carte> getJeu() {
		return jeu;
	}
	public void setJeu(ArrayList<Carte> jeu) {
		this.jeu = jeu;
	}
}
