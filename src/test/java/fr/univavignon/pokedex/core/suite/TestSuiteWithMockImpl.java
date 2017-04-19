package fr.univavignon.pokedex.core.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.univavignon.pokedex.core.PokemonMetadataProviderTest;
import fr.univavignon.pokedex.core.WhenSearchingForDrupalUsingGoogleTest;

@RunWith(Suite.class)

/**
 * Test suite with mock
 * @author adrie
 *
 */
@Suite.SuiteClasses({PokemonMetadataProviderTest.class, 
					WhenSearchingForDrupalUsingGoogleTest.class
})

public class TestSuiteWithMockImpl { }
