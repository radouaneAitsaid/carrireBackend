package ma.zs.carriere.dao.facade.core.avancement;

import org.springframework.data.jpa.repository.Query;
import ma.zs.carriere.zynerator.repository.AbstractRepository;
import ma.zs.carriere.bean.core.avancement.Avancement;
import org.springframework.stereotype.Repository;
import ma.zs.carriere.bean.core.avancement.Avancement;
import java.util.List;


@Repository
public interface AvancementDao extends AbstractRepository<Avancement,Long>  {
    Avancement findByRef(String ref);
    int deleteByRef(String ref);

    List<Avancement> findByEmployeId(Long id);
    int deleteByEmployeId(Long id);
    long countByEmployeRef(String ref);
    List<Avancement> findByEchelonId(Long id);
    int deleteByEchelonId(Long id);
    long countByEchelonId(Long id);

    @Query("SELECT NEW Avancement(item.id,item.ref) FROM Avancement item")
    List<Avancement> findAllOptimized();

}
