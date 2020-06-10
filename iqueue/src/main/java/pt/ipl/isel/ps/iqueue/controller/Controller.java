package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import pt.ipl.isel.ps.iqueue.mapping.DaoModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class Controller<M, K, D> {

    private final JpaRepository<D, K> repository;
    private final DaoModelMapper<D, M> daoModelMapper;

    public Controller(JpaRepository<D, K> repository, DaoModelMapper<D, M> daoModelMapper) {
        this.repository = repository;
        this.daoModelMapper = daoModelMapper;
    }

    protected ResponseEntity getById(K id) {
        try {
            Optional<D> t = findById(id);
            if (t.isPresent()) {
                return ResponseEntity.ok(daoModelMapper.mapDaoToModel(t.get()));
            } else {
                return ResponseEntity.status(404).build();
            }
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    protected ResponseEntity getAll() {
        try {
            List<D> tList = repository.findAll();
            if (!tList.isEmpty()) {
                return ResponseEntity.ok(tList.stream()
                        .map(daoModelMapper::mapDaoToModel)
                        .collect(Collectors.toList())
                );
            } else {
                return ResponseEntity.status(404).build();
            }
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    protected ResponseEntity getSome(List<D> tList) {
        try {
            if (!tList.isEmpty()) {
                return ResponseEntity.ok(tList.stream()
                        .map(daoModelMapper::mapDaoToModel)
                        .collect(Collectors.toList())
                );
            } else {
                return ResponseEntity.status(404).build();
            }
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    protected abstract ResponseEntity add(M newM);

    protected ResponseEntity add(M newM, String locationString) {
        try {
            return ResponseEntity.status(201)
                    .header("Location", locationString)
                    .body(newM);

        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    protected ResponseEntity remove(K id) {
        try {
            Optional<D> optionalDTo = findById(id);
            if (optionalDTo.isPresent()) {
                repository.delete(optionalDTo.get());
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    protected ResponseEntity update(K id, M newM) {
        try {
            Optional<D> optionalDTo = findById(id);
            if (optionalDTo.isPresent()) {
                repository.save(daoModelMapper.mapModelToDao(newM));
                return ResponseEntity.ok(newM);
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    private Optional<D> findById(K id) {
        return repository.findById(id);
    }
}
