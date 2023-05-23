package com.example.AnotherTest.Repostories;

import com.example.AnotherTest.Model.Characters;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CharactersRepository extends CrudRepository<Characters,Long> {

    List<Characters> findByName(String name);
    List<Characters> findByGameIntroducedOrderByNameDesc(String game);
    List<Characters> findByYearIntroducedOrderByNameDesc(Integer year);
    List<Characters> findByMainOrderByNameDesc(Boolean main);
    List<Characters> findBycharTypeOrderByNameDesc(String type);

}
