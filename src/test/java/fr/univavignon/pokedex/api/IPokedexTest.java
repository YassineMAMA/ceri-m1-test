package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

public class IPokedexTest {

	private int size;
	private int indice;
	private Answer<Object> answerSize;
	private Answer<Object> answerIndice;

	@Mock
	private IPokedex IPokedexTestMock;

	Pokemon pokemonBulbizarre;
	Pokemon pokemonAquali;
	List<Pokemon> pokemonListByName;
	List<Pokemon> pokemonListByIndex;
	List<Pokemon> pokemonListByCp;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	// TODO
	@Before
	public void setUp() throws PokedexException {

		size = 0;
		answerSize = new Answer<Object>() {
			public Object answer(InvocationOnMock invocation) {
				return size;
			}
		};

		indice = -1;
		answerIndice = new Answer<Object>() {
			public Object answer(InvocationOnMock invocation) {
				return indice;
			}
		};

		// create 2 pokemons
		pokemonBulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		pokemonAquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

		// create Answer for size() method
		when(IPokedexTestMock.size()).thenAnswer(answerSize);

		// create Answer for addPokemon() method with indice
		when(IPokedexTestMock.addPokemon(pokemonAquali)).thenAnswer(answerIndice);
		when(IPokedexTestMock.addPokemon(pokemonBulbizarre)).thenAnswer(answerIndice);
		
		when(IPokedexTestMock.getPokemon(0)).thenReturn(pokemonBulbizarre);
		when(IPokedexTestMock.getPokemon(1)).thenReturn(pokemonAquali);
		when(IPokedexTestMock.getPokemon(-1)).thenThrow(new PokedexException("No pokemon find at -1"));
		
		pokemonListByName = new ArrayList<Pokemon>();
		pokemonListByName.add(pokemonAquali);
		pokemonListByName.add(pokemonBulbizarre);
		when(IPokedexTestMock.getPokemons(PokemonComparators.NAME)).thenReturn(pokemonListByName);
		
		pokemonListByIndex = new ArrayList<Pokemon>();
		pokemonListByIndex.add(pokemonBulbizarre);
		pokemonListByIndex.add(pokemonAquali);
		when(IPokedexTestMock.getPokemons()).thenReturn(pokemonListByIndex);
		when(IPokedexTestMock.getPokemons(PokemonComparators.INDEX)).thenReturn(pokemonListByIndex);
		
		pokemonListByCp = pokemonListByName;//on fait pointer vers une liste identique
		when(IPokedexTestMock.getPokemons(PokemonComparators.CP)).thenReturn(pokemonListByCp);
	}

	@Test
	public void testAddPokemon() {
		assertEquals(indice, addNewPokemon(pokemonBulbizarre)); //index = 0
		assertEquals(indice, addNewPokemon(pokemonAquali)); //index = 1
	}
	
	@Test
	public void testSizePokedex() {
		// before size=0
		assertEquals(size, IPokedexTestMock.size());
		addNewPokemon(pokemonBulbizarre);
		// before size=1
		assertEquals(1, IPokedexTestMock.size());
		addNewPokemon(pokemonAquali);
		// before size=2
		assertEquals(2, IPokedexTestMock.size());
	}
	
	@Test
	public void testGetPokemon() throws PokedexException {
		Pokemon bul = IPokedexTestMock.getPokemon(0);
		
		assertEquals(pokemonBulbizarre.getAttack(), bul.getAttack());
		assertEquals(pokemonBulbizarre.getDefense(), bul.getDefense());
		assertEquals(pokemonBulbizarre.getIndex(), bul.getIndex());
		assertEquals(pokemonBulbizarre.getName(), bul.getName());
		assertEquals(pokemonBulbizarre.getStamina(), bul.getStamina());
		assertEquals(pokemonBulbizarre.getIv(), bul.getIv(), 0.001);
		assertEquals(pokemonBulbizarre.getCandy(), bul.getCandy());
		assertEquals(pokemonBulbizarre.getCp(), bul.getCp());
		assertEquals(pokemonBulbizarre.getDust(), bul.getDust());
		assertEquals(pokemonBulbizarre.getHp(), bul.getHp());
		
		
		Pokemon aqu = IPokedexTestMock.getPokemon(1);
		
		assertEquals(pokemonAquali.getAttack(), aqu.getAttack());
		assertEquals(pokemonAquali.getDefense(), aqu.getDefense());
		assertEquals(pokemonAquali.getIndex(), aqu.getIndex());
		assertEquals(pokemonAquali.getName(), aqu.getName());
		assertEquals(pokemonAquali.getStamina(), aqu.getStamina());
		assertEquals(pokemonAquali.getIv(), aqu.getIv(), 0.001);
		assertEquals(pokemonAquali.getCandy(), aqu.getCandy());
		assertEquals(pokemonAquali.getCp(), aqu.getCp());
		assertEquals(pokemonAquali.getDust(), aqu.getDust());
		assertEquals(pokemonAquali.getHp(), aqu.getHp());
	}
	
