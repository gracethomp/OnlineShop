package com.solvd.entity.user.stuff;

import org.apache.log4j.Logger;

public class MailingList {
    private boolean newsAlert;
    private boolean stocksAlert;
    private boolean recommendationAlert;
    private boolean discountsAlert;

    private static final Logger LOGGER = Logger.getLogger(MailingList.class);

    public MailingList() {

    }

    public MailingList(boolean newsAlert, boolean stocksAlert, boolean recommendationAlert, boolean discountsAlert) {
        this.newsAlert = newsAlert;
        this.stocksAlert = stocksAlert;
        this.recommendationAlert = recommendationAlert;
        this.discountsAlert = discountsAlert;
    }

    public boolean isNewsAlert() {
        LOGGER.trace("news alert was checked");
        return newsAlert;
    }

    public boolean isStocksAlert() {
        LOGGER.trace("stock alert was checked");
        return stocksAlert;
    }

    public boolean isRecommendationAlert() {
        LOGGER.trace("recommendation alert was checked");
        return recommendationAlert;
    }

    public boolean isDiscountsAlert() {
        LOGGER.trace("discount alert was checked");
        return discountsAlert;
    }

    public void setNewsAlert(boolean newsAlert) {
        LOGGER.trace("news alert was set");
        this.newsAlert = newsAlert;
    }

    public void setStocksAlert(boolean stocksAlert) {
        LOGGER.trace("stocks alert was set");
        this.stocksAlert = stocksAlert;
    }

    public void setRecommendationAlert(boolean recommendationAlert) {
        LOGGER.trace("recommendation alert was set");
        this.recommendationAlert = recommendationAlert;
    }

    public void setDiscountsAlert(boolean discountsAlert) {
        LOGGER.trace("discount alert was set");
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
