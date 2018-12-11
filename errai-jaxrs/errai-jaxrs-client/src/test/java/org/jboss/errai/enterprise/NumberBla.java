package org.jboss.errai.enterprise;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class NumberBla {

    private Byte myByte;
    private Double myDouble;
    private Float myFloat;
    private Integer myInteger;
    private Long myLong;
    private Short myShort;
    private BigDecimal myBigDecimal;
    private BigInteger myBigInteger;

    private Number myNumber;

    public Byte myByte() {
        return myByte;
    }

    public void setMyByte(Byte myByte) {
        this.myByte = myByte;
    }

    public Double myDouble() {
        return myDouble;
    }

    public void setMyDouble(Double myDouble) {
        this.myDouble = myDouble;
    }

    public Float myFloat() {
        return myFloat;
    }

    public void setMyFloat(Float myFloat) {
        this.myFloat = myFloat;
    }

    public Integer myInteger() {
        return myInteger;
    }

    public void setMyInteger(Integer myInteger) {
        this.myInteger = myInteger;
    }

    public Long myLong() {
        return myLong;
    }

    public void setMyLong(Long myLong) {
        this.myLong = myLong;
    }

    public Short myShort() {
        return myShort;
    }

    public void setMyShort(Short myShort) {
        this.myShort = myShort;
    }

    public BigDecimal myBigDecimal() {
        return myBigDecimal;
    }

    public void setMyBigDecimal(BigDecimal myBigDecimal) {
        this.myBigDecimal = myBigDecimal;
    }

    public BigInteger myBigInteger() {
        return myBigInteger;
    }

    public void setMyBigInteger(BigInteger myBigInteger) {
        this.myBigInteger = myBigInteger;
    }

    public Number myNumber() {
        return myNumber;
    }

    public void setMyNumber(Number myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public String toString() {
        return "NumberBla{" +
                "myByte=" + myByte +
                ", myDouble=" + myDouble +
                ", myFloat=" + myFloat +
                ", myInteger=" + myInteger +
                ", myLong=" + myLong +
                ", myShort=" + myShort +
                ", myBigDecimal=" + myBigDecimal +
                ", myBigInteger=" + myBigInteger +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NumberBla numberBla = (NumberBla) o;
        return Objects.equals(myByte, numberBla.myByte) &&
                Objects.equals(myDouble, numberBla.myDouble) &&
                Objects.equals(myFloat, numberBla.myFloat) &&
                Objects.equals(myInteger, numberBla.myInteger) &&
                Objects.equals(myLong, numberBla.myLong) &&
                Objects.equals(myShort, numberBla.myShort) &&
                Objects.equals(myBigDecimal, numberBla.myBigDecimal) &&
                Objects.equals(myBigInteger, numberBla.myBigInteger) &&
                Objects.equals(myNumber, numberBla.myNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(myByte, myDouble, myFloat, myInteger, myLong, myShort, myBigDecimal, myBigInteger, myNumber);
    }


}
