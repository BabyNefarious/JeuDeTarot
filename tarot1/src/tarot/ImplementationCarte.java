package tarot;

public class ImplementationCarte implements Carte
{
	
	private Carte.Couleur couleur;
	private int puissance;
	private double points;

	public ImplementationCarte(Carte.Couleur couleur, int puissance/*, TarotDeck deck*/) 
	{
		this.couleur = couleur;
		this.puissance = puissance;
		if(couleur != Carte.Couleur.ATOUT) 
		{
			if (puissance < 1 || puissance > ROI)
				throw new RuntimeException("Carte innexistante dans un jeu de tarot");
			if(puissance == ROI)
				this.points = 4.5;
			else if (puissance == DAME) 
				this.points = 3.5;
			else if (puissance == CAVALIER) 
				this.points = 2.5;
			else if (puissance == VALET) 
				this.points = 1.5;
			else
				this.points = 0.5;
		}
		else
		{
			if (puissance < 0 || puissance > 21)
				throw new RuntimeException("Atout innexistant dans un jeu de tarot");
			else if (puissance == 0 || puissance == 1 || puissance == 21)
				this.points = 4.5;
			else
				this.points = 0.5;
		}
	}
	
	@Override
	public int compareTo(Carte carte) {
		return this.puissance - carte.getPuissance();
	}

	@Override
	public Couleur getCouleur() {
		return this.couleur;
	}

	@Override
	public int getPuissance() {
		return this.puissance;
	}

	@Override
	public double getPoints() {
		return this.points;
	}
	
	// @Override
	public boolean equals(Carte carte)
	{
		return (puissance == carte.getPuissance() && couleur == carte.getCouleur());
	}
	
	// Convertit une Couleur en String
	private String CouleurToString()
	{
		if (getCouleur() == Carte.Couleur.CARREAU)
			return ("couleur: carreau\n");
		else if (getCouleur() == Carte.Couleur.PIQUE)
			return ("couleur: pique\n");
		else if (getCouleur() == Carte.Couleur.COEUR)
			return ("couleur: coeur\n");
		else if (getCouleur() == Carte.Couleur.TREFLE)
			return ("couleur: trefle\n");
		else
			return ("couleur: atout\n");
	}
	
	public String toString()
	{
		if (couleur != Carte.Couleur.ATOUT){
			if (getPuissance() == 14)
				return (CouleurToString() + "puissance: roi\n" + "points: " + points + "\n\n");
			else if (getPuissance() == 13)
				return (CouleurToString() + "puissance: reine\n" + "points: " + points + "\n\n");
			else if (getPuissance() == 12)
				return (CouleurToString() + "puissance: cavalier\n" + "points: " + points + "\n\n");
			else if (getPuissance() == 11)
				return (CouleurToString() + "puissance: valet\n" + "points: " + points + "\n\n");
			else
				return (CouleurToString() + "puissance: " + puissance + "\n" + "points: " + points + "\n\n");
		}
		else {
			if (puissance == 0)
				return "Excuse\n" + "points: " + points + "\n\n";
			else if (puissance == 1)
				return "Petit\n" + "points: " + points + "\n\n";
			else if (puissance == 21)
				return "21\n" + "points: " + points + "\n\n";
			else
				return (CouleurToString() + "puissance: " + puissance + "\n" + "points: " + points + "\n\n");
		}
	}

}
