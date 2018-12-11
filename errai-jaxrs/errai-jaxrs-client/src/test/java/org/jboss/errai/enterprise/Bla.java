package org.jboss.errai.enterprise;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.Vector;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class Bla {

    private String myString;
    private StringBuilder myStringBuilder;
    private StringBuffer myStringBuffer;

    private Byte myByte;
    private Double myDouble;
    private Float myFloat;
    private Integer myInteger;
    private Long myLong;
    private Short myShort;

    private String[] myStringArray;

    private List<String> myStringList;

    public List<String> myStringList2() {
        return myStringList2;
    }

    public void setMyStringList2(List<String> myStringList2) {
        this.myStringList2 = myStringList2;
    }

    private List<String> myStringList2;
    private List<Integer> myNumberList;
    private List<Bla> myBlaList;
    private LinkedList<String> myLinkedList;
    private AbstractList<String> myAbstractList;
    private ArrayList<String> myArrayList;
    private Vector<String> myVector;
    private Stack<String> myStack;

    private Set<String> mySet;
    private LinkedHashSet<String> myLinkedHashSet;
    private SortedSet<String> mySortedSet;

    private Queue<String> myQueue;
    private PriorityQueue<String> myPriorityQueue;

    private Map<String, Bla> myBlaMap;
    private Map<Bla, String> myBlaStrMap;
    private Map<Integer, String> myIntStrMap;
    private LinkedHashMap<String, String> myLinkedMap;
    private SortedMap<String, String> mySortedMap;

    private BigDecimal myBigDecimal;
    private BigInteger myBigInteger;
    private Boolean myBoolean;
    private Character myCharacter;
    private Class<String> myClass;
    private Date myDate;

    private Optional<Date> myOptional;

    private java.sql.Date mySqlDate;
    private Time mySqlTime;
    private Timestamp mySqlTimestamp;

    private Enum<?> myEnum;

    @Override
    public String toString() {
        return "Bla{" +
                "myString='" + myString + '\'' +
                ", myStringBuilder=" + myStringBuilder +
                ", myStringBuffer=" + myStringBuffer +
                ", myByte=" + myByte +
                ", myDouble=" + myDouble +
                ", myFloat=" + myFloat +
                ", myInteger=" + myInteger +
                ", myLong=" + myLong +
                ", myShort=" + myShort +
                ", myStringArray=" + Arrays.toString(myStringArray) +
                ", myStringList=" + myStringList +
                ", myNumberList=" + myNumberList +
                ", myBlaList=" + myBlaList +
                ", myLinkedList=" + myLinkedList +
                ", myAbstractList=" + myAbstractList +
                ", myArrayList=" + myArrayList +
                ", myVector=" + myVector +
                ", myStack=" + myStack +
                ", mySet=" + mySet +
                ", myLinkedHashSet=" + myLinkedHashSet +
                ", mySortedSet=" + mySortedSet +
                ", myQueue=" + myQueue +
                ", myPriorityQueue=" + myPriorityQueue +
                ", myBlaMap=" + myBlaMap +
                ", myBlaStrMap=" + myBlaStrMap +
                ", myIntStrMap=" + myIntStrMap +
                ", myLinkedMap=" + myLinkedMap +
                ", mySortedMap=" + mySortedMap +
                ", myBigDecimal=" + myBigDecimal +
                ", myBigInteger=" + myBigInteger +
                ", myBoolean=" + myBoolean +
                ", myCharacter=" + myCharacter +
                ", myClass=" + myClass +
                ", myDate=" + myDate +
                ", myOptional=" + myOptional +
                ", mySqlDate=" + mySqlDate +
                ", mySqlTime=" + mySqlTime +
                ", mySqlTimestamp=" + mySqlTimestamp +
                ", myEnum=" + myEnum +
                ", myEnumPropria=" + myEnumPropria +
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
        Bla bla = (Bla) o;
        return Objects.equals(myString, bla.myString) &&
                Objects.equals(myStringBuilder, bla.myStringBuilder) &&
                Objects.equals(myStringBuffer, bla.myStringBuffer) &&
                Objects.equals(myByte, bla.myByte) &&
                Objects.equals(myDouble, bla.myDouble) &&
                Objects.equals(myFloat, bla.myFloat) &&
                Objects.equals(myInteger, bla.myInteger) &&
                Objects.equals(myLong, bla.myLong) &&
                Objects.equals(myShort, bla.myShort) &&
                Arrays.equals(myStringArray, bla.myStringArray) &&
                Objects.equals(myStringList, bla.myStringList) &&
                Objects.equals(myNumberList, bla.myNumberList) &&
                Objects.equals(myBlaList, bla.myBlaList) &&
                Objects.equals(myLinkedList, bla.myLinkedList) &&
                Objects.equals(myAbstractList, bla.myAbstractList) &&
                Objects.equals(myArrayList, bla.myArrayList) &&
                Objects.equals(myVector, bla.myVector) &&
                Objects.equals(myStack, bla.myStack) &&
                Objects.equals(mySet, bla.mySet) &&
                Objects.equals(myLinkedHashSet, bla.myLinkedHashSet) &&
                Objects.equals(mySortedSet, bla.mySortedSet) &&
                Objects.equals(myQueue, bla.myQueue) &&
                Objects.equals(myPriorityQueue, bla.myPriorityQueue) &&
                Objects.equals(myBlaMap, bla.myBlaMap) &&
                Objects.equals(myBlaStrMap, bla.myBlaStrMap) &&
                Objects.equals(myIntStrMap, bla.myIntStrMap) &&
                Objects.equals(myLinkedMap, bla.myLinkedMap) &&
                Objects.equals(mySortedMap, bla.mySortedMap) &&
                Objects.equals(myBigDecimal, bla.myBigDecimal) &&
                Objects.equals(myBigInteger, bla.myBigInteger) &&
                Objects.equals(myBoolean, bla.myBoolean) &&
                Objects.equals(myCharacter, bla.myCharacter) &&
                Objects.equals(myClass, bla.myClass) &&
                Objects.equals(myDate, bla.myDate) &&
                Objects.equals(myOptional, bla.myOptional) &&
                Objects.equals(mySqlDate, bla.mySqlDate) &&
                Objects.equals(mySqlTime, bla.mySqlTime) &&
                Objects.equals(mySqlTimestamp, bla.mySqlTimestamp) &&
                Objects.equals(myEnum, bla.myEnum) &&
                myEnumPropria == bla.myEnumPropria;
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(myString, myStringBuilder, myStringBuffer, myByte, myDouble, myFloat, myInteger, myLong, myShort, myStringList, myNumberList, myBlaList, myLinkedList, myAbstractList, myArrayList, myVector, myStack, mySet, myLinkedHashSet, mySortedSet, myQueue, myPriorityQueue, myBlaMap, myBlaStrMap, myIntStrMap, myLinkedMap, mySortedMap, myBigDecimal, myBigInteger, myBoolean, myCharacter, myClass, myDate, myOptional, mySqlDate, mySqlTime, mySqlTimestamp, myEnum, myEnumPropria);
        result = 31 * result + Arrays.hashCode(myStringArray);
        return result;
    }

    public MinhaEnum myEnumPropria() {

        return myEnumPropria;
    }

    public void setMyEnumPropria(MinhaEnum myEnumPropria) {
        this.myEnumPropria = myEnumPropria;
    }

    private MinhaEnum myEnumPropria;

    public String myString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    public StringBuilder myStringBuilder() {
        return myStringBuilder;
    }

    public void setMyStringBuilder(StringBuilder myStringBuilder) {
        this.myStringBuilder = myStringBuilder;
    }

    public StringBuffer myStringBuffer() {
        return myStringBuffer;
    }

    public void setMyStringBuffer(StringBuffer myStringBuffer) {
        this.myStringBuffer = myStringBuffer;
    }

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

    public String[] myStringArray() {
        return myStringArray;
    }

    public void setMyStringArray(String[] myStringArray) {
        this.myStringArray = myStringArray;
    }

    public List<String> myStringList() {
        return myStringList;
    }

    public void setMyStringList(List<String> myStringList) {
        this.myStringList = myStringList;
    }

    public List<Integer> myNumberList() {
        return myNumberList;
    }

    public void setMyNumberList(List<Integer> myNumberList) {
        this.myNumberList = myNumberList;
    }

    public List<Bla> myBlaList() {
        return myBlaList;
    }

    public void setMyBlaList(List<Bla> myBlaList) {
        this.myBlaList = myBlaList;
    }

    public LinkedList<String> myLinkedList() {
        return myLinkedList;
    }

    public void setMyLinkedList(LinkedList<String> myLinkedList) {
        this.myLinkedList = myLinkedList;
    }

    public Set<String> mySet() {
        return mySet;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public LinkedHashSet<String> myLinkedHashSet() {
        return myLinkedHashSet;
    }

    public void setMyLinkedHashSet(LinkedHashSet<String> myLinkedHashSet) {
        this.myLinkedHashSet = myLinkedHashSet;
    }

    public SortedSet<String> mySortedSet() {
        return mySortedSet;
    }

    public void setMySortedSet(SortedSet<String> mySortedSet) {
        this.mySortedSet = mySortedSet;
    }

    public Queue<String> myQueue() {
        return myQueue;
    }

    public void setMyQueue(Queue<String> myQueue) {
        this.myQueue = myQueue;
    }

    public PriorityQueue<String> myPriorityQueue() {
        return myPriorityQueue;
    }

    public void setMyPriorityQueue(PriorityQueue<String> myPriorityQueue) {
        this.myPriorityQueue = myPriorityQueue;
    }

    public Map<String, Bla> myBlaMap() {
        return myBlaMap;
    }

    public void setMyBlaMap(Map<String, Bla> myBlaMap) {
        this.myBlaMap = myBlaMap;
    }

    public Map<Bla, String> myBlaStrMap() {
        return myBlaStrMap;
    }

    public void setMyBlaStrMap(Map<Bla, String> myBlaStrMap) {
        this.myBlaStrMap = myBlaStrMap;
    }

    public Map<Integer, String> myIntStrMap() {
        return myIntStrMap;
    }

    public void setMyIntStrMap(Map<Integer, String> myIntStrMap) {
        this.myIntStrMap = myIntStrMap;
    }

    public LinkedHashMap<String, String> myLinkedMap() {
        return myLinkedMap;
    }

    public void setMyLinkedMap(LinkedHashMap<String, String> myLinkedMap) {
        this.myLinkedMap = myLinkedMap;
    }

    public SortedMap<String, String> mySortedMap() {
        return mySortedMap;
    }

    public void setMySortedMap(SortedMap<String, String> mySortedMap) {
        this.mySortedMap = mySortedMap;
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

    public Boolean myBoolean() {
        return myBoolean;
    }

    public void setMyBoolean(Boolean myBoolean) {
        this.myBoolean = myBoolean;
    }

    public Character myCharacter() {
        return myCharacter;
    }

    public void setMyCharacter(Character myCharacter) {
        this.myCharacter = myCharacter;
    }

    public Class<String> myClass() {
        return myClass;
    }

    public void setMyClass(Class<String> myClass) {
        this.myClass = myClass;
    }

    public Date myDate() {
        return myDate;
    }

    public void setMyDate(Date myDate) {
        this.myDate = myDate;
    }

    public Optional<Date> myOptional() {
        return myOptional;
    }

    public void setMyOptional(Optional<Date> myOptional) {
        this.myOptional = myOptional;
    }

    public java.sql.Date mySqlDate() {
        return mySqlDate;
    }

    public void setMySqlDate(java.sql.Date mySqlDate) {
        this.mySqlDate = mySqlDate;
    }

    public Time mySqlTime() {
        return mySqlTime;
    }

    public void setMySqlTime(Time mySqlTime) {
        this.mySqlTime = mySqlTime;
    }

    public Timestamp mySqlTimestamp() {
        return mySqlTimestamp;
    }

    public void setMySqlTimestamp(Timestamp mySqlTimestamp) {
        this.mySqlTimestamp = mySqlTimestamp;
    }

    public AbstractList<String> myAbstractList() {
        return myAbstractList;
    }

    public void setMyAbstractList(AbstractList<String> myAbstractList) {
        this.myAbstractList = myAbstractList;
    }

    public ArrayList<String> myArrayList() {
        return myArrayList;
    }

    public void setMyArrayList(ArrayList<String> myArrayList) {
        this.myArrayList = myArrayList;
    }

    public Vector<String> myVector() {
        return myVector;
    }

    public void setMyVector(Vector<String> myVector) {
        this.myVector = myVector;
    }

    public Stack<String> myStack() {
        return myStack;
    }

    public void setMyStack(Stack<String> myStack) {
        this.myStack = myStack;
    }

    public Enum<?> myEnum() {

        return myEnum;
    }

    public void setMyEnum(Enum<?> myEnum) {
        this.myEnum = myEnum;
    }
}
