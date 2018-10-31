package team6.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class TemplateRepositoryWrapper {
    @Autowired
    private NARsTemplateRepository nARsTemplateRepository;

    public CrudRepository getRepositoryClass(String template) {
        switch (template) {
            case "NARs":
                return nARsTemplateRepository;
        }
        throw new IllegalArgumentException();
    }
}