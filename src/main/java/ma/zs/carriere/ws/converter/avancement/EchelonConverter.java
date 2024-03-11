package  ma.zs.carriere.ws.converter.avancement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.carriere.ws.converter.avancement.EchelleConverter;



import ma.zs.carriere.zynerator.util.StringUtil;
import ma.zs.carriere.zynerator.converter.AbstractConverter;
import ma.zs.carriere.zynerator.util.DateUtil;
import ma.zs.carriere.bean.core.avancement.Echelon;
import ma.zs.carriere.ws.dto.avancement.EchelonDto;

@Component
public class EchelonConverter extends AbstractConverter<Echelon, EchelonDto> {

    @Autowired
    private EchelleConverter echelleConverter ;
    private boolean echelle;

    public  EchelonConverter() {
        super(Echelon.class, EchelonDto.class);
        init(true);
    }

    @Override
    public Echelon toItem(EchelonDto dto) {
        if (dto == null) {
            return null;
        } else {
        Echelon item = new Echelon();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getSalaire()))
                item.setSalaire(dto.getSalaire());
            if(this.echelle && dto.getEchelle()!=null &&  dto.getEchelle().getId() != null)
                item.setEchelle(echelleConverter.toItem(dto.getEchelle())) ;




        return item;
        }
    }

    @Override
    public EchelonDto toDto(Echelon item) {
        if (item == null) {
            return null;
        } else {
            EchelonDto dto = new EchelonDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getSalaire()))
                dto.setSalaire(item.getSalaire());
            if(this.echelle && item.getEchelle()!=null) {
                dto.setEchelle(echelleConverter.toDto(item.getEchelle())) ;

            }


        return dto;
        }
    }

    public void copy(EchelonDto dto, Echelon t) {
    super.copy(dto, t);
    if (dto.getEchelle() != null)
        echelleConverter.copy(dto.getEchelle(), t.getEchelle());
    }



    public void initObject(boolean value) {
        this.echelle = value;
    }


    public EchelleConverter getEchelleConverter(){
        return this.echelleConverter;
    }
    public void setEchelleConverter(EchelleConverter echelleConverter ){
        this.echelleConverter = echelleConverter;
    }
    public boolean  isEchelle(){
        return this.echelle;
    }
    public void  setEchelle(boolean echelle){
        this.echelle = echelle;
    }
}
