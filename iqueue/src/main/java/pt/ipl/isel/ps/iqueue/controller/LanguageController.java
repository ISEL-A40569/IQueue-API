package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.LanguageDao;
import pt.ipl.isel.ps.iqueue.mapping.LanguageDaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.Language;
import pt.ipl.isel.ps.iqueue.repository.LanguageRepository;

@RestController
@RequestMapping("/api/iqueue/language")
public class LanguageController extends Controller<Language, Integer, LanguageDao> {

    @Autowired
    private final LanguageRepository languageRepository;

    @Autowired
    private final LanguageDaoModelMapper languageDaoModelMapper;

    public LanguageController(LanguageRepository languageRepository, LanguageDaoModelMapper languageDaoModelMapper) {
        super(languageRepository, languageDaoModelMapper);
        this.languageRepository = languageRepository;
        this.languageDaoModelMapper = languageDaoModelMapper;
    }

    @GetMapping(value = "{languageId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int languageId) {
        return super.getById(languageId);
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody Language language) {
        try {
            languageRepository.save(languageDaoModelMapper.mapModelToDao(language));

            return super.add(language, "/api/iqueue/language" + language.getLanguageId());
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "{languageId}")
    public ResponseEntity remove(@PathVariable int languageId) {
        // TODO: if needed, must remove first usages of language: UserProfile, ServiceQueueType and AttendanceStatus
        return super.remove(languageId);
    }

    @PutMapping(value = "{languageId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int languageId, @RequestBody Language language) {
        language.setLanguageId(languageId);
        return super.update(languageId, language);
    }
}
