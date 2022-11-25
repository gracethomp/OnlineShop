package entity.user.staff;

import java.util.Objects;

public class ClothingSizes {
    private String title;
    private float bust;
    private float hips;
    private float waist;

    public ClothingSizes() {}
    public ClothingSizes(String title, float bust, float hips, float waist) {
        if(bust <= 0 || hips <=0 || waist <= 0)
            throw new IllegalArgumentException();
        else {
            this.title = title;
            this.bust = bust;
            this.hips = hips;
            this.waist = waist;
        }
    }

    public float getBust() {
        return bust;
    }

    public float getHips() {
        return hips;
    }

    public float getWaist() {
        return waist;
    }

    public String getTitle() {
        return title;
    }

    public void setBust(float bust) {
        this.bust = bust;
    }

    public void setHips(float hips) {
        this.hips = hips;
    }

    public void setWaist(float waist) {
        this.waist = waist;
    }

    public void setTitle(String title) {
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
        return Float.compare(that.bust, bust) == 0 &&
                Float.compare(that.hips, hips) == 0 &&
                Float.compare(that.waist, waist) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bust, hips, waist);
    }
}
