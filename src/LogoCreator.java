
public abstract class LogoCreator {

    protected String separatorSymbol;
    protected String logoSymbol;
    protected int numberLines;
    protected Printer printer;

    public LogoCreator(int numberLines, String logoSymbol, String separatorSymbol, Printer printer) {
        this.separatorSymbol = separatorSymbol;
        this.logoSymbol = logoSymbol;
        this.numberLines = numberLines;
        this.printer = printer;
        this.validateNumberLines(numberLines);
    }

    public abstract void createLogo();

    protected abstract void validateNumberLines(int number);

}
