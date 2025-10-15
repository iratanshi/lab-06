package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City c = new City("Yellowknife", "NW");
        cityList.add(c);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(c);
        });
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City existingCity = new City("Edmonton", "Alberta");
        City nonExistingCity = new City("Vancouver", "British Columbia");

        // Test that the city exists
        assertTrue(cityList.hasCity(existingCity));

        // Test that a city that doesn't exist returns false
        assertFalse(cityList.hasCity(nonExistingCity));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City cityToDelete = new City("Edmonton", "Alberta");

        // Verify city exists before deletion
        assertTrue(cityList.hasCity(cityToDelete));
        assertEquals(1, cityList.countCities());

        // Delete the city
        cityList.delete(cityToDelete);

        // Verify city was removed
        assertFalse(cityList.hasCity(cityToDelete));
        assertEquals(0, cityList.countCities());
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City nonExistingCity = new City("Toronto", "Ontario");

        // Test that deleting a non-existing city throws an exception
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(nonExistingCity);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();

        // Test empty list
        assertEquals(0, cityList.countCities());

        // Add one city
        cityList.add(new City("Calgary", "Alberta"));
        assertEquals(1, cityList.countCities());

        // Add another city
        cityList.add(new City("Montreal", "Quebec"));
        assertEquals(2, cityList.countCities());

        // Add a third city
        cityList.add(new City("Halifax", "Nova Scotia"));
        assertEquals(3, cityList.countCities());

        // Delete a city
        cityList.delete(new City("Calgary", "Alberta"));
        assertEquals(2, cityList.countCities());
    }
}
