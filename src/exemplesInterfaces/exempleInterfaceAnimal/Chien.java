package exemplesInterfaces.exempleInterfaceAnimal;

public class Chien implements IAnimal {

	private String race;
	private int age;
	private String jappement;

	public Chien (String race, int age, String jappement) {
		this.race = race;
		this.age = age;
		this.jappement = jappement;
	}

	public void seDeplacer() {
		System.out.println("Je marche et je cours");
	}

	public void sIdentifier() {
		System.out.println("Je suis un " + race + 
				" et j'ai " + age + " an(s)");
	}

	public void communiquer() {
		System.out.println(jappement);
	}
}
