package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
public class IPokedexTest {
	
	private IPokedex IPokedexMock;
	private Pokemon pokemonMock;
	private Answer<Integer> size;
	//@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
    public void setUp() {
	
		
		
		this.IPokedexMock = Mockito.mock(IPokedex.class);
		//conf dynamique
		when(IPokedexMock.size()).thenReturn(0);//TODO
    }

	@Test
	public void testSize() {
		assertEquals(IPokedexMock.size(), 0);
		//IPokemon a = new IPokemon();
	}
	
	@Test
	public void testSize2() {
		
		when(IPokedexMock.addPokemon(pokemonMock)).thenReturn(0);//TODO
		assertEquals(IPokedexMock.addPokemon(pokemonMock), 0);
		
	}

}
