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
	

	private Pokemon blbi = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
	private Pokemon aqli = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
	private List<Pokemon> pokemonList = new ArrayList<Pokemon>(151);
	

	@Before
	public void setUp() throws PokedexException {
		pokemonList.add(blbi);
		pokemonList.add(aqli);
		Mockito.when(PokedexFactory.createPokedex(MetadataProvider, pokemonFactory)).thenReturn(pokedex);	
		Mockito.when(MetadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0,"Bulbizarre",126,126,90));
		Mockito.when(MetadataProvider.getPokemonMetadata(1)).thenReturn(new PokemonMetadata(133,"Aquali",186,168,260));
		Mockito.when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(blbi);
		Mockito.when(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aqli);
		Mockito.when(pokedex.size()).thenReturn(0);
		Mockito.when(pokedex.addPokemon(blbi)).thenReturn(0);
		Mockito.when(pokedex.addPokemon(aqli)).thenReturn(1);
		Mockito.when(pokedex.getPokemon(0)).thenReturn(blbi);
		Mockito.when(pokedex.getPokemon(1)).thenReturn(aqli);
		Mockito.when(pokedex.getPokemons()).thenReturn(pokemonList);
	}
	
	@Test 
	public void testCreatePokedex() throws PokedexException{
		
		IPokedex pokedexTest = PokedexFactory.createPokedex(MetadataProvider, pokemonFactory);
		assertEquals(0, pokedexTest.size());
		assertEquals(0, pokedexTest.addPokemon(blbi));
		assertEquals(blbi, pokedexTest.getPokemon(0));
		assertEquals(1, pokedexTest.getPokemons().size());
		assertEquals(1, pokedexTest.addPokemon(aqli));
		assertEquals(aqli, pokedexTest.getPokemon(1));
		assertEquals(2, pokedexTest.getPokemons().size());
		
	}
}
