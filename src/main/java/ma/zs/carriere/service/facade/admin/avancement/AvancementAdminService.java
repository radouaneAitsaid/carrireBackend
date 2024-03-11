package ma.zs.carriere.service.facade.admin.avancement;

import java.util.List;
import ma.zs.carriere.bean.core.avancement.Avancement;
import ma.zs.carriere.dao.criteria.core.avancement.AvancementCriteria;
import ma.zs.carriere.zynerator.service.IService;



public interface AvancementAdminService extends  IService<Avancement,AvancementCriteria>  {

    List<Avancement> findByEmployeId(Long id);
    int deleteByEmployeId(Long id);
    long countByEmployeRef(String ref);
    List<Avancement> findByEchelonId(Long id);
    int deleteByEchelonId(Long id);
    long countByEchelonId(Long id);




}
