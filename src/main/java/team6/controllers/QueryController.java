package team6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import team6.repositories.QueryRepository;

@Controller
public class QueryController {
	@Autowired
	private QueryRepository queryRepository;
}
