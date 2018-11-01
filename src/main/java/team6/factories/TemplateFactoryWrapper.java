package team6.factories;

import java.util.HashMap;
import java.util.function.Function;

import team6.models.Template;
import team6.throwables.IllegalTemplateException;

public class TemplateFactoryWrapper {
	private HashMap<String, Function<HashMap<String, String>, Template>> templateFactories;

	public TemplateFactoryWrapper() {
		this.templateFactories = new HashMap<>();
		templateFactories.put("NARs", NARsTemplateFactory::build);
	}

	public Template build(String template, HashMap<String, String> row) throws IllegalTemplateException {
		if (!templateFactories.containsKey(template)) {
			throw new IllegalTemplateException(String.format("invalid template: %s", template));
		}
		return templateFactories.get(template).apply(row);
	}

}
