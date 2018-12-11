package org.jboss.errai.enterprise;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class Bla2 {

    private List<String> myStringList;
    private List<Byte> myByteList;
    private List<Double> myDoubleList;
    private List<Float> myFloatList;
    private List<Integer> myIntegerList;
    private List<Long> myLongList;
    private List<Short> myShortList;
    private List<BigDecimal> myBigDecimalList;
    private List<BigInteger> myBigIntegerList;

    public List<String> myStringList() {
        return myStringList;
    }

    public void setMyStringList(List<String> myStringList) {
        this.myStringList = myStringList;
    }

    public List<Byte> myByteList() {
        return myByteList;
    }

    public void setMyByteList(List<Byte> myByteList) {
        this.myByteList = myByteList;
    }

    public List<Double> myDoubleList() {
        return myDoubleList;
    }

    public void setMyDoubleList(List<Double> myDoubleList) {
        this.myDoubleList = myDoubleList;
    }

    public List<Float> myFloatList() {
        return myFloatList;
    }

    public void setMyFloatList(List<Float> myFloatList) {
        this.myFloatList = myFloatList;
    }

    public List<Integer> myIntegerList() {
        return myIntegerList;
    }

    public void setMyIntegerList(List<Integer> myIntegerList) {
        this.myIntegerList = myIntegerList;
    }

    public List<Long> myLongList() {
        return myLongList;
    }

    public void setMyLongList(List<Long> myLongList) {
        this.myLongList = myLongList;
    }

    public List<Short> myShortList() {
        return myShortList;
    }

    public void setMyShortList(List<Short> myShortList) {
        this.myShortList = myShortList;
    }

    public List<BigDecimal> myBigDecimalList() {
        return myBigDecimalList;
    }

    public void setMyBigDecimalList(List<BigDecimal> myBigDecimalList) {
        this.myBigDecimalList = myBigDecimalList;
    }

    public List<BigInteger> myBigIntegerList() {
        return myBigIntegerList;
    }

    public void setMyBigIntegerList(List<BigInteger> myBigIntegerList) {
        this.myBigIntegerList = myBigIntegerList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bla2 bla2 = (Bla2) o;
        return Objects.equals(myStringList, bla2.myStringList) &&
                Objects.equals(myByteList, bla2.myByteList) &&
                Objects.equals(myDoubleList, bla2.myDoubleList) &&
                Objects.equals(myFloatList, bla2.myFloatList) &&
                Objects.equals(myIntegerList, bla2.myIntegerList) &&
                Objects.equals(myLongList, bla2.myLongList) &&
                Objects.equals(myShortList, bla2.myShortList) &&
                Objects.equals(myBigDecimalList, bla2.myBigDecimalList) &&
                Objects.equals(myBigIntegerList, bla2.myBigIntegerList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(myStringList, myByteList, myDoubleList, myFloatList, myIntegerList, myLongList, myShortList, myBigDecimalList, myBigIntegerList);
    }

    @Override
    public String toString() {
        return "Bla2{" +
                "myStringList=" + myStringList +
                ", myByteList=" + myByteList +
                ", myDoubleList=" + myDoubleList +
                ", myFloatList=" + myFloatList +
                ", myIntegerList=" + myIntegerList +
                ", myLongList=" + myLongList +
                ", myShortList=" + myShortList +
                ", myBigDecimalList=" + myBigDecimalList +
                ", myBigIntegerList=" + myBigIntegerList +
                '}';
    }
}
