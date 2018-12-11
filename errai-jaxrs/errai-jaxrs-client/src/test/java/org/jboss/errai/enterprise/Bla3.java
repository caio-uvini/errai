package org.jboss.errai.enterprise;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.Objects;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class Bla3 {

    private Map<String, String> myStringMap;
    private Map<Byte, String> myByteMap;
    private Map<Double, String> myDoubleMap;
    private Map<Float, String> myFloatMap;
    private Map<Integer, String> myIntegerMap;
    private Map<Long, String> myLongMap;
    private Map<Short, String> myShortMap;
    private Map<BigDecimal, String> myBigDecimalMap;
    private Map<BigInteger, String> myBigIntegerMap;
    private Map<Bla, Bla> myBlaMap;

    private Map<String, Byte> myStringByteMap;
    private Map<String, Double> myStringDoubleMap;
    private Map<String, Float> myStringFloatMap;
    private Map<String, Integer> myStringIntegerMap;
    private Map<String, Long> myStringLongMap;
    private Map<String, Short> myStringShortMap;
    private Map<String, BigDecimal> myStringBigDecimalMap;
    private Map<String, BigInteger> myStringBigIntegerMap;

    public Map<String, String> myStringMap() {
        return myStringMap;
    }

    public void setMyStringMap(Map<String, String> myStringMap) {
        this.myStringMap = myStringMap;
    }

    public Map<Byte, String> myByteMap() {
        return myByteMap;
    }

    public void setMyByteMap(Map<Byte, String> myByteMap) {
        this.myByteMap = myByteMap;
    }

    public Map<Double, String> myDoubleMap() {
        return myDoubleMap;
    }

    public void setMyDoubleMap(Map<Double, String> myDoubleMap) {
        this.myDoubleMap = myDoubleMap;
    }

    public Map<Float, String> myFloatMap() {
        return myFloatMap;
    }

    public void setMyFloatMap(Map<Float, String> myFloatMap) {
        this.myFloatMap = myFloatMap;
    }

    public Map<Integer, String> myIntegerMap() {
        return myIntegerMap;
    }

    public void setMyIntegerMap(Map<Integer, String> myIntegerMap) {
        this.myIntegerMap = myIntegerMap;
    }

    public Map<Long, String> myLongMap() {
        return myLongMap;
    }

    public void setMyLongMap(Map<Long, String> myLongMap) {
        this.myLongMap = myLongMap;
    }

    public Map<Short, String> myShortMap() {
        return myShortMap;
    }

    public void setMyShortMap(Map<Short, String> myShortMap) {
        this.myShortMap = myShortMap;
    }

    public Map<BigDecimal, String> myBigDecimalMap() {
        return myBigDecimalMap;
    }

    public void setMyBigDecimalMap(Map<BigDecimal, String> myBigDecimalMap) {
        this.myBigDecimalMap = myBigDecimalMap;
    }

    public Map<BigInteger, String> myBigIntegerMap() {
        return myBigIntegerMap;
    }

    public void setMyBigIntegerMap(Map<BigInteger, String> myBigIntegerMap) {
        this.myBigIntegerMap = myBigIntegerMap;
    }

    public Map<Bla, Bla> myBlaMap() {
        return myBlaMap;
    }

    public void setMyBlaMap(Map<Bla, Bla> myBlaMap) {
        this.myBlaMap = myBlaMap;
    }

    public Map<String, Byte> myStringByteMap() {
        return myStringByteMap;
    }

    public void setMyStringByteMap(Map<String, Byte> myStringByteMap) {
        this.myStringByteMap = myStringByteMap;
    }

    public Map<String, Double> myStringDoubleMap() {
        return myStringDoubleMap;
    }

    public void setMyStringDoubleMap(Map<String, Double> myStringDoubleMap) {
        this.myStringDoubleMap = myStringDoubleMap;
    }

    public Map<String, Float> myStringFloatMap() {
        return myStringFloatMap;
    }

    public void setMyStringFloatMap(Map<String, Float> myStringFloatMap) {
        this.myStringFloatMap = myStringFloatMap;
    }

    public Map<String, Integer> myStringIntegerMap() {
        return myStringIntegerMap;
    }

    public void setMyStringIntegerMap(Map<String, Integer> myStringIntegerMap) {
        this.myStringIntegerMap = myStringIntegerMap;
    }

    public Map<String, Long> myStringLongMap() {
        return myStringLongMap;
    }

    public void setMyStringLongMap(Map<String, Long> myStringLongMap) {
        this.myStringLongMap = myStringLongMap;
    }

    public Map<String, Short> myStringShortMap() {
        return myStringShortMap;
    }

    public void setMyStringShortMap(Map<String, Short> myStringShortMap) {
        this.myStringShortMap = myStringShortMap;
    }

    public Map<String, BigDecimal> myStringBigDecimalMap() {
        return myStringBigDecimalMap;
    }

    public void setMyStringBigDecimalMap(Map<String, BigDecimal> myStringBigDecimalMap) {
        this.myStringBigDecimalMap = myStringBigDecimalMap;
    }

    public Map<String, BigInteger> myStringBigIntegerMap() {
        return myStringBigIntegerMap;
    }

    public void setMyStringBigIntegerMap(Map<String, BigInteger> myStringBigIntegerMap) {
        this.myStringBigIntegerMap = myStringBigIntegerMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bla3 bla3 = (Bla3) o;
        return Objects.equals(myStringMap, bla3.myStringMap) &&
                Objects.equals(myByteMap, bla3.myByteMap) &&
                Objects.equals(myDoubleMap, bla3.myDoubleMap) &&
                Objects.equals(myFloatMap, bla3.myFloatMap) &&
                Objects.equals(myIntegerMap, bla3.myIntegerMap) &&
                Objects.equals(myLongMap, bla3.myLongMap) &&
                Objects.equals(myShortMap, bla3.myShortMap) &&
                Objects.equals(myBigDecimalMap, bla3.myBigDecimalMap) &&
                Objects.equals(myBigIntegerMap, bla3.myBigIntegerMap) &&
                Objects.equals(myBlaMap, bla3.myBlaMap) &&
                Objects.equals(myStringByteMap, bla3.myStringByteMap) &&
                Objects.equals(myStringDoubleMap, bla3.myStringDoubleMap) &&
                Objects.equals(myStringFloatMap, bla3.myStringFloatMap) &&
                Objects.equals(myStringIntegerMap, bla3.myStringIntegerMap) &&
                Objects.equals(myStringLongMap, bla3.myStringLongMap) &&
                Objects.equals(myStringShortMap, bla3.myStringShortMap) &&
                Objects.equals(myStringBigDecimalMap, bla3.myStringBigDecimalMap) &&
                Objects.equals(myStringBigIntegerMap, bla3.myStringBigIntegerMap);
    }

    @Override
    public int hashCode() {

        return Objects.hash(myStringMap, myByteMap, myDoubleMap, myFloatMap, myIntegerMap, myLongMap, myShortMap, myBigDecimalMap, myBigIntegerMap, myBlaMap, myStringByteMap, myStringDoubleMap, myStringFloatMap, myStringIntegerMap, myStringLongMap, myStringShortMap, myStringBigDecimalMap, myStringBigIntegerMap);
    }

    @Override
    public String toString() {
        return "Bla3{" +
                "myStringMap=" + myStringMap +
                ", myByteMap=" + myByteMap +
                ", myDoubleMap=" + myDoubleMap +
                ", myFloatMap=" + myFloatMap +
                ", myIntegerMap=" + myIntegerMap +
                ", myLongMap=" + myLongMap +
                ", myShortMap=" + myShortMap +
                ", myBigDecimalMap=" + myBigDecimalMap +
                ", myBigIntegerMap=" + myBigIntegerMap +
                ", myBlaMap=" + myBlaMap +
                ", myStringByteMap=" + myStringByteMap +
                ", myStringDoubleMap=" + myStringDoubleMap +
                ", myStringFloatMap=" + myStringFloatMap +
                ", myStringIntegerMap=" + myStringIntegerMap +
                ", myStringLongMap=" + myStringLongMap +
                ", myStringShortMap=" + myStringShortMap +
                ", myStringBigDecimalMap=" + myStringBigDecimalMap +
                ", myStringBigIntegerMap=" + myStringBigIntegerMap +
                '}';
    }
}
