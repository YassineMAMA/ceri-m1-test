package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class IPokedexFactoryTest {
	@Mock private IPokedexFactory pokedexFactory;
	@Mock private IPokemonMetadataProvider pkemonMetadataProvider;
	@Mock private IPokemonFactory pokemonFactory;
	@Mock private IPokedex pokedex;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	

	@Before
	public void setUp() throws PokedexException {
		
		MockitoAnnotations.initMocks(this);
		Mockito.when(this.pokedexFactory.createPokedex(this.pkemonMetadataProvider, this.pokemonFactory))
		.thenReturn(this.pokedex);
	}
	
	@Test 
	public void testCreatePokedex() throws PokedexException{
		IPokedex pokedex = this.pokedexFactory.createPokedex(this.pkemonMetadataProvider, this.pokemonFactory);
		assertNotNull(pokedex);
		assertEquals(pokedexFactory.createPokedex(pkemonMetadataProvider, pokemonFactory), pokedex);
	}
}
