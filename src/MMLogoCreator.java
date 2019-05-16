public class MMLogoCreator extends LogoCreator {

    private static final String VALIDATION_MESSAGE = "The input must be an odd number between 3 and 10000";

    public MMLogoCreator(int numberLines, String logoSymbol, String separatorSymbol, Printer printer) {
        super(numberLines, logoSymbol, separatorSymbol, printer);

    }

    public void createLogo() {
        this.createUpperPartLogo(this.numberLines);
        this.createBottomPartLogo(this.numberLines);

    }

    private void createUpperPartLogo(int n) {
        int count = 0;
        for (int i = 0; i < (n + 1) / 2; i++) {
            String dash = repeatCharacter(this.separatorSymbol, n - i);
            String asterisk = repeatCharacter(this.logoSymbol, n + i);
            String midDash = repeatCharacter(this.separatorSymbol, n);
            if (i > 0) {
                count++;
                asterisk = repeatCharacter(this.logoSymbol, n + i + count);
                midDash = repeatCharacter(this.separatorSymbol, n - i - i);
            }
            printLogo(dash, asterisk, "", midDash);
        }

    }

    private void createBottomPartLogo(int n) {
        int count = 0;
        for (int i = 0; i < (n + 1) / 2; i++) {
            String dash = repeatCharacter(this.separatorSymbol, ((n + 1) / 2) - i - 1);
            String ast = repeatCharacter(this.logoSymbol, n);
            String midDash = repeatCharacter(this.separatorSymbol, i + 1);
            String midAst = repeatCharacter(this.logoSymbol, 2 * n - 1);
            if (i > 0) {
                count++;
                midDash = repeatCharacter(this.separatorSymbol, i + 1 + count);
                midAst = repeatCharacter(this.logoSymbol, 2 * n - 1 - i * 2);
            }
            printLogo(dash, ast, midDash, midAst);
        }
    }

    private void printLogo(String dash, String ast, String midDash, String midAs) {
        String result = dash + ast + midDash + midAs + midDash + ast + dash;
        printer.print(result + result);
    }

    private static String repeatCharacter(String charToRepeat, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(charToRepeat);
        }

        return sb.toString();
    }

    protected void validateNumberLines(int numberLines) {
        if (numberLines % 2 == 0 || (numberLines < 2 || numberLines > 10000)) {

            throw new IllegalArgumentException(VALIDATION_MESSAGE);
        }
    }

}
