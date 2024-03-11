package  ma.zs.carriere.ws.facade.admin.avancement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.carriere.bean.core.avancement.Echelle;
import ma.zs.carriere.dao.criteria.core.avancement.EchelleCriteria;
import ma.zs.carriere.service.facade.admin.avancement.EchelleAdminService;
import ma.zs.carriere.ws.converter.avancement.EchelleConverter;
import ma.zs.carriere.ws.dto.avancement.EchelleDto;
import ma.zs.carriere.zynerator.controller.AbstractController;
import ma.zs.carriere.zynerator.dto.AuditEntityDto;
import ma.zs.carriere.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.carriere.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.carriere.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/echelle/")
public class EchelleRestAdmin  extends AbstractController<Echelle, EchelleDto, EchelleCriteria, EchelleAdminService, EchelleConverter> {



    @Operation(summary = "upload one echelle")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple echelles")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all echelles")
    @GetMapping("")
    public ResponseEntity<List<EchelleDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all echelles")
    @GetMapping("optimized")
    public ResponseEntity<List<EchelleDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a echelle by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EchelleDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new Echelle(libelle));
    }

    @Operation(summary = "Saves the specified  echelle")
    @PostMapping("")
    public ResponseEntity<EchelleDto> save(@RequestBody EchelleDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  echelle")
    @PutMapping("")
    public ResponseEntity<EchelleDto> update(@RequestBody EchelleDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of echelle")
    @PostMapping("multiple")
    public ResponseEntity<List<EchelleDto>> delete(@RequestBody List<EchelleDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified echelle")
    @DeleteMapping("")
    public ResponseEntity<EchelleDto> delete(@RequestBody EchelleDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified echelle")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple echelles by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a echelle and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EchelleDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds echelles by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EchelleDto>> findByCriteria(@RequestBody EchelleCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated echelles by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EchelleCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports echelles by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EchelleCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets echelle data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EchelleCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EchelleRestAdmin (EchelleAdminService service, EchelleConverter converter) {
        super(service, converter);
    }




}
