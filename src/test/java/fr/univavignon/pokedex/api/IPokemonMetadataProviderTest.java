package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class IPokemonMetadataProviderTest {
	
	private PokemonMetadata pokemonMetadataBulbizarre;
	private PokemonMetadata pokemonMetadataAquali;
	@Mock private IPokemonMetadataProvider iPokemonMetadataProvider;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
    public void setUp() throws PokedexException  {
		MockitoAnnotations.initMocks(this);
		
		//create 2 pokemons
		pokemonMetadataBulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
		pokemonMetadataAquali = new PokemonMetadata(133, "Aquali", 186, 168, 260);
	
		//create return
		when(iPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadataBulbizarre);
		when(iPokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(pokemonMetadataAquali);
		when(iPokemonMetadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("No pokemon find at -1"));
    }

	@Test
	public void testGetBulbizarre() throws PokedexException {
		PokemonMetadata bul = iPokemonMetadataProvider.getPokemonMetadata(0);
		
		assertEquals(pokemonMetadataBulbizarre.getAttack(), bul.getAttack());
		assertEquals(pokemonMetadataBulbizarre.getDefense(), bul.getDefense());
		assertEquals(pokemonMetadataBulbizarre.getIndex(), bul.getIndex());
		assertEquals(pokemonMetadataBulbizarre.getName(), bul.getName());
		assertEquals(pokemonMetadataBulbizarre.getStamina(), bul.getStamina());
	}
	
	@Test
	public void testGetAquali() throws PokedexException {
		PokemonMetadata aqu = iPokemonMetadataProvider.getPokemonMetadata(133);
		
		assertEquals(pokemonMetadataAquali.getAttack(), aqu.getAttack());
		assertEquals(pokemonMetadataAquali.getDefense(), aqu.getDefense());
		assertEquals(pokemonMetadataAquali.getIndex(), aqu.getIndex());
		assertEquals(pokemonMetadataAquali.getName(), aqu.getName());
		assertEquals(pokemonMetadataAquali.getStamina(), aqu.getStamina());
	}
	
	@Test(expected=PokedexException.class)
	public void testPokedexException() throws PokedexException   {
		iPokemonMetadataProvider.getPokemonMetadata(-1);	
	}
}
