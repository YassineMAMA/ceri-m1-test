package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

public class IPokedexTest {

	private int size;
	private int indice;
	
	private Pokemon pokemonBulbizarre;
	private Pokemon pokemonAquali;
	private List<Pokemon> pokemonListByName;
	private List<Pokemon> pokemonListByIndex;
	private List<Pokemon> pokemonListByCp;

	@Mock private IPokedex iPokedexTest;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

	/**
	 * 
	 * @throws PokedexException
	 */
	@Before
	public void setUp() throws PokedexException {
		MockitoAnnotations.initMocks(this);
		
		//create answer for the size
		size = 0;
		Answer<Object> answerSize = new Answer<Object>() {
			public Object answer(InvocationOnMock invocation) {
				return size;
			}
		};
		//create answer for the indice
		indice = 0;
		Answer<Object> answerIndice = new Answer<Object>() {
			public Object answer(InvocationOnMock invocation) {
				return indice;
			}
		};

		// create 2 pokemons
		pokemonBulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		pokemonAquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

		// create Answer for size() method
		when(iPokedexTest.size()).thenAnswer(answerSize);

		// create Answer for addPokemon() method with indice
		when(iPokedexTest.addPokemon(pokemonBulbizarre)).thenAnswer(answerIndice);
		when(iPokedexTest.addPokemon(pokemonAquali)).thenAnswer(answerIndice);
		
		when(iPokedexTest.getPokemon(0)).thenReturn(pokemonBulbizarre);
		when(iPokedexTest.getPokemon(1)).thenReturn(pokemonAquali);
		when(iPokedexTest.getPokemon(-1)).thenThrow(new PokedexException("No pokemon find at -1"));
		
		//create list for NAME
		pokemonListByName = new ArrayList<Pokemon>();
		pokemonListByName.add(pokemonAquali);
		pokemonListByName.add(pokemonBulbizarre);
		when(iPokedexTest.getPokemons(PokemonComparators.NAME)).thenReturn(pokemonListByName);
		
		//create list for INDEX
		pokemonListByIndex = new ArrayList<Pokemon>();
		pokemonListByIndex.add(pokemonBulbizarre);
		pokemonListByIndex.add(pokemonAquali);
		when(iPokedexTest.getPokemons()).thenReturn(pokemonListByIndex);
		when(iPokedexTest.getPokemons(PokemonComparators.INDEX)).thenReturn(pokemonListByIndex);
		
		//list for CP
		pokemonListByCp = pokemonListByName;//on fait pointer vers une liste identique
		when(iPokedexTest.getPokemons(PokemonComparators.CP)).thenReturn(pokemonListByCp);
	}

	/**
	 * Test de l'ajout de 2 pokemon au pokedex
	 */
	@Test
	public void testAddPokemonIndice() {
		assertEquals(0, addNewPokemon(pokemonBulbizarre)); //index = 0
		assertEquals(1, addNewPokemon(pokemonAquali)); //index = 1
	}
	
	@Test
	public void testSizePokedex() {
		// before size=0
		assertEquals(0, iPokedexTest.size());
		addNewPokemon(pokemonBulbizarre);
		// before size=1
		assertEquals(1, iPokedexTest.size());
		addNewPokemon(pokemonAquali);
		// before size=2
		assertEquals(2, iPokedexTest.size());
	}
	
	@Test
	public void testGetPokemon() throws PokedexException {
		Pokemon bul = iPokedexTest.getPokemon(0);
		
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
		
		
		Pokemon aqu = iPokedexTest.getPokemon(1);
		
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
		iPokedexTest.getPokemon(-1);	
	}
		
	@Test
	public void testGetPokemons() throws PokedexException {
		List<Pokemon> list = iPokedexTest.getPokemons();
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
		List<Pokemon> listName = iPokedexTest.getPokemons(PokemonComparators.NAME);
		List<Pokemon> listIndex = iPokedexTest.getPokemons(PokemonComparators.INDEX);
		List<Pokemon> listCp = iPokedexTest.getPokemons(PokemonComparators.CP);
		
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
	 * Méthode pour ajouter un pokemon, changer la taille et l'indice attendu
	 * Method for add Pokemon and change the size and the indice
	 * Rappel, entre chaque méthode, on renitialise
	 * 
	 * @param p
	 * @return
	 */
	public int addNewPokemon(Pokemon p) {
		int id = iPokedexTest.addPokemon(p);
		size++;
		indice++;
		return id;
	}
}
