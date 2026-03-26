package com.example.demo.repository;

import com.example.demo.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface vendaRepository extends JpaRepository<Venda, Long> {
}