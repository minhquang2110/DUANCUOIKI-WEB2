package ntu.edu.nhom13.repositories.custom;

import ntu.edu.nhom13.entity.Scientist;

import java.util.List;
import java.util.Set;

public interface ScientistRepositoryCustom {
    List<Scientist> filter(String keyword, Integer degreeId, Integer titleId, Set<Integer> researchFieldIds);
}
