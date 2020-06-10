package pt.ipl.isel.ps.iqueue.mapping;

public interface DaoModelMapper<D, M> {

    M mapDaoToModel(D dao);

    D mapModelToDao(M model);

}
