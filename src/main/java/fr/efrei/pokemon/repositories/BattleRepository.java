package fr.efrei.pokemon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.efrei.pokemon.modele.Battle;

public interface BattleRepository extends JpaRepository<Battle, String> {
}
