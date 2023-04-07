package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable<Television> {

    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make) {
        if(model == null || model.isEmpty() || make == null || make.isEmpty() || screenSize < 32 || resolution < 720)
            throw new IllegalArgumentException("Invalid parameter in constructor");
        this.make = make;
        this.model = model;
        this.resolution = resolution;
        this.screenSize = screenSize;
        this.smart = smart;
        this.fourK = (resolution == 2160);
    }

    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution) {

        this(model, smart, screenSize, resolution, make);
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getResolution() {
        return resolution;
    }

    public int getScreenSize() {
        return screenSize;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Television that)) return false;
        return fourK == that.fourK && resolution == that.resolution && screenSize == that.screenSize && smart == that.smart && Objects.equals(make, that.make) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return this.make.hashCode() + this.model.hashCode() + this.resolution + Boolean.hashCode(this.smart) + Boolean.hashCode(this.fourK);
        //Objects.hash(fourK, make, model, resolution, smart);
    }

    @Override
    public String toString() {
        if(smart){
            if(!fourK)
                return this.make + "-" + this.model + ", " + this.screenSize + " inch smart tv with " + this.resolution + " resolution";
            else
                return this.make + "-" + this.model + ", " + this.screenSize + " inch smart tv with 4K resolution";
        }
        else{
            if(!fourK)
                return this.make + "-" + this.model + ", " + this.screenSize + " inch tv with " + this.resolution + " resolution";
            else
                return this.make + "-" + this.model + ", " + this.screenSize + " inch tv with 4K resolution";
        }
    }


    @Override
    public int compareTo(final Television another) {
        if(another == null)
            throw new IllegalArgumentException("null parameter in the compareTo method");
        int res1 = this.make.compareTo(another.make);
        int res2 = this.model.compareTo(another.model);
        int res3 = this.screenSize - another.screenSize;

        if(res1 != 0)
            return res1;
        else if(res2 != 0)
            return res2;
        else return res3;
    }
}
