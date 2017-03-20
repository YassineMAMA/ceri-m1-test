package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class IPokemonMetadataProviderTest {
	
	private PokemonMetadata pokemonMetadataBulbizarre;
	private PokemonMetadata pokemonMetadataAquali;
	@Mock private IPokemonMetadataProvider IPokemonMetadataProviderMock;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
    public void setUp() throws PokedexException  {
		
		pokemonMetadataBulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
		pokemonMetadataAquali = new PokemonMetadata(133, "Aquali", 186, 168, 260);
	
		when(IPokemonMetadataProviderMock.getPokemonMetadata(0)).thenReturn(pokemonMetadataBulbizarre);
		when(IPokemonMetadataProviderMock.getPokemonMetadata(133)).thenReturn(pokemonMetadataAquali);
		when(IPokemonMetadataProviderMock.getPokemonMetadata(-1)).thenThrow(new PokedexException("No pokemon find at -1"));

    }

	@Test
	public void testGetBulbizarre() throws PokedexException {
		PokemonMetadata bul = IPokemonMetadataProviderMock.getPokemonMetadata(0);
		
		assertEquals(pokemonMetadataBulbizarre.getAttack(), bul.getAttack());
		assertEquals(pokemonMetadataBulbizarre.getDefense(), bul.getDefense());
		assertEquals(pokemonMetadataBulbizarre.getIndex(), bul.getIndex());
		assertEquals(pokemonMetadataBulbizarre.getName(), bul.getName());
		assertEquals(pokemonMetadataBulbizarre.getStamina(), bul.getStamina());
	}
	
	@Test
	public void testGetAquali() throws PokedexException {
		PokemonMetadata aqu = IPokemonMetadataProviderMock.getPokemonMetadata(0);
		
		assertEquals(pokemonMetadataBulbizarre.getAttack(), aqu.getAttack());
		assertEquals(pokemonMetadataBulbizarre.getDefense(), aqu.getDefense());
		assertEquals(pokemonMetadataBulbizarre.getIndex(), aqu.getIndex());
		assertEquals(pokemonMetadataBulbizarre.getName(), aqu.getName());
		assertEquals(pokemonMetadataBulbizarre.getStamina(), aqu.getStamina());
	}
	
	@Test(expected=PokedexException.class)
	public void testPokedexException() throws PokedexException   {
		IPokemonMetadataProviderMock.getPokemonMetadata(-1);	
	}
	
}
