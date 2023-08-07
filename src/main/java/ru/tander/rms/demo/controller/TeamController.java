package ru.tander.rms.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.tander.rms.demo.entity.TeamEntity;
import ru.tander.rms.demo.model.Team;
import ru.tander.rms.demo.repository.TeamRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("api/team")
public class TeamController {

    private final TeamRepository teamRepository;

    @GetMapping
    public List<TeamEntity> team() throws InterruptedException {
        Thread.sleep(400); // демо ожидание для семинара по VueJS
        return teamRepository.findAll();
    }

    @GetMapping("{id}")
    public TeamEntity teamUserById(@PathVariable Long id) {
       Optional<TeamEntity> op = teamRepository.findById(id);
       return op.orElseThrow();
    }

    @PostMapping
    public void create(@RequestBody Team team) {
        TeamEntity teamEntity = TeamEntity.builder()
                .name(team.getName())
                .email(team.getEmail())
                .position(team.getPosition())
                .build();
        teamRepository.save(teamEntity);
    }

    @PutMapping("{id}")
    public void update(@RequestBody Team team) {
        TeamEntity teamEntity = TeamEntity.builder()
                .name(team.getName())
                .email(team.getEmail())
                .position(team.getPosition())
                .id(team.getId())
                .build();
        teamRepository.save(teamEntity);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        teamRepository.deleteById(id);
    }
}
