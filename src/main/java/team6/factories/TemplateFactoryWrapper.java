package team6.factories;

import java.util.HashMap;
import java.util.function.BiFunction;

import team6.models.Organization;
import team6.models.Template;
import team6.throwables.IllegalTemplateException;

public class TemplateFactoryWrapper {
	private HashMap<String, BiFunction<HashMap<String, String>, Organization, Template>> templateFactories;

	public TemplateFactoryWrapper() {
		this.templateFactories = new HashMap<>();
		templateFactories.put("NARsTemplate", NARsTemplateFactory::build);
		templateFactories.put("ClientProfileTemplate", ClientProfileTemplateFactory::build);
		templateFactories.put("EmploymentTemplate", EmploymentTemplateFactory::build);
		templateFactories.put("InformationAndOrientationTemplate", InformationAndOrientationTemplateFactory::build);
	}

	public Template build(String template, HashMap<String, String> row, Organization organization) throws IllegalTemplateException {
		if (!templateFactories.containsKey(template)) {
			throw new IllegalTemplateException(String.format("invalid template: %s", template));
		}
		return templateFactories.get(template).apply(row, organization);
	}

}
