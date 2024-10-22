package fr.efrei.pokemon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.efrei.pokemon.modele.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, String>{

}
