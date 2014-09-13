package co.renegadeeagle.dodgeeagle.entity;

public enum EntityType {

	EAGLE("Eagle"),
	PLAYER("Player");
	String name;
	EntityType(String name){
		this.name = name;
	}
}
