package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
public class IPokemonFactoryTest {
	
	Pokemon pokemonMockBulbizarre;
	Pokemon pokemonMockAquali;
	
	@Mock private IPokemonFactory IPokemonFactoryMock;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
    public void setUp() throws PokedexException  {
		
		pokemonMockBulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		pokemonMockAquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
	
		when(IPokemonFactoryMock.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemonMockBulbizarre);
		when(IPokemonFactoryMock.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(pokemonMockAquali);
    }

	@Test
	public void testGetBulbizarre()  {
		Pokemon bul = IPokemonFactoryMock.createPokemon(0, 613, 64, 4000, 4);
		
		assertEquals(pokemonMockBulbizarre.getAttack(), bul.getAttack());
		assertEquals(pokemonMockBulbizarre.getDefense(), bul.getDefense());
		assertEquals(pokemonMockBulbizarre.getIndex(), bul.getIndex());
		assertEquals(pokemonMockBulbizarre.getName(), bul.getName());
		assertEquals(pokemonMockBulbizarre.getStamina(), bul.getStamina());
		assertEquals(pokemonMockBulbizarre.getIv(), bul.getIv(), 0.001);
		assertEquals(pokemonMockBulbizarre.getCandy(), bul.getCandy());
		assertEquals(pokemonMockBulbizarre.getCp(), bul.getCp());
		assertEquals(pokemonMockBulbizarre.getDust(), bul.getDust());
		assertEquals(pokemonMockBulbizarre.getHp(), bul.getHp());

	
	}
	
	@Test
	public void testGetAquali() {
		Pokemon aqu = IPokemonFactoryMock.createPokemon(133, 2729, 202, 5000, 4);
		
		assertEquals(pokemonMockAquali.getAttack(), aqu.getAttack());
		assertEquals(pokemonMockAquali.getDefense(), aqu.getDefense());
		assertEquals(pokemonMockAquali.getIndex(), aqu.getIndex());
		assertEquals(pokemonMockAquali.getName(), aqu.getName());
		assertEquals(pokemonMockAquali.getStamina(), aqu.getStamina());
		assertEquals(pokemonMockAquali.getIv(), aqu.getIv(), 0.001);
		assertEquals(pokemonMockAquali.getCandy(), aqu.getCandy());
		assertEquals(pokemonMockAquali.getCp(), aqu.getCp());
		assertEquals(pokemonMockAquali.getDust(), aqu.getDust());
		assertEquals(pokemonMockAquali.getHp(), aqu.getHp());
	}

}
