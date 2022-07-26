package exemplesInterfaces.exempleInterfaceAnimal;

public class Poisson implements IAnimal {

	private String couleur;

	public Poisson (String couleur) {
		this.couleur = couleur;
	}

	public void seDeplacer() {
		System.out.println("Je nage");
	}

	public void sIdentifier() {
		System.out.println("Je suis un poisson " + couleur);
	}

	public void communiquer() {
		System.out.println("...");
	}
}
