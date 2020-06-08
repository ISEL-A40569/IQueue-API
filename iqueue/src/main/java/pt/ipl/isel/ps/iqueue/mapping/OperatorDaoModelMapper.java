package pt.ipl.isel.ps.iqueue.mapping;

import pt.ipl.isel.ps.iqueue.dao.OperatorDao;
import pt.ipl.isel.ps.iqueue.model.Operator;

public class OperatorDaoModelMapper implements DaoModelMapper<OperatorDao, Operator> {
    @Override
    public Operator mapDtoToModel(OperatorDao dao) {
        return new Operator(dao.getOperatorId(), dao.getOperatorDescription(),
                dao.getEmail(), dao.getPhoneNumber(), dao.getAddress());
    }

    @Override
    public OperatorDao mapModelToDto(Operator model) {
        return new OperatorDao(model.getOperatorId(), model.getOperatorDescription(),
                model.getEmail(), model.getPhoneNumber(), model.getAddress());
    }
}
