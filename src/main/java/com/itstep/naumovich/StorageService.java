package com.itstep.naumovich;

import java.util.Collection;

/**
 * Created by admin on 05.02.2019.
 */
public interface StorageService<T> {

    String save(T object);

    T read(String id);

    void delete(String id);

    Collection<T> readAll();

    void deleteAll();

}
