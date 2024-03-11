package ma.zs.carriere.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.carriere.zynerator.repository.AbstractRepository;
import ma.zs.carriere.bean.core.commun.Employe;
import org.springframework.stereotype.Repository;
import ma.zs.carriere.bean.core.commun.Employe;
import java.util.List;


@Repository
public interface EmployeDao extends AbstractRepository<Employe,Long>  {
    Employe findByRef(String ref);
    int deleteByRef(String ref);


    @Query("SELECT NEW Employe(item.id,item.nom) FROM Employe item")
    List<Employe> findAllOptimized();

}
