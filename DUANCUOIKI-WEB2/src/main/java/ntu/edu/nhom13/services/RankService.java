package ntu.edu.nhom13.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ntu.edu.nhom13.entity.Rank;
import ntu.edu.nhom13.repositories.RankRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RankService {

    @Autowired
    private RankRepository rankRepository;

    public List<Rank> getAllRanks() {
        return rankRepository.findAll();
    }

    public Optional<Rank> getRankById(Integer id) {
        return rankRepository.findById(id);
    }

    public Rank saveRank(Rank rank) {
        return rankRepository.save(rank);
    }

    public void deleteRank(Integer id) {
        rankRepository.deleteById(id);
    }
}
