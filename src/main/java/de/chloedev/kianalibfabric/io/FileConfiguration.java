package de.chloedev.kianalibfabric.io;

import org.simpleyaml.configuration.file.YamlFile;

import java.io.File;
import java.io.IOException;

public class FileConfiguration {

    private YamlFile file;

    public FileConfiguration(File file) {
        this.file = new YamlFile(file);
        try {
            this.file.createOrLoad();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T read(Class<T> type, String key, T def) {
        return (T) this.file.get(key, def);
    }

    public FileConfiguration write(String key, Object value, boolean saveToFileNow) {
        this.file.set(key, value);
        if (saveToFileNow) {
            try {
                this.file.save();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }
    
    public YamlFile getFile() {
        return file;
    }
}
