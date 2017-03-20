package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class IPokedexFactoryTest {
	
	@Mock private IPokemonFactory pokemonFactoryMock;
	@Mock private IPokemonMetadataProvider IPokemonMetadataProviderMock;
	@Mock private IPokedexFactory IPokedexFactoryMock;
	
	@Mock private IPokedex IPokedexMock;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
    public void setUp() throws PokedexException  {
		when(IPokedexFactoryMock.createPokedex(IPokemonMetadataProviderMock, pokemonFactoryMock)).thenReturn(IPokedexMock);
    }

	@Test
	public void testCreatePokedex()  {
		//verifie que l'objet est non null
		assertNotNull(IPokedexFactoryMock.createPokedex(IPokemonMetadataProviderMock, pokemonFactoryMock));
	}
	

}
