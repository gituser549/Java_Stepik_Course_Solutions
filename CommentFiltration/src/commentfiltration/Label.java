package commentfiltration;

public enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK;

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        Label curLabel = Label.OK;
        for (TextAnalyzer analyzer : analyzers) {
            curLabel = analyzer.processText(text);
            if (curLabel != Label.OK) {
                return curLabel;
            }
        }
        return Label.OK;
    }
}