	@Test(expected=PokedexException.class)
	public void testPokedexException() throws PokedexException   {
		IPokedexTestMock.getPokemon(-1);	
	}
		
	@Test
	public void testGetPokemons() throws PokedexException {
		List<Pokemon> list = IPokedexTestMock.getPokemons();
		Pokemon bul = list.get(0);
		
		assertEquals(pokemonBulbizarre.getAttack(), bul.getAttack());
		assertEquals(pokemonBulbizarre.getDefense(), bul.getDefense());
		assertEquals(pokemonBulbizarre.getIndex(), bul.getIndex());
		assertEquals(pokemonBulbizarre.getName(), bul.getName());
		assertEquals(pokemonBulbizarre.getStamina(), bul.getStamina());
		assertEquals(pokemonBulbizarre.getIv(), bul.getIv(), 0.001);
		assertEquals(pokemonBulbizarre.getCandy(), bul.getCandy());
		assertEquals(pokemonBulbizarre.getCp(), bul.getCp());
		assertEquals(pokemonBulbizarre.getDust(), bul.getDust());
		assertEquals(pokemonBulbizarre.getHp(), bul.getHp());
		
		
		Pokemon aqu = list.get(1);
		
		assertEquals(pokemonAquali.getAttack(), aqu.getAttack());
		assertEquals(pokemonAquali.getDefense(), aqu.getDefense());
		assertEquals(pokemonAquali.getIndex(), aqu.getIndex());
		assertEquals(pokemonAquali.getName(), aqu.getName());
		assertEquals(pokemonAquali.getStamina(), aqu.getStamina());
		assertEquals(pokemonAquali.getIv(), aqu.getIv(), 0.001);
		assertEquals(pokemonAquali.getCandy(), aqu.getCandy());
		assertEquals(pokemonAquali.getCp(), aqu.getCp());
		assertEquals(pokemonAquali.getDust(), aqu.getDust());
		assertEquals(pokemonAquali.getHp(), aqu.getHp());
	}
	
	@Test
	public void testGetPokemonsComparator() throws PokedexException {
		List<Pokemon> listName = IPokedexTestMock.getPokemons(PokemonComparators.NAME);
		List<Pokemon> listIndex = IPokedexTestMock.getPokemons(PokemonComparators.INDEX);
		List<Pokemon> listCp = IPokedexTestMock.getPokemons(PokemonComparators.CP);
		
		//verify size of lists
		assertEquals(listName.size(), listIndex.size());
		assertEquals(listName.size(), listCp.size());
		assertEquals(listIndex.size(), listCp.size());
		
		//verify each elements with their attribute
		for (int i = 0; i < listName.size(); i++) {
			assertEquals(pokemonListByName.get(i).getName(), listName.get(i).getName());
			assertEquals(pokemonListByIndex.get(i).getIndex(), listIndex.get(i).getIndex());
			assertEquals(pokemonListByCp.get(i).getCp(), listCp.get(i).getCp());
		}
		
	}
	
	
	/**
	 * Method for add Pokemon and change the size
	 * 
	 * @param p
	 * @return
	 */
	public int addNewPokemon(Pokemon p) {
		int id = IPokedexTestMock.addPokemon(p);
		size++;
		indice++;
		return id;
	}

}
