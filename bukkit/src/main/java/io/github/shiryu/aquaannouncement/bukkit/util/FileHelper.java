package io.github.shiryu.aquaannouncement.bukkit.util;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.*;

public class FileHelper {

    private static FileHelper instance;

    private FileHelper(){

    }

    @NotNull
    public File getFile(@NotNull String name, @NotNull final File file){

        if (!name.endsWith(".yml")) name = name + ".yml";

        if (file == null) return null;
        if (file.listFiles() == null) return null;

        for (File fileli : file.listFiles()){
            if (fileli.getName().equals(name)){
                return fileli;
            }
        }

        return null;
    }

    @NotNull
    public File createDirectoryIfDoNotExists(@NotNull final String name, @NotNull final File directory){
        File file = new File(directory + "/" + name + "/");

        if (!file.exists()){
            file.mkdirs();
        }

        return file;
    }

    @NotNull
    public File createFileIfDoNotExists(@NotNull final String name, @NotNull final File directory){
        File file = new File(directory, name);

        if (!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        return file;
    }

    @NotNull
    public FileConfiguration loadFile(@NotNull final File file){
        return YamlConfiguration.loadConfiguration(file);
    }

    @NotNull
    public <T> T getValue(@NotNull final File file, @NotNull final  String path){
        FileConfiguration config = loadFile(file);

        return (T)config.get(path);
    }

    public void setValue(@NotNull final File file, @NotNull final String path, @NotNull final Object object){
        FileConfiguration config = loadFile(file);

        config.set(path, object);

        saveFile(file, config);
    }


    public void saveFile(@NotNull final File file, @NotNull final FileConfiguration configuration){
        try{
            configuration.save(file);
            configuration.load(file);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static synchronized FileHelper getInstance(){
        if (instance == null) instance = new FileHelper();

        return instance;
    }
}
