package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import pt.ipl.isel.ps.iqueue.repository.Repository;

public class Controller<T> {

    @Autowired
    final protected Repository<T> repository;

    public Controller(Repository<T> repository) {
        this.repository = repository;
    }

    protected ResponseEntity getById(int id) {
        try {
            return ResponseEntity.ok(repository.getById(id));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    protected ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(repository.getAll());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    protected ResponseEntity add(T t, String locationUrl) {
        try {
            int insertedId = repository.add(t);
            if (insertedId != 0) {
                return ResponseEntity
                        .status(201)
                        .header("Location", locationUrl + "/" + insertedId)
                        .body(t);
            }
            else {
                return ResponseEntity.status(409).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    protected ResponseEntity remove(int id) {
        try {
            if (repository.remove(id)) {
                return ResponseEntity.ok().build();
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    protected ResponseEntity update(T t) {
        try {
            if (repository.update(t)) {
                return ResponseEntity.ok().body(t);
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }
}
