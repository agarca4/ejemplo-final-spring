package mde.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Mixins {
	
	@JsonPropertyOrder({ "fechaNacimiento", "nombreCompleto" })
	@JsonIgnoreProperties(value = { "raza" })
	public static interface Cliente {
		
		@JsonProperty("nombreCompleto")
		abstract String getNombre();
		
	}

}
