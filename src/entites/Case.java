package entites;

import utils.Effet;

public abstract class Case {
	protected int numero;
	protected Effet effet;

	protected Case(int numero, Effet effet) {
		this.numero = numero;
		this.effet = effet;
	}

	public abstract void appliquerEffet(Pirate pirate, Jeu jeu);

	public int getNumero() {
		return numero;
	}

	public Effet getEffet() {
		return effet;
	}

}