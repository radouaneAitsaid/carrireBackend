package ma.zs.carriere.dao.criteria.core.commun;



import ma.zs.carriere.zynerator.criteria.BaseCriteria;

public class EntiteAdminCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String departement;
    private String departementLike;
    private String chefDepart;
    private String chefDepartLike;
    private String titrePoste;
    private String titrePosteLike;








    public EntiteAdminCriteria(){}

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRefLike() {
        return refLike;
    }

    public void setRefLike(String refLike) {
        this.refLike = refLike;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getDepartementLike() {
        return departementLike;
    }

    public void setDepartementLike(String departementLike) {
        this.departementLike = departementLike;
    }

    public String getChefDepart() {
        return chefDepart;
    }

    public void setChefDepart(String chefDepart) {
        this.chefDepart = chefDepart;
    }

    public String getChefDepartLike() {
        return chefDepartLike;
    }

    public void setChefDepartLike(String chefDepartLike) {
        this.chefDepartLike = chefDepartLike;
    }

    public String getTitrePosteLike() {
        return titrePosteLike;
    }

    public void setTitrePosteLike(String titrePosteLike) {
        this.titrePosteLike = titrePosteLike;
    }
    public String getTitrePoste() {
        return titrePoste;
    }

    public void setTitrePoste(String titrePoste) {
        this.titrePoste = titrePoste;
    }
}
