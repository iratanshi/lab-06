package com.example.listycity;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class manages a collection of City objects.
 * It provides methods to add, delete, search, and count cities in the list.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * Adds a City object to the cities list.
     * @param city the City object to add to the list
     * @throws IllegalArgumentException if the city already exists in the list
     */
    public void add(City city){
        if (!cities.contains(city)){
            cities.add(city);
        } else {
            throw new IllegalArgumentException("City already exists!");
        }
    }

    /**
     * Returns a sorted list of cities.
     * The list is sorted based on the natural ordering defined in the City class.
     * @return a sorted list of all cities
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;

    }

    /**
     * Checks whether a given city exists in the list.
     * @param city the City object to search for
     * @return true if the city is in the list, false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes a city from the list if it exists.
     * @param city the City object to remove from the list
     * @throws IllegalArgumentException if the city does not exist in the list
     */
    public void delete(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException("City does not exist in the list!");
        }
    }

    /**
     * Returns the number of cities in the list.
     * @return the count of cities currently in the list
     */
    public int countCities() {
        return cities.size();
    }
}
