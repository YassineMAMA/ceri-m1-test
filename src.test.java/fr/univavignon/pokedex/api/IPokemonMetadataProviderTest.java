package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;


public class IPokemonMetadataProviderTest {
	@Mock private IPokemonMetadataProvider pokemonMetadataProvider;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
	public void setUp() throws PokedexException {
		Mockito.when(pokemonMetadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException(""));
		Mockito.when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0,"Bulbizarre",126,126,90));
		Mockito.when(pokemonMetadataProvider.getPokemonMetadata(151)).thenThrow(new PokedexException(""));
	}
	
	@Test(expected=PokedexException.class)
	public void testPokemonMetadata0NotFoundException() throws PokedexException {
		pokemonMetadataProvider.getPokemonMetadata(-1);
	}

	@Test(expected=PokedexException.class)
	public void testPokemonMetadata151NotFoundException() throws PokedexException {
		pokemonMetadataProvider.getPokemonMetadata(151);
	}
	
	@Test 
	public void testPokemonMetadata() throws PokedexException{
		
	
		PokemonMetadata pokemonMetadataTest = pokemonMetadataProvider.getPokemonMetadata(0);
		
		assertEquals(126,pokemonMetadataTest.getAttack());
		assertEquals(126,pokemonMetadataTest.getDefense());
		assertEquals(0,pokemonMetadataTest.getIndex());
		assertEquals("Bulbizarre",pokemonMetadataTest.getName());
		assertEquals(90,pokemonMetadataTest.getStamina());
	}
}
 