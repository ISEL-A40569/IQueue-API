package pt.ipl.isel.ps.iqueue.mapping;

public interface DaoModelMapper<D, M> {

    M mapDtoToModel(D dao);

    D mapModelToDto(M model);

}
