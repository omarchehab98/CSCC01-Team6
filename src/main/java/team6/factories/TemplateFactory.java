package team6.factories;

import team6.models.TemplateInterface;
import team6.models.Template;

public interface TemplateFactory {
	
	public static TemplateInterface build() {
		return (TemplateInterface) new Template();
	}

}
