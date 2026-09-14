package com.example.family_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "foods")
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean checked;
    private boolean usedToday; // 追加：今日使うかどうかのフラグ

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isUsedToday() {
        return usedToday;
    }

    public void setUsedToday(boolean usedToday) {
        this.usedToday = usedToday;
    }
}