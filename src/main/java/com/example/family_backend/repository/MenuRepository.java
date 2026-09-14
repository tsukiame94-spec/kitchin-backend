package com.example.family_backend.repository;

import com.example.family_backend.model.MenuHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuHistory, Long> {
}