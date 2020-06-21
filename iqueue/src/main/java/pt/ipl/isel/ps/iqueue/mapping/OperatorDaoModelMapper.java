package pt.ipl.isel.ps.iqueue.mapping;

import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.OperatorDao;
import pt.ipl.isel.ps.iqueue.model.Operator;

@Component
public class OperatorDaoModelMapper implements DaoModelMapper<OperatorDao, Operator> {
    @Override
    public Operator mapDaoToModel(OperatorDao dao) {
        return new Operator(dao.getOperatorId(), dao.getOperatorDescription(),
                dao.getEmail(), dao.getTelephoneNumber(), dao.getAddress());
    }

    @Override
    public OperatorDao mapModelToDao(Operator model) {
        return new OperatorDao(model.getOperatorId(), model.getOperatorDescription(),
                model.getEmail(), model.getTelephoneNumber(), model.getAddress());
    }
}
