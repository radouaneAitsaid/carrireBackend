package  ma.zs.carriere.ws.converter.avancement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.carriere.zynerator.util.StringUtil;
import ma.zs.carriere.zynerator.converter.AbstractConverter;
import ma.zs.carriere.zynerator.util.DateUtil;
import ma.zs.carriere.bean.core.avancement.Echelle;
import ma.zs.carriere.ws.dto.avancement.EchelleDto;

@Component
public class EchelleConverter extends AbstractConverter<Echelle, EchelleDto> {


    public  EchelleConverter() {
        super(Echelle.class, EchelleDto.class);
    }

    @Override
    public Echelle toItem(EchelleDto dto) {
        if (dto == null) {
            return null;
        } else {
        Echelle item = new Echelle();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }

    @Override
    public EchelleDto toDto(Echelle item) {
        if (item == null) {
            return null;
        } else {
            EchelleDto dto = new EchelleDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
