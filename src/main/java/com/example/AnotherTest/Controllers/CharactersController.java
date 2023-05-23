package com.example.AnotherTest.Controllers;


import com.example.AnotherTest.Model.Characters;
import com.example.AnotherTest.Repostories.CharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/characters")
public class CharactersController {

    @Autowired
    private final CharactersRepository charactersRepository;

    CharactersController(final CharactersRepository charactersRepo){
        this.charactersRepository = charactersRepo;
    }
    @GetMapping()
    public Iterable<Characters> getAllCharacters(){ return this.charactersRepository.findAll(); }

    @GetMapping("/{id}")
    public Characters getCharacter(@PathVariable Long id){
        Optional<Characters> optionalCharacter = this.charactersRepository.findById(id);

        if(optionalCharacter.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Characters character = optionalCharacter.get();

        return character;
    }

    @PostMapping()
    public Characters addNewCharacter(@RequestBody Characters character){
        //todo Add form for filling out character fields
        characterCreationForm(character);

        this.charactersRepository.save(character);

        return character;
    }

    @PutMapping("/{id}")
    public Characters editCharacter(@PathVariable Long id, @RequestBody Characters character){
        Optional<Characters> optionalCharacter = this.charactersRepository.findById(id);

        if(optionalCharacter.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        //todo Add form for editing/filling out character fields
        characterEditForm(character);
        if(ObjectUtils.isEmpty(character.getId())){
            character.setId(id);
        }

        this.charactersRepository.save(character);

        return character;
    }

    @DeleteMapping("/{id}")
    public Characters deleteCharacter(@PathVariable Long id){
        Optional<Characters> optionalCharacters = this.charactersRepository.findById(id);

        if(optionalCharacters.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Characters character = optionalCharacters.get();
        this.charactersRepository.delete(character);

        return character;
    }

    private void characterCreationForm(Characters character){
        if(ObjectUtils.isEmpty(character.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if(ObjectUtils.isEmpty(character.getBio())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if(ObjectUtils.isEmpty(character.getGameIntroduced())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if(ObjectUtils.isEmpty(character.getYearIntroduced())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if(ObjectUtils.isEmpty(character.getMain())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if(ObjectUtils.isEmpty(character.getCharType())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    private void characterEditForm(Characters character){
        if(!ObjectUtils.isEmpty(character.getId())){
            character.setId(character.getId());
        }

        if(!ObjectUtils.isEmpty(character.getName())){
            character.setName(character.getName());
        }

        if(!ObjectUtils.isEmpty(character.getBio())){
            character.setBio(character.getBio());;
        }

        if(!ObjectUtils.isEmpty(character.getGameIntroduced())){
            character.setGameIntroduced(character.getGameIntroduced());
        }

        if(!ObjectUtils.isEmpty(character.getYearIntroduced())){
            character.setYearIntroduced(character.getYearIntroduced());
        }

        if(!ObjectUtils.isEmpty(character.getMain())){
            character.setMain(character.getMain());
        }

        if(!ObjectUtils.isEmpty(character.getCharType())){
            character.setCharType(character.getCharType());
        }
    }
}
