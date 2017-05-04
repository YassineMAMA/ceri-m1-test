package fr.univavignon.pokedex.imp;

import fr.univavignon.pokedex.imp.CalculateIV;

import fr.univavignon.pokedex.api.*;
public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException  {

        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        Pokemon pokemon = null;
        try {
        	PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);
        	double iv = CalculateIV.calculateIV(metadata.getName(),cp,hp,dust,false);

        	pokemon = new Pokemon(index,metadata.getName(),metadata.getAttack(), metadata.getDefense(),metadata.getStamina(),
                    cp,hp,dust,candy,iv);
        } 
        catch (PokedexException e) {
            e.printStackTrace();
        }
        return pokemon;



    }
}