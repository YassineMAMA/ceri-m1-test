package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.util.ArrayList;
import java.util.List;




public class IPokedexFactoryTest {
	@Mock private IPokedexFactory PokedexFactory;
	@Mock private IPokemonMetadataProvider MetadataProvider;
	@Mock private IPokemonFactory pokemonFactory;
	@Mock private IPokedex pokedex;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
	List<Pokemon> pokemonS = new ArrayList<Pokemon>();
	
	@Before
	public void setUp() throws PokedexException {
		pokemonS.add(pokemon);
		Mockito.when(PokedexFactory.createPokedex(MetadataProvider, pokemonFactory)).thenReturn(pokedex);	
		Mockito.when(MetadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0,"Bulbizarre",126,126,90));
		Mockito.when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemon);
		Mockito.when(pokedex.size()).thenReturn(0);
		Mockito.when(pokedex.addPokemon(pokemon)).thenReturn(0);
		Mockito.when(pokedex.getPokemon(0)).thenReturn(pokemon);
		Mockito.when(pokedex.getPokemons()).thenReturn(pokemonS);
	}
	
	@Test 
	public void testCreatePokedex() throws PokedexException{
		
		IPokedex pokedexTest = PokedexFactory.createPokedex(MetadataProvider, pokemonFactory);
		assertEquals(0, pokedexTest.size());
		assertEquals(0, pokedexTest.addPokemon(pokemon));
		assertEquals(pokemon, pokedexTest.getPokemon(0));
		assertEquals(1, pokedexTest.getPokemons().size());
		
	}
}
