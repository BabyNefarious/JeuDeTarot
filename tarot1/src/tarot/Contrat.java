package tarot;

public interface Contrat 
{
	// Calcule la puissance � l'atout en fonction de leur nombre et de leur puissance
	// retourne nombre atouts
	public int calculeAtout();
	
	// indique si il y a des coupes, des longues ou des cinglettes dans chaque couleur
	public void calculeCouleur();
	
	// Calcule la pr�sence ou la possibilit� de cr�er une longue dans chaque couleur
	public boolean calculeLongue(Carte.Couleur couleur);
	
	// Calcule la pr�sence d'une coupe dans une couleur
	public boolean calculeCoupe(Carte.Couleur couleur);
	
	// Calcule la pr�sence d'une cinglette dans une couleur
	public boolean calculeSinglette(Carte.Couleur couleur);
	
	// Calcule le nombre de bouts
	public int calculeBouts();
	
	// Calcule le nombre de points pr�sents dans le jeu
	public int calculePoints();
	
}
