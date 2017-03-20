package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

public class IPokemonMetadataProviderTest {
	
	private PokemonMetadata pokemonMetadataMockBulbizarre;
	private PokemonMetadata pokemonMetadataMockAquali;
	@Mock private IPokemonMetadataProvider IPokemonMetadataProviderMock;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
    public void setUp() throws PokedexException  {
		
		pokemonMetadataMockBulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
		pokemonMetadataMockAquali = new PokemonMetadata(133, "Aquali", 186, 168, 260);
		
		//IPokemonMetadataProviderMock = Mockito.mock(IPokemonMetadataProvider.class);
	
		when(IPokemonMetadataProviderMock.getPokemonMetadata(0)).thenReturn(pokemonMetadataMockBulbizarre);
		when(IPokemonMetadataProviderMock.getPokemonMetadata(133)).thenReturn(pokemonMetadataMockAquali);
	
		
		when(IPokemonMetadataProviderMock.getPokemonMetadata(-1)).thenThrow(new PokedexException("no"));
		
		
		/*try {
			//doThrow(new PokedexException("no")).when(IPokemonMetadataProviderMock.getPokemonMetadata(-1));
		} catch (PokedexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }

	@Test
	public void testGetBulbizarre() {
		try {
			assertEquals(IPokemonMetadataProviderMock.getPokemonMetadata(0), pokemonMetadataMockBulbizarre);
		} catch (PokedexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(expected=PokedexException.class)
	public void testPokedexException() throws PokedexException   {
		
		
		
		IPokemonMetadataProviderMock.getPokemonMetadata(-1);
			
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testIndexOutOfBoundsException() {
	    ArrayList emptyList = new ArrayList();
	    Object o = emptyList.get(0);
	}

}
