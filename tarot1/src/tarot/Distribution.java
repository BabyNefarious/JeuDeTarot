package tarot;
import java.util.List;

public interface Distribution 
{
	public List<Carte> getCartes();
	public void distribue(); // random;
	//public void distribue(Joueur dealer);
	public void melanger();
	public void addCartes(List<Carte> p1Cards, List<Carte> joueur2Cartes,
			List<Carte> joueur3Cards, List<Carte> joueur4Cards,
			List<Carte> chien);
	
	public void cut(int i);

}
