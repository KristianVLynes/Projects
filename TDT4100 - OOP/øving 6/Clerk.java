package patterns.delegation.office;

import java.util.function.BinaryOperator;

public class Clerk implements Employee{
	private Printer printer;
	private int calcCount;

	public Clerk(Printer printer) {
		this.printer = printer;
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		calcCount++;
		return operation.apply(value1, value2);
	}

	@Override
	public void printDocument(String document) {
				printer.printDocument(document, this);
	}

	@Override
	public int getTaskCount() {
		return printer.getPrintHistory(this).size() + calcCount;
	}

	@Override
	public int getResourceCount() {
		return 1;
	}
}
