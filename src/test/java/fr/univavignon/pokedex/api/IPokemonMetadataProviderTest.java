package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class IPokemonMetadataProviderTest {
	
	private PokemonMetadata pokemonMetadataMockBulbizarre;
	private PokemonMetadata pokemonMetadataMockAquali;
	@Mock private IPokemonMetadataProvider IPokemonMetadataProviderMock;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
    public void setUp() throws PokedexException  {
		
		pokemonMetadataMockBulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
		pokemonMetadataMockAquali = new PokemonMetadata(133, "Aquali", 186, 168, 260);
	
		when(IPokemonMetadataProviderMock.getPokemonMetadata(0)).thenReturn(pokemonMetadataMockBulbizarre);
		when(IPokemonMetadataProviderMock.getPokemonMetadata(133)).thenReturn(pokemonMetadataMockAquali);
		when(IPokemonMetadataProviderMock.getPokemonMetadata(-1)).thenThrow(new PokedexException("no"));

    }

	@Test
	public void testGetBulbizarre() throws PokedexException {
		PokemonMetadata bul = IPokemonMetadataProviderMock.getPokemonMetadata(0);
		
		assertEquals(pokemonMetadataMockBulbizarre.getAttack(), bul.getAttack());
		assertEquals(pokemonMetadataMockBulbizarre.getDefense(), bul.getDefense());
		assertEquals(pokemonMetadataMockBulbizarre.getIndex(), bul.getIndex());
		assertEquals(pokemonMetadataMockBulbizarre.getName(), bul.getName());
		assertEquals(pokemonMetadataMockBulbizarre.getStamina(), bul.getStamina());
	}
	
	@Test
	public void testGetAquali() throws PokedexException {
		PokemonMetadata aqu = IPokemonMetadataProviderMock.getPokemonMetadata(0);
		
		assertEquals(pokemonMetadataMockBulbizarre.getAttack(), aqu.getAttack());
		assertEquals(pokemonMetadataMockBulbizarre.getDefense(), aqu.getDefense());
		assertEquals(pokemonMetadataMockBulbizarre.getIndex(), aqu.getIndex());
		assertEquals(pokemonMetadataMockBulbizarre.getName(), aqu.getName());
		assertEquals(pokemonMetadataMockBulbizarre.getStamina(), aqu.getStamina());
	}
	
	@Test(expected=PokedexException.class)
	public void testPokedexException() throws PokedexException   {
		IPokemonMetadataProviderMock.getPokemonMetadata(-1);	
	}
	
}
