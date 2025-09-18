package commentfiltration;

public class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keywords;
    public SpamAnalyzer(String[] keyWords) {
        keywords = keyWords.clone();
    }

    @Override
    protected String[] getKeywords() {
        return keywords.clone();
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }

}