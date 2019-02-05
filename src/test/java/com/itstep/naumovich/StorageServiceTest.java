package com.itstep.naumovich;

import com.itstep.naumovich.model.Apple;
import com.itstep.naumovich.model.Fuel;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

/**
 * Created by admin on 05.02.2019.
 */
public class StorageServiceTest {

    @Test
    public void testForApple() {
        StorageService<Apple> appleStore = new GenericStorageService<>(Apple.class);

        Apple written = new Apple("red", 100);
        String id = appleStore.save(written);

        Apple read = appleStore.read(id);

        Assert.assertNotNull(read);
        Assert.assertEquals(read, written);
        appleStore.readAll();
    }

    @Test
    public void testForFuel() {
        StorageService<Fuel> fuelTank = new GenericStorageService<>(Fuel.class);

        Fuel written = new Fuel(102, 1000);
        String id = fuelTank.save(written);

        Fuel read = fuelTank.read(id);

        Assert.assertNotNull(read);
        Assert.assertEquals(read, written);
        fuelTank.deleteAll();
    }

    @Test(expected = ClassCastException.class)
    public void testClassCastException() {
        StorageService<Fuel> fuelTank = new GenericStorageService<>(Fuel.class);
        StorageService<Apple> appleStore = new GenericStorageService<>(Apple.class);
        String id = null;
        try {

            Fuel written = new Fuel(102, 1000);
            id = fuelTank.save(written);

            Apple read = appleStore.read(id);
        } finally {
            appleStore.deleteAll();
        }

    }

    @Test(expected = ClassCastException.class)
    public void testCollectionException() {
        StorageService<Fuel> fuelTank = new GenericStorageService<>(Fuel.class);
        StorageService<Apple> appleStore = new GenericStorageService<>(Apple.class);
        String fuelId = null;
        String appleId = null;
        try {
            Fuel writtenFuel = new Fuel(102, 1000);
            fuelId = fuelTank.save(writtenFuel);


            Apple writtenApple = new Apple("red", 100);
            appleId = appleStore.save(writtenApple);

            Collection<Fuel> fuels = fuelTank.readAll();
        } finally {
            appleStore.deleteAll();
        }
    }


}
