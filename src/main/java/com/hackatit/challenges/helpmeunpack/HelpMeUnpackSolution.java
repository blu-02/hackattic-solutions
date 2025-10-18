package com.hackatit.challenges.helpmeunpack;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelpMeUnpackSolution {

    @JsonProperty("int")
    private int signedInt;

    @JsonProperty("uint")
    private long unSignedInt;

    @Override
    public String toString() {
        return "HelpMeUnpackSolution{" +
                "signedInt=" + signedInt +
                ", unSignedInt=" + unSignedInt +
                ", aShort=" + aShort +
                ", aFloat=" + aFloat +
                ", aDouble=" + aDouble +
                ", bigEndianDouble=" + bigEndianDouble +
                '}';
    }

    public double getBigEndianDouble() {
        return bigEndianDouble;
    }

    public void setBigEndianDouble(double bigEndianDouble) {
        this.bigEndianDouble = bigEndianDouble;
    }

    public double getaDouble() {
        return aDouble;
    }

    public void setaDouble(double aDouble) {
        this.aDouble = aDouble;
    }

    public float getaFloat() {
        return aFloat;
    }

    public void setaFloat(float aFloat) {
        this.aFloat = aFloat;
    }

    public short getaShort() {
        return aShort;
    }

    public void setaShort(short aShort) {
        this.aShort = aShort;
    }

    public long getUnSignedInt() {
        return unSignedInt;
    }

    public void setUnSignedInt(long unSignedInt) {
        this.unSignedInt = unSignedInt;
    }

    public int getSignedInt() {
        return signedInt;
    }

    public void setSignedInt(int signedInt) {
        this.signedInt = signedInt;
    }

    @JsonProperty("short")
    private short aShort;

    @JsonProperty("float")
    private float aFloat;

    @JsonProperty("double")
    private double aDouble;

    @JsonProperty("big_endian_double")
    private double bigEndianDouble;
}
