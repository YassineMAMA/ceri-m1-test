package fr.univavignon.pokedex.imp;

import fr.univavignon.pokedex.api.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;


public class PokemonTrainerFactoryTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private static PokemonTrainerFactory pokemonTrainerFactory;

    private IPokedexFactory pokedexFactory;


    @Before
    public void setUp() {
        pokemonTrainerFactory = new PokemonTrainerFactory();
        pokedexFactory = new PokedexFactory();
    }

    
    @Test
    public void testCreateTrainer() throws PokedexException, IOException {

        PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer("uTG", Team.MYSTIC, pokedexFactory);    
        assertNotNull(pokemonTrainer);
       
        Pokemon pokemon = pokemonTrainer.getPokedex().createPokemon(0, 613, 64, 4000, 4);
        pokemonTrainer.getPokedex().addPokemon(pokemon);
        
        pokemonTrainerFactory.saveData(pokemonTrainer);
        
        TestCase.assertEquals("uTG", pokemonTrainer.getName());
        TestCase.assertEquals(Team.MYSTIC, pokemonTrainer.getTeam());        
        assertNotNull(pokemonTrainer.getPokedex());
    }

}