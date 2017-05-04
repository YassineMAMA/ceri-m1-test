package fr.univavignon.pokedex.imp;

import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;

public class PokemonFactoryTest {

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    private static PokemonFactory pokemonFactory;


    @Before
    public void setUp() {

        pokemonFactory = new PokemonFactory();
    }


    @Test
    public void testCreatePokemon() throws PokedexException {

		Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
		
		assertEquals(0,pokemon.getIndex());
		assertEquals(613, pokemon.getCp());
		assertEquals(64, pokemon.getHp());
		assertEquals(4000, pokemon.getDust());
		assertEquals(4, pokemon.getCandy());
		assertEquals(56, pokemon.getIv(),0);

    }


}