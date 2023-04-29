package tarot;

public interface Contrat 
{
	// Calcule la puissance à l'atout en fonction de leur nombre et de leur puissance
	// retourne nombre atouts
	public int calculeAtout();
	
	// indique si il y a des coupes, des longues ou des cinglettes dans chaque couleur
	public void calculeCouleur();
	
	// Calcule la présence ou la possibilité de créer une longue dans chaque couleur
	public boolean calculeLongue(Carte.Couleur couleur);
	
	// Calcule la présence d'une coupe dans une couleur
	public boolean calculeCoupe(Carte.Couleur couleur);
	
	// Calcule la présence d'une cinglette dans une couleur
	public boolean calculeSinglette(Carte.Couleur couleur);
	
	// Calcule le nombre de bouts
	public int calculeBouts();
	
	// Calcule le nombre de points présents dans le jeu
	public int calculePoints();
	
}
