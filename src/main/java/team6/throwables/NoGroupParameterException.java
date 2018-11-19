package team6.throwables;

import team6.models.Query;

public class NoGroupParameterException extends RuntimeException {
	public NoGroupParameterException(Query query) {
		super(String.format("The query %s does not have a group parameter", query.getName()));
	}
}
