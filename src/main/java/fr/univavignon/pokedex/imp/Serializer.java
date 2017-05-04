package fr.univavignon.pokedex.imp;

import com.google.gson.Gson;
import fr.univavignon.pokedex.api.PokedexException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;



public interface Serializer {


    String rootPath = System.getProperty("user.home") + "/";
    
/*----création du dossier sil n'existe pas-----*/
    default void initPath(String Dname) {
   
        File dir = new File(rootPath, Dname);
        if (!dir.exists()) {
            dir.mkdirs();
            }
       }

    
/*--------returner le nom de fichier------ */  
    default String getFileName(String path, String name) {
    	
        return rootPath + path + name.toLowerCase() + ".json";
    }
    

/*----------Vérifier si le dossier exisit-------- */
    default Boolean checkFile(String path, String name) {
    	
        File f = new File(this.getFileName(path, name));
        return f.exists() && !f.isDirectory();
    }


/*--------Convertir un objet en fichier json---------*/
    default void persistData(String filename, Object object) {

        try (FileWriter writer = new FileWriter(filename)) {
            Gson gson = new Gson();
            gson.toJson(object, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
/*--------enregistrer les données dans le fichier json------*/
    void saveData(Object object) throws IOException, PokedexException;


/*--------charger les données à partir du fichier json -------*/
    Object loadData(String name) throws FileNotFoundException, PokedexException;
	
}
