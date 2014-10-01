package fr.esiea.addressbook.models;

import java.util.UUID;

public class Id {

	private UUID id;
	
	private Id(UUID id) {
		this.id = id;
	}
	
	public static Id generate() {
		return new Id(UUID.randomUUID());
	}
	
	public static Id fromString(String id) {
		return new Id(UUID.fromString(id));
		
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Id){
			return this.id.compareTo(((Id)obj).id) == 0;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return id.toString();
	}
}
