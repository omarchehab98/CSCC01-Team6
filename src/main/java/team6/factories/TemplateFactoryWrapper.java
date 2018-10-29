package team6.factories;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;
 
import team6.models.TemplateInterface;
import team6.throwables.IllegalTemplateException;

public class TemplateFactoryWrapper {

	HashMap<String, Function<HashMap<String, String>, TemplateInterface>> templateFactories;

	public TemplateFactoryWrapper() {
		this.templateFactories = new HashMap<>();
		// TODO: update when other template factories are done.
		templateFactories.put("NARs", NARsTemplateFactory::build);
	}

	public List<TemplateInterface> wrap(String template, List<HashMap<String, String>> rows) 
			throws IllegalTemplateException {
		List<TemplateInterface> finishedTemplates = new ArrayList<TemplateInterface>();
		if (!templateFactories.containsKey(template)) {
			throw new IllegalTemplateException(String.format(
	                "invalid template: %s", template));
		}
		for (HashMap<String, String> row : rows) {
			finishedTemplates.add(templateFactories.get(template).apply(row));
		}
		return finishedTemplates;
	}

}
