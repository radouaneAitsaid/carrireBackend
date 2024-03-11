package ma.zs.carriere.bean.core.avancement;

import java.util.Objects;





import ma.zs.carriere.bean.core.avancement.Echelon;
import ma.zs.carriere.bean.core.commun.Employe;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.carriere.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "avancement")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="avancement_seq",sequenceName="avancement_seq",allocationSize=1, initialValue = 1)
public class Avancement   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ref;
    private BigDecimal salaireAjoute = BigDecimal.ZERO;

    private Employe employe ;
    private Echelon echelon ;


    public Avancement(){

        super();
    }

    public Avancement(Long id){

        this.id = id;
    }

    public Avancement(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }
    public Avancement(String ref){

        this.ref = ref ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="avancement_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employe")
    public Employe getEmploye(){
        return this.employe;
    }
    public void setEmploye(Employe employe){
        this.employe = employe;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "echelon")
    public Echelon getEchelon(){
        return this.echelon;
    }
    public void setEchelon(Echelon echelon){
        this.echelon = echelon;
    }
    public BigDecimal getSalaireAjoute(){
        return this.salaireAjoute;
    }
    public void setSalaireAjoute(BigDecimal salaireAjoute){
        this.salaireAjoute = salaireAjoute;
    }

    @Transient
    public String getLabel() {
        label = ref;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avancement avancement = (Avancement) o;
        return id != null && id.equals(avancement.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

