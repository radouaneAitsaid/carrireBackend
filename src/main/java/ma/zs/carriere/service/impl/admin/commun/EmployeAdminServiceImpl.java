package ma.zs.carriere.service.impl.admin.commun;


import ma.zs.carriere.bean.core.commun.Employe;
import ma.zs.carriere.dao.criteria.core.commun.EmployeCriteria;
import ma.zs.carriere.dao.facade.core.commun.EmployeDao;
import ma.zs.carriere.dao.specification.core.commun.EmployeSpecification;
import ma.zs.carriere.service.facade.admin.commun.EmployeAdminService;
import ma.zs.carriere.zynerator.service.AbstractServiceImpl;
import ma.zs.carriere.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EmployeAdminServiceImpl extends AbstractServiceImpl<Employe, EmployeCriteria, EmployeDao> implements EmployeAdminService {






    public Employe findByReferenceEntity(Employe t){
        return  dao.findByRef(t.getRef());
    }


    public List<Employe> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Employe.class, EmployeSpecification.class);
    }



    public EmployeAdminServiceImpl(EmployeDao dao) {
        super(dao);
    }

}
