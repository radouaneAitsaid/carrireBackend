package ma.zs.carriere.service.impl.admin.avancement;


import ma.zs.carriere.bean.core.avancement.Echelle;
import ma.zs.carriere.dao.criteria.core.avancement.EchelleCriteria;
import ma.zs.carriere.dao.facade.core.avancement.EchelleDao;
import ma.zs.carriere.dao.specification.core.avancement.EchelleSpecification;
import ma.zs.carriere.service.facade.admin.avancement.EchelleAdminService;
import ma.zs.carriere.zynerator.service.AbstractServiceImpl;
import ma.zs.carriere.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EchelleAdminServiceImpl extends AbstractServiceImpl<Echelle, EchelleCriteria, EchelleDao> implements EchelleAdminService {








    public List<Echelle> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Echelle.class, EchelleSpecification.class);
    }



    public EchelleAdminServiceImpl(EchelleDao dao) {
        super(dao);
    }

}
