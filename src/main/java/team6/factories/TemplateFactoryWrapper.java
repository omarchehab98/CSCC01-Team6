package team6.factories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

// Temporary type until 
import team6.models.Template;

public class TemplateFactoryWrapper {

	HashMap<String, Function<HashMap<String, String>, Template>> TemplateFactories = new HashMap<>();
	ArrayList<HashMap<String, String>> Rows;
	String Template;

	public TemplateFactoryWrapper(ArrayList<HashMap<String, String>> Rows, String Template) {
		this.Rows = Rows;
		this.Template = Template;
		// TODO: update when other template factories are done.
		TemplateFactories.put("NARs", NARsTemplateFactory::build);
	}

	public void Wrap() {
		Template result;
		for (HashMap<String, String> row : Rows) {
			result = TemplateFactories.get(Template).apply(row);
			
		}
	}


}
