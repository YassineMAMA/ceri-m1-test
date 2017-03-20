package fr.univavignon.pokedex.api.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.univavignon.pokedex.api.IPokedexFactoryTest;
import fr.univavignon.pokedex.api.IPokedexTest;
import fr.univavignon.pokedex.api.IPokemonFactoryTest;
import fr.univavignon.pokedex.api.IPokemonMetadataProviderTest;
import fr.univavignon.pokedex.api.IPokemonTrainerFactoryTest;

@RunWith(Suite.class)

/**
 * Test suite with mock
 * @author adrie
 *
 */
@Suite.SuiteClasses({
   IPokedexFactoryTest.class,
   IPokedexTest.class,
   IPokemonFactoryTest.class,
   IPokemonMetadataProviderTest.class,
   IPokemonTrainerFactoryTest.class
})

public class TestSuiteWithMock { }
