package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;



public class IPokemonMetadataProviderTest {
	
	@Mock private IPokemonMetadataProvider pokemonMetadataProvider;
	private PokemonMetadata aqualiMetaData = new PokemonMetadata(133, "Aquali", 186, 168, 260);
    
	@Before
	public void setUp() throws PokedexException{
		
		MockitoAnnotations.initMocks(this);

		Mockito.when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(aqualiMetaData);
		Mockito.when(pokemonMetadataProvider.getPokemonMetadata(151)).thenThrow(new PokedexException("Index superieur a 150"));
		Mockito.when(pokemonMetadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Index neagtive"));

	}
	
	
	@Test
	public void testPokemonMetadata() throws PokedexException{
		
		assertEquals(aqualiMetaData.getIndex(), pokemonMetadataProvider.getPokemonMetadata(133).getIndex());
		assertEquals(aqualiMetaData.getName(), pokemonMetadataProvider.getPokemonMetadata(133).getName());
		assertEquals(aqualiMetaData.getAttack(), pokemonMetadataProvider.getPokemonMetadata(133).getAttack());
		assertEquals(aqualiMetaData.getDefense(), pokemonMetadataProvider.getPokemonMetadata(133).getDefense());
		assertEquals(aqualiMetaData.getStamina(), pokemonMetadataProvider.getPokemonMetadata(133).getStamina());

	}
	
	@Test(expected = PokedexException.class)
	public void indexOverrideExceptionTest() throws PokedexException {	
		pokemonMetadataProvider.getPokemonMetadata(151);
	}
	
	@Test(expected = PokedexException.class)
	public void negativeIndexTest() throws PokedexException {		
		pokemonMetadataProvider.getPokemonMetadata(-1);
	}
}
 