package fr.univavignon.pokedex.imp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fr.univavignon.pokedex.api.*;

public class Pokedex implements IPokedex {

    private static final int maxPokemons = 150;

    private PokemonMetadataProvider pokemonMetadataProvider;

    private PokemonFactory pokemonFactory;

    private List<Pokemon> pokemons;

    
    public Pokedex(IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory) {
        this.pokemonMetadataProvider = (PokemonMetadataProvider) pokemonMetadataProvider;
        this.pokemonFactory = (PokemonFactory) pokemonFactory;
        this.pokemons = new ArrayList<Pokemon>();
    }

/*----------nbr pokemons-----*/
    @Override
    public int size() {
        return pokemons.size();
    }

/*-----------ajouter un pokemon------*/    
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.indexOf(pokemon);
    }

/*----------trouver un pokemon by Id----------*/
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {

        if (id < 0 || id > maxPokemons - 1) {
            throw new PokedexException("unvalid Id ");
        }
        Pokemon pokemon = pokemons.get(id);

        return pokemon;
    }

 /*-----------liste des pokemons---------*/
    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

  /*------------ liste des pokemons- dans pokedox-------*/  
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        pokemons.sort(order);
        return Collections.unmodifiableList(pokemons);
    }
/*-----------creer un pokemon---------*/
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        Pokemon pokemon = pokemonFactory.createPokemon(index, cp,hp,dust,candy);
        return pokemon;
    }

/*-------------metadata d'un pokemon by index-------*/   
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
}

}
