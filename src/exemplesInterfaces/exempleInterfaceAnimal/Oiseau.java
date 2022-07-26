package exemplesInterfaces.exempleInterfaceAnimal;

public class Oiseau implements IAnimal {
	private String chant;
	private String sorte;
	private String typeDeBec;

	public Oiseau (String chant, String sorte, String typeBec) {
		this.chant = chant;
		this.sorte = sorte;
		this.typeDeBec = typeBec;
	}

	public void seDeplacer() {
		System.out.println("Je vole !");
	}

	public void sIdentifier() {
		System.out.println("Je suis un(e) " + sorte + 
				" et mon bec est " + typeDeBec);
	}

	public void communiquer() {
		System.out.println(chant);
	}
}
