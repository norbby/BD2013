package phoneBookExeptions;

public class ParsingError extends Exception {
	public ParsingError(String msg) {
		super(msg);
	}
}