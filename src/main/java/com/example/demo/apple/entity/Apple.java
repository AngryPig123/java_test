package com.example.demo.apple.entity;

import com.example.demo.apple.entity.vo.AppleSpec;
import jakarta.persistence.*;

@Entity
@Table(name = "apples")
public class Apple {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private AppleSpec spec;

    protected Apple() {
    }

    public Apple(AppleSpec spec) {
        this.spec = spec;
    }

    public Long getId() {
        return id;
    }

    public AppleSpec getSpec() {
        return spec;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "spec=" + spec +
                '}';
    }

}
