package bertoti.fruta.bertoti_fruta.models;

import java.util.UUID;

public class Fruit {
    private String id;

    private String family;

    private String name;
    
    private double weight;

    private double price;

    public Fruit() {
        super();
        id = UUID.randomUUID().toString();
    }

    public Fruit(String family, String name, double weight, double price) {
        id = UUID.randomUUID().toString();
        this.family = family;
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }
}
