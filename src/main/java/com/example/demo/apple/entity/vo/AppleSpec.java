package com.example.demo.apple.entity.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class AppleSpec implements Comparable<AppleSpec> {

    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private Color color;

    @Column(name = "size")
    private float size;

    @Column(name = "price")
    private float price;

    @Column(name = "weight")
    private float weight;

    @Override
    public int compareTo(AppleSpec o) {

        int sizeCompare = Float.compare(this.size, o.getSize());
        if (sizeCompare != 0) {
            return sizeCompare;
        }

        int priceCompare = Float.compare(this.price, o.getPrice());
        if (priceCompare != 0) {
            return priceCompare;
        }

        return Float.compare(this.weight, o.getWeight());
    }

    protected AppleSpec() {
    }

    public AppleSpec(Color color, float size, float price, float weight) {
        this.color = color;
        this.size = size;
        this.price = price;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public float getSize() {
        return size;
    }

    public float getPrice() {
        return price;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "AppleSpec{" +
                "color='" + color + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppleSpec appleSpec = (AppleSpec) o;
        return Float.compare(size, appleSpec.size) == 0 && Float.compare(price, appleSpec.price) == 0 && Float.compare(weight, appleSpec.weight) == 0 && color == appleSpec.color;
    }

    @Override
    public int hashCode() {
        int result = color.hashCode();
        result = 31 * result + Float.hashCode(size);
        result = 31 * result + Float.hashCode(price);
        result = 31 * result + Float.hashCode(weight);
        return result;
    }

}
