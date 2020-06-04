package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public abstract class Controller<T> {

    final private JpaRepository<T, Integer> repository;

    public Controller(JpaRepository<T, Integer> repository) {
        this.repository = repository;
    }

    protected ResponseEntity getById(int id) {
        try {
            Optional<T> t = repository.findById(id);
            if (t.isPresent()) {
                return ResponseEntity.ok(t.get());
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
            List<T> tList = repository.findAll();
            if (!tList.isEmpty()) {
                return ResponseEntity.ok(tList);
            } else {
                return ResponseEntity.status(404).build();
            }
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    protected ResponseEntity getSome(List<T> tList) {
        try {
            if (!tList.isEmpty()) {
                return ResponseEntity.ok(tList);
            } else {
                return ResponseEntity.status(404).build();
            }
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    protected ResponseEntity add(T newT, String locationString) {
        try {
            return ResponseEntity.status(201)
                    .header("Location", locationString)
                    .body(newT);

        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    protected ResponseEntity remove(Optional<T> t) {
        try {
            if (t.isPresent()) {
                repository.delete(t.get());
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    protected ResponseEntity update(Optional<T> oldT, T newT) {
        try {
            if (oldT.isPresent()) {
                repository.save(newT);
                return ResponseEntity.ok(newT);
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }
}
