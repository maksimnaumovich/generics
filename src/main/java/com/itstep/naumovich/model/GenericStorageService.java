package com.itstep.naumovich.model;

import com.itstep.naumovich.StorageService;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * Created by admin on 05.02.2019.
 */
public class GenericStorageService<T> implements StorageService<T> {

    @Override
    public String save(T object) {
        String objectIdOnFileSystem = UUID.randomUUID().toString();

        File fileToWrite = new File(objectIdOnFileSystem);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileToWrite))) {
            outputStream.writeObject(object);
            return objectIdOnFileSystem;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public T read(String id) {
        File fileToRead = new File(id);
        if (!fileToRead.exists()) {
            throw new RuntimeException("No such object");
        }

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileToRead))) {
            return (T) is.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {
        File fileToRead = new File(id);  // c://users/naumovich/projects/generics
        if (!fileToRead.exists()) {
            throw new RuntimeException("No such object");
        }
        fileToRead.delete();
    }

    @Override
    public Collection<T> readAll() {
        File fileToScan = new File("./");
        boolean directory = fileToScan.isDirectory();

        if (directory) {
            File[] files = fileToScan.listFiles((file, filename) -> {
                if (file.isDirectory()) {
                    return false;
                }
                return filename.matches("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}");
            });

            List<T> result = new ArrayList<T>();
            for (File toRead : files) {
                result.add(read(toRead.getName()));
            }
            return result;
        } else {
            throw new RuntimeException("Some magic happened");
        }
    }
}
