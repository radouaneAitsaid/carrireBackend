package ma.zs.carriere.zynerator.service;

import ma.zs.carriere.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.zs.carriere.zynerator.criteria.BaseCriteria;
import ma.zs.carriere.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, CRITERIA extends BaseCriteria, REPO extends AbstractRepository<T, Long>> extends AbstractServiceImpl<T, CRITERIA, REPO> {

    public AbstractReferentielServiceImpl(REPO dao) {
        super(dao);
    }

}
