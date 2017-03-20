package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;
public class IPokedexTest {
	
	@Mock private IPokedex IPokedexTestMock;
	private int size = 0;
	Pokemon pokemonMockBulbizarre;
	Pokemon pokemonMockAquali;

	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	//TODO
	@Before
    public void setUp() throws PokedexException  {
		
		pokemonMockBulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		pokemonMockAquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
		
		when(IPokedexTestMock.size()).thenAnswer(new Answer<Object>() {
		     public Object answer(InvocationOnMock invocation) {
		         return size;
		     }
		 });
    }

	@Test
	public void testSizePokedex()  {
		assertEquals(size, IPokedexTestMock.size());
		addNewPokemon(pokemonMockBulbizarre);
		assertEquals(1, IPokedexTestMock.size());
		
		//verifie que l'objet est non null
		//assertNotNull(IPokedexFactoryMock.createPokedex(IPokemonMetadataProviderMock, pokemonFactoryMock));
	}
	
	
	public int addNewPokemon(Pokemon p){
		int id = IPokedexTestMock.addPokemon(p);
		size++;
		return id;
	}
	
}
