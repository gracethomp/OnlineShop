package entity.user.stuff;

public class MailingList {
    private boolean newsAlert;
    private boolean stocksAlert;
    private boolean recommendationAlert;
    private boolean discountsAlert;

    public MailingList() {

    }

    public MailingList(boolean newsAlert, boolean stocksAlert, boolean recommendationAlert, boolean discountsAlert) {
        this.newsAlert = newsAlert;
        this.stocksAlert = stocksAlert;
        this.recommendationAlert = recommendationAlert;
        this.discountsAlert = discountsAlert;
    }

    public boolean isNewsAlert() {
        return newsAlert;
    }

    public boolean isStocksAlert() {
        return stocksAlert;
    }

    public boolean isRecommendationAlert() {
        return recommendationAlert;
    }

    public boolean isDiscountsAlert() {
        return discountsAlert;
    }

    public void setNewsAlert(boolean newsAlert) {
        this.newsAlert = newsAlert;
    }

    public void setStocksAlert(boolean stocksAlert) {
        this.stocksAlert = stocksAlert;
    }

    public void setRecommendationAlert(boolean recommendationAlert) {
        this.recommendationAlert = recommendationAlert;
    }

    public void setDiscountsAlert(boolean discountsAlert) {
        this.discountsAlert = discountsAlert;
    }

    @Override
    public String toString() {
        return "News Mailing: " + newsAlert +
                ", Stocks Mailing: " + stocksAlert +
                ", Recommendation Mailing: " + recommendationAlert +
                ", Discounts Mailing: " + discountsAlert;
    }
}
