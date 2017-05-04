package fr.univavignon.pokedex.imp;

import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;

public class PokemonMetadataProviderTest {

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock private static PokemonMetadataProvider pokemonMetadataProvider;


    @Before
    public void setUp() {

        pokemonMetadataProvider = new PokemonMetadataProvider();
    }
    

    @Test
    public void testPokemonMetadata() throws PokedexException {

        PokemonMetadata metadata = null;
                metadata = pokemonMetadataProvider.getPokemonMetadata(133);
                assertEquals(133, metadata.getIndex());
            	pokemonMetadataProvider.getPokemonMetadata(0);
            	pokemonMetadataProvider.getPokemonMetadata(151);
    }

   
  

}