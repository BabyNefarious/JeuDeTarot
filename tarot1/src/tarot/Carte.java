package tarot;

public interface Carte extends Comparable <Carte>
{
	public enum Couleur {PIQUE, COEUR, CARREAU, TREFLE, ATOUT};
	
	public static final int EXCUSE = 0;
	public static final int VALET = 11;
	public static final int CAVALIER = 12;
	public static final int DAME = 13;
	public static final int ROI = 14;
	
	public Couleur getCouleur();
	public int getPuissance();
	public double getPoints();
	public String toString();
	
}
