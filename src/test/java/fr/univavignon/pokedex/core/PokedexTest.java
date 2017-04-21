package fr.univavignon.pokedex.core;

import org.junit.Before;

import fr.univavignon.pokedex.api.IPokedexTest;

public class PokedexTest extends IPokedexTest {
	
	/**
	 * setup
	 */
	@Before
    public void setUp()   {
		//create pokemon metadata provider
		this.setiPokedexTest(new Pokedex());
		
		//les pokemons sont créer dans chaque tests car il faut pouvoir tester les tailles et lse indices
    }

}
