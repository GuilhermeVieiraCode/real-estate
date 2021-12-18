package br.edu.ifpb.padroes.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompoundProperties extends BaseProperty{

    List<Property> properties = new ArrayList<>();

    public CompoundProperties(Property... properties) {
        super(0);
        this.add(properties);
    }

    @Override
    public float getPrice() {
        float totalPrice = 0;
        for(Property property: this.properties){
            totalPrice += property.getPrice();
        }
        this.setPrice(totalPrice);
        return this.price;
    }

    public void add(Property property){
        this.properties.add(property);
    }

    public void add(Property... properties){
        this.properties.addAll(Arrays.asList(properties));
    }

    public void remove(Property property){
        this.properties.remove(property);
    }
}
