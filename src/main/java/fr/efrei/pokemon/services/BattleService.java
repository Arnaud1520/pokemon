package fr.efrei.pokemon.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.efrei.pokemon.modele.Battle;
import fr.efrei.pokemon.repositories.BattleRepository;

@Service
public class BattleService {

    private final BattleRepository battleRepository;

    @Autowired
    public BattleService(BattleRepository battleRepository) {
        this.battleRepository = battleRepository;
    }

    public List<Battle> findAll() {
        return battleRepository.findAll();
    }

    public Battle findById(String id) {
        return battleRepository.findById(id).orElse(null);
    }

    public void save(Battle battle) {
        battleRepository.save(battle);
    }

    public void update(String id, Battle battleDetails) {
        Battle battle = findById(id);
        if (battle != null) {
            battle.setTrainer1(battleDetails.getTrainer1());
            battle.setTrainer2(battleDetails.getTrainer2());
            battle.setPokemonAuCombat(battleDetails.getPokemonAuCombat());
            battleRepository.save(battle);
        }
    }

    public void delete(String id) {
        battleRepository.deleteById(id);
    }
}
