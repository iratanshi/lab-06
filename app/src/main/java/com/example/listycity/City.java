package com.example.listycity;

/**
 * Represents a city with a name and province.
 * This class implements Comparable to allow sorting of cities by name.
 */
public class City implements Comparable{
    private String city;
    private String province;

    /**
     * Constructs a new City with the specified name and province.
     * @param city the name of the city
     * @param province the name of the province
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Returns the name of the city.
     * @return the city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Returns the name of the province.
     * @return the province name
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compares this city with another object based on city name.
     * @param o the object to compare with
     * @return a negative integer, zero, or a positive integer as this city's name
     *         is less than, equal to, or greater than the specified object's city name
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    /**
     * Checks if this city is equal to another object.
     * Two cities are considered equal if they have the same city name and province name.
     * @param obj the object to compare with
     * @return true if the cities are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City otherCity = (City) obj;
        return city.equals(otherCity.city) && province.equals(otherCity.province);
    }

    /**
     * Returns a hash code value for this city.
     * The hash code is computed based on the city name and province name.
     * @return a hash code value for this city
     */
    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + province.hashCode();
        return result;
    }
}