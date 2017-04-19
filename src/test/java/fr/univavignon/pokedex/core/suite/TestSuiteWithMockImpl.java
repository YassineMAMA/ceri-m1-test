package fr.univavignon.pokedex.core.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.univavignon.pokedex.api.IPokedexFactoryTest;
import fr.univavignon.pokedex.api.IPokedexTest;
import fr.univavignon.pokedex.api.IPokemonFactoryTest;
import fr.univavignon.pokedex.api.IPokemonMetadataProviderTest;
import fr.univavignon.pokedex.api.IPokemonTrainerFactoryTest;
import fr.univavignon.pokedex.core.PokemonMetadataProviderTest;

@RunWith(Suite.class)

/**
 * Test suite with mock
 * @author adrie
 *
 */
@Suite.SuiteClasses({PokemonMetadataProviderTest.class
})

public class TestSuiteWithMockImpl { }
