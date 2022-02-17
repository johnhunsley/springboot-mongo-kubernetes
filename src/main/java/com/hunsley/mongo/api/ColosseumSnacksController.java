package com.hunsley.mongo.api;

import com.hunsley.mongo.model.ColosseumSnacks;
import com.hunsley.mongo.repo.ColosseumSnacksRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "snacks")
public class ColosseumSnacksController {

  @Autowired
  private ColosseumSnacksRepository colosseumSnacksRepository;

  @GetMapping
  public List<ColosseumSnacks> getAllSnacks() {
    return colosseumSnacksRepository.findAll();
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public void addSnacks(@RequestBody ColosseumSnacks colosseumSnacks) {
    colosseumSnacksRepository.save(colosseumSnacks);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<ColosseumSnacks> getSnacksById(@PathVariable(name = "id") final Long id)  {
    Optional<ColosseumSnacks> result =  colosseumSnacksRepository.findById(id);

    return result.map(colosseumSnacks -> new ResponseEntity(colosseumSnacks, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
  }
}
