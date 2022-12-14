package com.solvd.entity.user.stuff;

import com.solvd.entity.enums.Sizes;
import com.solvd.exceptions.ClothingSizeIllegalArgumentException;
import com.solvd.exceptions.OnlineShopEmptyTitleException;
import com.solvd.exceptions.OnlineShopNullPointerException;
import org.apache.log4j.Logger;

import java.util.Locale;
import java.util.Objects;

public final class ClothingSizes {
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RESET = "\u001B[0m";
    private final int ZERO = 0;

    private String title;
    private float bust;
    private float hips;
    private float waist;

    private static final Logger LOGGER = Logger.getLogger(ClothingSizes.class);

    public ClothingSizes() {}
    public ClothingSizes(String title, float bust, float hips, float waist) {
        if(bust <= ZERO || hips <= ZERO || waist <= ZERO) {
            LOGGER.error(ClothingSizeIllegalArgumentException.MESSAGE_CONSTRUCTOR);
            throw new ClothingSizeIllegalArgumentException(ClothingSizeIllegalArgumentException.MESSAGE_CONSTRUCTOR);
        }
        OnlineShopNullPointerException.checkTitle(title, LOGGER);
        OnlineShopEmptyTitleException.check(title, LOGGER);
        this.title = title;
        this.bust = bust;
        this.hips = hips;
        this.waist = waist;
    }

    public static void printSizesInfo(){
        System.out.println(ANSI_CYAN + "\t\t\t\tSize chart in inches".toUpperCase(Locale.ROOT));
        System.out.println(ANSI_RESET + "|\tSIZE\t|\tBUST\t|\tWAIST\t|\tHIPS\t|");
        int sizeValue = 0, bust = 32, waist = 26, hips = 35;
        while (bust <= 40 && sizeValue < 5 && waist <= 34 && hips <= 43){
            System.out.print("|    " + Sizes.values()[sizeValue] +"\t\t|");
            printInfoByValue(bust);
            printInfoByValue(waist);
            printInfoByValue(hips);
            System.out.print('\n');
            bust += 2;
            waist += 2;
            hips += 2;
            sizeValue++;
        }
        LOGGER.info("Clothing sizes is entered");
    }

    private static void printInfoByValue(int value){
        System.out.print("\t" + value + "-" + (value + 1) + '\t' + "|");
    }

    public float getBust() {
        LOGGER.trace("bust was gotten");
        return bust;
    }

    public float getHips() {
        LOGGER.trace("hips was gotten");
        return hips;
    }

    public float getWaist() {
        LOGGER.trace("waist was gotten");
        return waist;
    }

    public String getTitle() {
        LOGGER.trace("title was gotten");
        return title;
    }

    public void setBust(float bust) {
        if(bust <= ZERO) {
            LOGGER.error(ClothingSizeIllegalArgumentException.MESSAGE_BUST);
            throw new ClothingSizeIllegalArgumentException();
        }
        LOGGER.trace("bust was set");
        this.bust = bust;
    }

    public void setHips(float hips) {
        if(hips <= ZERO) {
            LOGGER.error(ClothingSizeIllegalArgumentException.MESSAGE_HIPS);
            throw new ClothingSizeIllegalArgumentException();
        }
        LOGGER.trace("hips was set");
        this.hips = hips;
    }

    public void setWaist(float waist) {
        if(waist <= ZERO) {
            LOGGER.error(ClothingSizeIllegalArgumentException.MESSAGE_WAIST);
            throw new ClothingSizeIllegalArgumentException();
        }
        LOGGER.trace("waist was set");
        this.waist = waist;
    }

    public void setTitle(String title) {
        OnlineShopNullPointerException.checkTitle(title, LOGGER);
        OnlineShopEmptyTitleException.check(title, LOGGER);
        LOGGER.trace("title was set");
        this.title = title;
    }

    @Override
    public String toString() {
        return "ClothingSizes is" +
                "bust: " + bust +
                "sm, hips: " + hips +
                "sm, waist: " + waist +
                "sm";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClothingSizes that = (ClothingSizes) o;
        return Float.compare(that.bust, bust) == ZERO &&
                Float.compare(that.hips, hips) == ZERO &&
                Float.compare(that.waist, waist) == ZERO;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bust, hips, waist);
    }
}
