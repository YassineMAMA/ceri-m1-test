package fr.univavignon.pokedex.imp;

import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PokedexTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    private static Pokedex pokD;
    private Pokemon pokM;

   
    @Before
    public void setUp() throws PokedexException {

        PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
        PokemonFactory pokemonFactory = new PokemonFactory();
        pokD = new Pokedex(pokemonMetadataProvider, pokemonFactory);
        pokM = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

    }

    @Test
    public void testPokedex()throws PokedexException {

        assertEquals(0, pokD.size());
        assertNotNull(pokD);
        
        pokD.addPokemon(pokM);
        assertEquals(0, pokD.getPokemon(0).getIndex());
        assertEquals(1, pokD.size());
        
        List<Pokemon> list = pokD.getPokemons();
        assertEquals(pokD.getPokemon(0).getName(), list.get(0).getName());
        assertEquals(pokD.size(), list.size());
        
    }

 
}


