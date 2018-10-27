package team6.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TemplateController {

    @GetMapping("/templates")
    public String readAllView() {
        return "templates/type-list";
    }

    @GetMapping("/templates/NARs")
    public String readAllNARsView(Model model) {
	return "templates/type-list";
    }
}
