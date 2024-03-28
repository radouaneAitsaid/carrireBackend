package ma.zs.carriere.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import ma.zs.carriere.bean.core.commun.EntiteAdmin;
import ma.zs.carriere.bean.core.commun.EntiteAdmin;
import ma.zs.carriere.dao.criteria.core.commun.EntiteAdminCriteria;
import ma.zs.carriere.dao.criteria.core.commun.EntiteAdminCriteria;
import ma.zs.carriere.service.facade.admin.commun.EntiteAdminAdminService;
import ma.zs.carriere.service.facade.admin.commun.EntiteAdminAdminService;
import ma.zs.carriere.ws.converter.commun.EntiteAdminConverter;
import ma.zs.carriere.ws.converter.commun.EntiteAdminConverter;
import ma.zs.carriere.ws.dto.commun.EntiteAdminDto;
import ma.zs.carriere.ws.dto.commun.EntiteAdminDto;
import ma.zs.carriere.zynerator.controller.AbstractController;
import ma.zs.carriere.zynerator.dto.FileTempDto;
import ma.zs.carriere.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/admin/entiteAdmin/")
public class EntiteAdminRestAdmin extends AbstractController<EntiteAdmin, EntiteAdminDto, EntiteAdminCriteria, EntiteAdminAdminService, EntiteAdminConverter> {


    @Operation(summary = "upload one entiteAdmin")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @Operation(summary = "upload multiple entiteAdmins")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all entiteAdmins")
    @GetMapping("")
    public ResponseEntity<List<EntiteAdminDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all entiteAdmins")
    @GetMapping("optimized")
    public ResponseEntity<List<EntiteAdminDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a entiteAdmin by ref")
    @GetMapping("ref/{ref}")
    public ResponseEntity<EntiteAdminDto> findByRef(@PathVariable String ref) {
        return super.findByReferenceEntity(new EntiteAdmin());
    }

    @Operation(summary = "Saves the specified  entiteAdmin")
    @PostMapping("")
    public ResponseEntity<EntiteAdminDto> save(@RequestBody EntiteAdminDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  entiteAdmin")
    @PutMapping("")
    public ResponseEntity<EntiteAdminDto> update(@RequestBody EntiteAdminDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of entiteAdmin")
    @PostMapping("multiple")
    public ResponseEntity<List<EntiteAdminDto>> delete(@RequestBody List<EntiteAdminDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }

    @Operation(summary = "Delete the specified entiteAdmin")
    @DeleteMapping("")
    public ResponseEntity<EntiteAdminDto> delete(@RequestBody EntiteAdminDto dto) throws Exception {
        return super.delete(dto);
    }

    @Operation(summary = "Delete the specified entiteAdmin")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }

    @Operation(summary = "Delete multiple entiteAdmins by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
        return super.deleteByIdIn(ids);
    }


    @Operation(summary = "Finds a entiteAdmin and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EntiteAdminDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds entiteAdmins by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EntiteAdminDto>> findByCriteria(@RequestBody EntiteAdminCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated entiteAdmins by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EntiteAdminCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports entiteAdmins by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EntiteAdminCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets entiteAdmin data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EntiteAdminCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }


    public EntiteAdminRestAdmin(EntiteAdminAdminService service, EntiteAdminConverter converter) {
        super(service, converter);
    }


}
