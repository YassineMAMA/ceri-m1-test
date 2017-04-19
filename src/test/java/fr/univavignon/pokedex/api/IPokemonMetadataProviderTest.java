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
	
	
	/**
	 * setUp
	 * @throws PokedexException
	 */
	@Before
    public void setUp() throws PokedexException  {
		MockitoAnnotations.initMocks(this);
		
		//create 2 pokemons
		setPokemonMetadataBulbizarre(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
		setPokemonMetadataAquali(new PokemonMetadata(133, "Aquali", 186, 168, 260));
		
		//create return
		when(getiPokemonMetadataProvider().getPokemonMetadata(0)).thenReturn(getPokemonMetadataBulbizarre());
		when(getiPokemonMetadataProvider().getPokemonMetadata(133)).thenReturn(getPokemonMetadataAquali());
		when(getiPokemonMetadataProvider().getPokemonMetadata(-1)).thenThrow(new PokedexException("No pokemon find at -1"));
		when(getiPokemonMetadataProvider().getPokemonMetadata(151)).thenThrow(new PokedexException("No pokemon find at 151"));
    }

	/**
	 * Test des données d'un bulbizarre
	 * @throws PokedexException
	 */
	@Test
	public void testGetBulbizarre() throws PokedexException {
		PokemonMetadata bul = getiPokemonMetadataProvider().getPokemonMetadata(0);
		
		assertEquals(getPokemonMetadataBulbizarre().getAttack(), bul.getAttack());
		assertEquals(getPokemonMetadataBulbizarre().getDefense(), bul.getDefense());
		assertEquals(getPokemonMetadataBulbizarre().getIndex(), bul.getIndex());
		assertEquals(getPokemonMetadataBulbizarre().getName(), bul.getName());
		assertEquals(getPokemonMetadataBulbizarre().getStamina(), bul.getStamina());
	}
	
	/**
	 * Test des données d'un aquali
	 * @throws PokedexException
	 */
	@Test
	public void testGetAquali() throws PokedexException {
		PokemonMetadata aqu = getiPokemonMetadataProvider().getPokemonMetadata(133);
		
		assertEquals(getPokemonMetadataAquali().getAttack(), aqu.getAttack());
		assertEquals(getPokemonMetadataAquali().getDefense(), aqu.getDefense());
		assertEquals(getPokemonMetadataAquali().getIndex(), aqu.getIndex());
		assertEquals(getPokemonMetadataAquali().getName(), aqu.getName());
		assertEquals(getPokemonMetadataAquali().getStamina(), aqu.getStamina());
	}
	
	/**
	 * Test d'une sortie d'index
	 * @throws PokedexException
	 */
	@Test(expected=PokedexException.class)
	public void testPokedexException() throws PokedexException   {
		getiPokemonMetadataProvider().getPokemonMetadata(-1);	
	}
	
	/**
	 * Test d'une sortie d'index
	 * @throws PokedexException
	 */
	@Test(expected=PokedexException.class)
	public void testPokedexException2() throws PokedexException   {
		getiPokemonMetadataProvider().getPokemonMetadata(151);	
	}

	/**
	 * getter pokemonMetadataBulbizarre
	 * @return
	 */
	public PokemonMetadata getPokemonMetadataBulbizarre() {
		return pokemonMetadataBulbizarre;
	}

	/**
	 * setter pokemonMetadataBulbizarre
	 * @param pokemonMetadataBulbizarre
	 */
	public void setPokemonMetadataBulbizarre(PokemonMetadata pokemonMetadataBulbizarre) {
		this.pokemonMetadataBulbizarre = pokemonMetadataBulbizarre;
	}

	/**
	 * getter pokemonMetadataAquali
	 * @return
	 */
	public PokemonMetadata getPokemonMetadataAquali() {
		return pokemonMetadataAquali;
	}
	
	/**
	 * setter pokemonMetadataAquali
	 * @param pokemonMetadataAquali
	 */
	public void setPokemonMetadataAquali(PokemonMetadata pokemonMetadataAquali) {
		this.pokemonMetadataAquali = pokemonMetadataAquali;
	}

	
	/**
	 * getter IPokemonMetadataProvider
	 * @return
	 */
	public IPokemonMetadataProvider getiPokemonMetadataProvider() {
		return iPokemonMetadataProvider;
	}

	/**
	 * setter IPokemonMetadataProvider
	 * @param IPokemonMetadataProvider
	 */
	public void setiPokemonMetadataProvider(IPokemonMetadataProvider iPokemonMetadataProvider) {
		this.iPokemonMetadataProvider = iPokemonMetadataProvider;
	}
}
