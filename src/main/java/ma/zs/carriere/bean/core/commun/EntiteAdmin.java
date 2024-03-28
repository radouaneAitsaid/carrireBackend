package ma.zs.carriere.bean.core.commun;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import ma.zs.carriere.zynerator.audit.AuditBusinessObject;

@Entity
@Table(name = "entiteAdmin")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name = "entiteAdmin_seq", sequenceName = "entiteAdmin_seq", allocationSize = 1, initialValue = 1)
public class EntiteAdmin extends AuditBusinessObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 500)
    private Long id;
    @Column(length = 500)
    private String ref;
    @Column(length = 500)
    private String departement;
    @ManyToOne
    private Employe chefDepart;
    @Column(length = 500)
    private String titrePoste;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getTitrePoste() {
        return titrePoste;
    }

    public void setTitrePoste(String titrePoste) {
        this.titrePoste = titrePoste;
    }

    public String getChefDepart() {
        return chefDepart;
    }

    public void setChefDepart(String chefDepart) {
        this.chefDepart = chefDepart;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

}



