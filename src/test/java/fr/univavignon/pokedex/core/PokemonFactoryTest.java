package fr.univavignon.pokedex.core;

import org.junit.Before;

import fr.univavignon.pokedex.api.IPokemonFactoryTest;

public class PokemonFactoryTest extends IPokemonFactoryTest {
	

	
	

	/**
	 * setUp
	 */
	@Before
    public void setUp(){
		
		
		this.setiPokemonFactory(PokemonFactory.getInstance());
		
		//create 2 pokemons en POJO
		//this.setPokemonBulbizarre(new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56));
		//this.setPokemonAquali(new Pokemon(133, "Vaporeon", 186, 168, 260, 1984, 172, 3500, 4, 69));
    
		//les 2 pokemons creer grase à la factory sont dans les tests
	
	}
}