package ma.zs.carriere.service.impl.admin.commun;


import ma.zs.carriere.bean.core.commun.EntiteAdmin;
import ma.zs.carriere.bean.core.commun.EntiteAdmin;
import ma.zs.carriere.dao.criteria.core.commun.EntiteAdminCriteria;
import ma.zs.carriere.dao.criteria.core.commun.EntiteAdminCriteria;
import ma.zs.carriere.dao.facade.core.commun.EntiteAdminDao;
import ma.zs.carriere.dao.facade.core.commun.EntiteAdminDao;
import ma.zs.carriere.dao.specification.core.commun.EntiteAdminSpecification;
import ma.zs.carriere.service.facade.admin.commun.EntiteAdminAdminService;
import ma.zs.carriere.service.facade.admin.commun.EntiteAdminAdminService;
import ma.zs.carriere.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntiteAdminAdminServiceImpl extends AbstractServiceImpl<EntiteAdmin, EntiteAdminCriteria, EntiteAdminDao> implements EntiteAdminAdminService {






    public EntiteAdmin findByReferenceEntity(EntiteAdmin t){
        return  dao.findByRef(t.getRef());
    }


    public List<EntiteAdmin> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(EntiteAdmin.class, EntiteAdminSpecification.class);
    }




    public EntiteAdminAdminServiceImpl(EntiteAdminDao dao) {
        super(dao);
    }

}
