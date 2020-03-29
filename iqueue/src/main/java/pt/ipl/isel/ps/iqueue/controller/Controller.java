package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pt.ipl.isel.ps.iqueue.repository.Repository;

@RestController
public abstract class Controller<T> {

    @Autowired
    protected Repository<T> repository;

    public Controller(Repository<T> repository) {
        this.repository = repository;
    }

    public abstract ResponseEntity get(int id);

    public abstract ResponseEntity getAll();

    public abstract ResponseEntity add(T t);

    public abstract ResponseEntity remove(int id);

    public abstract ResponseEntity update(int id, T t);

}
