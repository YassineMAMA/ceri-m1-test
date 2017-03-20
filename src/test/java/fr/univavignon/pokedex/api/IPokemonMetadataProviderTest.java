package fr.univavignon.pokedex.api;

import static org.junit.gen5.api.Assertions.assertEquals;

import org.junit.gen5.api.BeforeAll;
import org.junit.gen5.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.runners.MockitoJUnitRunner;

public class IPokemonMetadataProviderTest {
	
	@Mock Pokemon pokemonMock;
	//@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@BeforeAll
    public void setUp() {
		this.pokemonMock = Mockito.mock(Pokemon.class);
		when(pokemonMock.getIndex()).thenReturn(0);
		when(pokemonMock.getName()).thenReturn("Bulbizarre");
		when(pokemonMock.getCp()).thenReturn(613);
		when(pokemonMock.getHp()).thenReturn(64);
		when(pokemonMock.getDust()).thenReturn(4);
		when(pokemonMock.getAttack()).thenReturn(126);
		when(pokemonMock.getDefense()).thenReturn(126);
		when(pokemonMock.getStamina()).thenReturn(90);
		when(pokemonMock.getIv()).thenReturn(new Double(56));
    }

	@Test
	public void testInit() {
		assertEquals(pokemonMock.getName(), "Bulbizarre");
		//IPokemon a = new IPokemon();
	}

}
