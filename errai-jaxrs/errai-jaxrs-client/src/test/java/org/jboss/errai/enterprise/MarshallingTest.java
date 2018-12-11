package org.jboss.errai.enterprise;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentSkipListMap;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.MarshallingSessionProviderFactory;
import org.jboss.errai.marshalling.server.MappingContextSingleton;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class MarshallingTest {

    static {
        if (!MarshallingSessionProviderFactory.isMarshallingSessionProviderRegistered()) {
            try {
                MappingContextSingleton.loadDynamicMarshallers();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void complexObject() {

        final Bla innerBla1 = new Bla();
        innerBla1.setMyString("bla1");

        final Bla innerBla2 = new Bla();
        innerBla2.setMyString("bla2");

        final Bla innerBla3 = new Bla();
        innerBla3.setMyString("bla3");

        final ArrayBlockingQueue<String> myQueue = new ArrayBlockingQueue<>(1);
        myQueue.add("q1");

        final Map<String, Bla> myStrBlaMap = new HashMap<>();
        myStrBlaMap.put("str1", innerBla1);
        myStrBlaMap.put("str2", innerBla2);
        myStrBlaMap.put("str3", innerBla3);

        final Map<Bla, String> myBlaStrMap = new HashMap<>();
        myBlaStrMap.put(innerBla1, "str1");
        myBlaStrMap.put(innerBla2, "str2");
        myBlaStrMap.put(innerBla3, "str3");

        final Map<Integer, String> myIntStrMap = new HashMap<>();
        myIntStrMap.put(1, "str1");
        myIntStrMap.put(2, "str2");
        myIntStrMap.put(3, "str3");

        final LinkedHashMap<String, String> myLinkedMap = new LinkedHashMap<>();
        myLinkedMap.put("str1", "val1");
        myLinkedMap.put("str2", "val2");
        myLinkedMap.put("str3", "val3");

        final SortedMap<String, String> mySortedMap = new ConcurrentSkipListMap<>();
        mySortedMap.put("str1", "val1");
        mySortedMap.put("str2", "val2");
        mySortedMap.put("str3", "val3");

        final Vector<String> myVector = new Vector<>();
        myVector.add("str1");
        myVector.add("str2");
        myVector.add("str3");

        final Stack<String> myStack = new Stack<>();
        myStack.push("str1");
        myStack.push("str2");
        myStack.push("str3");

        final Date myDate = new Date();

        final Bla bla = new Bla();
        bla.setMyString("blaStr");
        bla.setMyStringBuilder(new StringBuilder("blabla"));
        bla.setMyStringBuffer(new StringBuffer("blabla"));
        bla.setMyByte((byte) 1);
        bla.setMyDouble(1.2);
        bla.setMyFloat((float) 1.3);
        bla.setMyInteger(1);
        bla.setMyLong((long) 5);
        bla.setMyShort((short) 1);
        bla.setMyStringArray(new String[]{"aa", "bb", "cc"});
        bla.setMyStringList(Lists.newArrayList("aa1", "aa2", "aa3"));
        bla.setMyNumberList(Lists.newArrayList(1, 2, 3, 4));
        bla.setMyBlaList(Lists.newArrayList(innerBla1, innerBla2, innerBla3));
        bla.setMyLinkedList(new LinkedList<>(Lists.newArrayList("a1", "a2", "a3")));
        bla.setMySet(Sets.newHashSet("b1", "b2", "b3"));
        bla.setMyLinkedHashSet(new LinkedHashSet<>(Lists.newArrayList("asdad", "fbdbvd")));
        bla.setMyAbstractList(Lists.newArrayList("str1", "str2", "str3"));
        bla.setMyArrayList(Lists.newArrayList("str1", "str2", "str3"));
        bla.setMyVector(myVector);
        bla.setMyStack(myStack);
        bla.setMySortedSet(new TreeSet<>(Lists.newArrayList("11", "12", "13")));
        bla.setMyQueue(myQueue);
        bla.setMyPriorityQueue(new PriorityQueue<>(Lists.newArrayList("q11", "q12", "q13")));
        bla.setMyBlaMap(myStrBlaMap);
        bla.setMyBlaStrMap(myBlaStrMap);
        bla.setMyIntStrMap(myIntStrMap);
        bla.setMyLinkedMap(myLinkedMap);
        bla.setMySortedMap(mySortedMap);
        bla.setMyBigDecimal(BigDecimal.valueOf(123));
        bla.setMyBigInteger(BigInteger.valueOf(1234));
        bla.setMyBoolean(true);
        bla.setMyCharacter('c');
        bla.setMyClass(String.class);
        bla.setMyDate(myDate);
        bla.setMyOptional(Optional.of(new Date()));
        bla.setMySqlDate(new java.sql.Date(new Date().toInstant().getEpochSecond()));
        bla.setMySqlTime(new java.sql.Time(new Date().toInstant().getEpochSecond()));
        bla.setMySqlTimestamp(new java.sql.Timestamp(new Date().toInstant().getEpochSecond()));

        final String json = Marshalling.toJSON(bla);
        final Bla unmarshalledBla = (Bla) Marshalling.fromJSON(json);

        assertEquals(unmarshalledBla, bla);
    }

    @Test
    public void testNumberCollections() {

        final Bla2 bla2 = new Bla2();
        bla2.setMyStringList(Lists.newArrayList("str1", "str2", "str3"));
        bla2.setMyByteList(Lists.newArrayList((byte) 1, (byte) 2, (byte) 3));
        bla2.setMyDoubleList(Lists.newArrayList(1.2d, 1.3d, 1.4d));
        bla2.setMyFloatList(Lists.newArrayList(1.2f, 1.3f, 1.4f));
        bla2.setMyIntegerList(Lists.newArrayList(1, 2, 3));
        bla2.setMyLongList(Lists.newArrayList((long) 1, (long) 2, (long) 3));
        bla2.setMyShortList(Lists.newArrayList((short) 1, (short) 2, (short) 3));
        bla2.setMyBigDecimalList(Lists.newArrayList(BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)));
        bla2.setMyBigIntegerList(Lists.newArrayList(BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3)));

        final String json = Marshalling.toJSON(bla2);
        final Bla2 unmarshalledBla = (Bla2) Marshalling.fromJSON(json);

        assertEquals(unmarshalledBla, bla2);
    }

    @Test
    public void testRootString() {
        final String bla = "hey!";

        final String json = Marshalling.toJSON(bla);
        final String unmarshalledBla = (String) Marshalling.fromJSON(json);

        assertEquals(unmarshalledBla, bla);
    }

    @Test
    public void testRootInteger() {
        final int bla = 2;

        final String json = Marshalling.toJSON(bla);
        final int unmarshalledBla = (int) Marshalling.fromJSON(json);

        assertEquals(unmarshalledBla, bla);
    }

    @Test
    public void rootStringListObject() {

        final List<String> strList = Lists.newArrayList("1", "2", "3", "4");
        final String json = Marshalling.toJSON(strList);
        final List<String> unmarshalledList = (List<String>) Marshalling.fromJSON(json);

        assertEquals(strList, unmarshalledList);
    }

    @Test
    public void rootNumericListObject() {

        final List<Integer> strList = Lists.newArrayList(1, 2, 3, 4);
        final String json = Marshalling.toJSON(strList);
        final List<Integer> unmarshalledList = (List<Integer>) Marshalling.fromJSON(json);

        assertEquals(strList, unmarshalledList);
    }

    @Test
    public void rootBooleanListObject() {

        final List<Boolean> boolList = Lists.newArrayList(true, false, true);
        final String json = Marshalling.toJSON(boolList);
        final List<Boolean> unmarshalledList = (List<Boolean>) Marshalling.fromJSON(json);

        assertEquals(boolList, unmarshalledList);
    }

    @Test
    public void rootBoolean() {

        final boolean bool = false;
        final String json = Marshalling.toJSON(bool);
        boolean unmarshalledBool = (boolean) Marshalling.fromJSON(json);

        assertEquals(bool, unmarshalledBool);
    }

    @Test
    public void numericObject() {

        final Integer number = 5;
        final String json = Marshalling.toJSON(number);
        final Integer unmarshalledNumber = (Integer) Marshalling.fromJSON(json);

        assertEquals(unmarshalledNumber, number);
    }

    @Test
    public void mapObject() {

        final Map<Long, Integer> map = new HashMap<>();
        map.put(1L, 1);
        map.put(2L, 2);

        final String json = Marshalling.toJSON(map);
        final Map<Long, Integer> unmarshalledMap = (Map<Long, Integer>) Marshalling.fromJSON(json);

        assertEquals(unmarshalledMap, map);
    }

    @Test
    public void classObject() {

        Class<String> classz = String.class;

        final String classzJson = Marshalling.toJSON(classz);
        final Class<String> unmarshaledClass = (Class<String>) Marshalling.fromJSON(classzJson);

        assertEquals(unmarshaledClass, classz);
    }

    @Test
    public void testEnum() {

        final Bla bla = new Bla();
        bla.setMyEnum(MinhaEnum.V1);

        final String blaJson = Marshalling.toJSON(bla);
        final Bla unmarshaledClass = (Bla) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledClass, bla);
    }

    @Test
    public void testEnumPropria() {

        final Bla bla = new Bla();
        bla.setMyEnumPropria(MinhaEnum.V1);

        final String blaJson = Marshalling.toJSON(bla);
        final Bla unmarshaledClass = (Bla) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledClass, bla);
    }

    @Test
    public void testListCaching() {

        final List<String> list = Lists.newArrayList("str1", "str2", "str3");

        final Bla bla = new Bla();
        bla.setMyStringList(list);
        bla.setMyStringList2(list);

        final String blaJson = Marshalling.toJSON(bla);
        final Bla unmarshaledBla = (Bla) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, bla);
    }

    @Test
    public void testRepeatedBigDecimalCaching() {

        final BigDecimal field = new BigDecimal(1);

        final RepeatedFieldsBla<BigDecimal> bla = new RepeatedFieldsBla<>();
        bla.setField1(field);
        bla.setField2(field);

        final String blaJson = Marshalling.toJSON(bla);
        final RepeatedFieldsBla unmarshaledBla = (RepeatedFieldsBla) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, bla);
    }

    @Test
    public void testRepeatedBigIntegerCaching() {

        final BigInteger field = new BigInteger("1");

        final RepeatedFieldsBla<BigInteger> bla = new RepeatedFieldsBla<>();
        bla.setField1(field);
        bla.setField2(field);

        final String blaJson = Marshalling.toJSON(bla);
        final RepeatedFieldsBla unmarshaledBla = (RepeatedFieldsBla) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, bla);
    }

    @Test
    public void testRepeatedBooleanCaching() {

        final Boolean field = false;

        final RepeatedFieldsBla<Boolean> bla = new RepeatedFieldsBla<>();
        bla.setField1(field);
        bla.setField2(field);

        final String blaJson = Marshalling.toJSON(bla);
        final RepeatedFieldsBla unmarshaledBla = (RepeatedFieldsBla) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, bla);
    }

    @Test
    public void testRepeatedByteCaching() {

        final Byte field = new Byte("1");

        final RepeatedFieldsBla<Byte> bla = new RepeatedFieldsBla<>();
        bla.setField1(field);
        bla.setField2(field);

        final String blaJson = Marshalling.toJSON(bla);
        final RepeatedFieldsBla unmarshaledBla = (RepeatedFieldsBla) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, bla);
    }

    @Test
    public void testRepeatedArrayListCaching() {

        final List<String> field = Lists.newArrayList("str1", "str2");

        final RepeatedFieldsBla<List<String>> bla = new RepeatedFieldsBla<>();
        bla.setField1(field);
        bla.setField2(field);

        final String blaJson = Marshalling.toJSON(bla);
        final RepeatedFieldsBla unmarshaledBla = (RepeatedFieldsBla) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, bla);
    }

    @Test
    public void testRepeatedHashSetCaching() {

        final Set<String> field = Sets.newHashSet("str1", "str2");

        final RepeatedFieldsBla<Set<String>> bla = new RepeatedFieldsBla<>();
        bla.setField1(field);
        bla.setField2(field);

        final String blaJson = Marshalling.toJSON(bla);
        final RepeatedFieldsBla unmarshaledBla = (RepeatedFieldsBla) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, bla);
    }

    @Test
    public void testRepeatedDoubleCaching() {

        final Double field = 1.1;

        final RepeatedFieldsBla<Double> bla = new RepeatedFieldsBla<>();
        bla.setField1(field);
        bla.setField2(field);

        final String blaJson = Marshalling.toJSON(bla);
        final RepeatedFieldsBla unmarshaledBla = (RepeatedFieldsBla) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, bla);
    }

    @Test
    public void testRepeatedFloatCaching() {

        final Float field = 1.1f;

        final RepeatedFieldsBla<Float> bla = new RepeatedFieldsBla<>();
        bla.setField1(field);
        bla.setField2(field);

        final String blaJson = Marshalling.toJSON(bla);
        final RepeatedFieldsBla unmarshaledBla = (RepeatedFieldsBla) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, bla);
    }

    @Test
    public void testRepeatedIntegerCaching() {

        final int field = 1;

        final RepeatedFieldsBla<Integer> bla = new RepeatedFieldsBla<>();
        bla.setField1(field);
        bla.setField2(field);

        final String blaJson = Marshalling.toJSON(bla);
        final RepeatedFieldsBla unmarshaledBla = (RepeatedFieldsBla) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, bla);
    }

    @Test
    public void testRepeatedLongCaching() {

        final Long field = 1L;

        final RepeatedFieldsBla<Long> bla = new RepeatedFieldsBla<>();
        bla.setField1(field);
        bla.setField2(field);

        final String blaJson = Marshalling.toJSON(bla);
        final RepeatedFieldsBla unmarshaledBla = (RepeatedFieldsBla) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, bla);
    }

    @Test
    public void testRepeatedShortCaching() {

        final Short field = 1;

        final RepeatedFieldsBla<Short> bla = new RepeatedFieldsBla<>();
        bla.setField1(field);
        bla.setField2(field);

        final String blaJson = Marshalling.toJSON(bla);
        final RepeatedFieldsBla unmarshaledBla = (RepeatedFieldsBla) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, bla);
    }

    @Test
    public void testRepeatedStringCaching() {

        final String field = "str1";

        final RepeatedFieldsBla<String> bla = new RepeatedFieldsBla<>();
        bla.setField1(field);
        bla.setField2(field);

        final String blaJson = Marshalling.toJSON(bla);
        final RepeatedFieldsBla unmarshaledBla = (RepeatedFieldsBla) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, bla);
    }

    @Test
    public void testNull() {

        final String blaJson = Marshalling.toJSON("null");
        final String unmarshaledBla = (String) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, "null");
    }

    @Test
    public void testStringOptional() {
        final Optional<String> bla = Optional.of("str");

        final String json = Marshalling.toJSON(bla);
        final Optional<String> unmarshalledBla = (Optional<String>) Marshalling.fromJSON(json);

        assertEquals(unmarshalledBla, bla);
    }

    @Test
    public void testBooleanOptional() {

        final Optional<Boolean> bla = Optional.of(true);

        final String json = Marshalling.toJSON(bla);
        final Optional<Boolean> unmarshalledBla = (Optional<Boolean>) Marshalling.fromJSON(json);

        assertEquals(unmarshalledBla, bla);
    }

    @Test
    public void testByteOptional() {
        final Optional<Byte> bla = Optional.of((byte) 1);

        final String json = Marshalling.toJSON(bla);
        final Optional<Byte> unmarshalledBla = (Optional<Byte>) Marshalling.fromJSON(json);

        assertEquals(unmarshalledBla, bla);
    }

    @Test
    public void testDoubleOptional() {

        final Double d = Double.parseDouble(".6");

        final Optional<Double> bla = Optional.of(1d);

        final String json = Marshalling.toJSON(bla);
        final Optional<Double> unmarshalledBla = (Optional<Double>) Marshalling.fromJSON(json);

        assertEquals(unmarshalledBla, bla);
    }

    @Test
    public void testFloatOptional() {

        final Optional<Float> bla = Optional.of(1f);

        final String json = Marshalling.toJSON(bla);
        final Optional<Float> unmarshalledBla = (Optional<Float>) Marshalling.fromJSON(json);

        assertEquals(unmarshalledBla, bla);
    }

    @Test
    public void testIntegerOptional() {

        final Optional<Integer> bla = Optional.of((int) 1);

        final String json = Marshalling.toJSON(bla);
        final Optional<Integer> unmarshalledBla = (Optional<Integer>) Marshalling.fromJSON(json);

        assertEquals(unmarshalledBla, bla);
    }

    @Test
    public void testLongOptional() {
        final Optional<Long> bla = Optional.of((long) 1);

        final String json = Marshalling.toJSON(bla);
        final Optional<Long> unmarshalledBla = (Optional<Long>) Marshalling.fromJSON(json);

        assertEquals(unmarshalledBla, bla);
    }

    @Test
    public void testShortOptional() {
        final Optional<Short> bla = Optional.of((short) 1);

        final String json = Marshalling.toJSON(bla);
        final Optional<Short> unmarshalledBla = (Optional<Short>) Marshalling.fromJSON(json);

        assertEquals(unmarshalledBla, bla);
    }

    @Test
    public void testBigDecimalOptional() {
        final Optional<BigDecimal> bla = Optional.of(BigDecimal.ONE);

        final String json = Marshalling.toJSON(bla);
        final Optional<BigDecimal> unmarshalledBla = (Optional<BigDecimal>) Marshalling.fromJSON(json);

        assertEquals(unmarshalledBla, bla);
    }

    @Test
    public void testBigIntegerOptional() {
        final Optional<BigInteger> bla = Optional.of(BigInteger.ONE);

        final String json = Marshalling.toJSON(bla);
        final Optional<BigInteger> unmarshalledBla = (Optional<BigInteger>) Marshalling.fromJSON(json);

        assertEquals(unmarshalledBla, bla);
    }

    @Test
    public void testEmptyOptional() {
        final Optional<BigInteger> bla = Optional.empty();

        final String json = Marshalling.toJSON(bla);
        final Optional<BigInteger> unmarshalledBla = (Optional<BigInteger>) Marshalling.fromJSON(json);

        assertEquals(unmarshalledBla, bla);
    }

    @Test
    public void testListOptional() {

        final List<Optional<Boolean>> bla = Lists.newArrayList(Optional.of(true), Optional.of(false));

        final String json = Marshalling.toJSON(bla);
        final List<Optional<Boolean>> unmarshalledBla = (List<Optional<Boolean>>) Marshalling.fromJSON(json);

        assertEquals(unmarshalledBla, bla);
    }

    @Test
    public void testOptionalList() {

        final Optional<List<List<List<String>>>> bla = Optional.of(Lists.newArrayList(Lists.newArrayList(Lists.newArrayList("str11"), Lists.newArrayList("str12")), Lists.newArrayList(Lists.newArrayList("str21"), Lists.newArrayList("str22"))));

        final String json = Marshalling.toJSON(bla);
        final Optional<List<List<List<String>>>> unmarshalledBla = (Optional<List<List<List<String>>>>) Marshalling.fromJSON(json);

        assertEquals(unmarshalledBla, bla);
    }

    @Test
    public void testRepeatedDateCaching() {

        final Date field = new Date();

        final RepeatedFieldsBla<Date> bla = new RepeatedFieldsBla<>();
        bla.setField1(field);
        bla.setField2(field);

        final String blaJson = Marshalling.toJSON(bla);
        final RepeatedFieldsBla unmarshaledBla = (RepeatedFieldsBla) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, bla);
    }

    @Test
    public void testRepeatedOptionalCaching() {

        final List<String> strList = Lists.newArrayList("str1", "str2");

        final Optional<List<String>> field1 = Optional.of(strList);
        final Optional<List<String>> field2 = Optional.of(Lists.newArrayList("bla"));

        final RepeatedFieldsBla<Optional<List<String>>> bla = new RepeatedFieldsBla<>();
        bla.setField1(field1);
        bla.setField2(field2);

        final String blaJson = Marshalling.toJSON(bla);
        final RepeatedFieldsBla unmarshaledBla = (RepeatedFieldsBla) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, bla);
    }

    @Test
    public void testMapMarshalling() {

        final Bla blaMember = new Bla();
        blaMember.setMyString("101");

        final Bla3 bla = new Bla3();
        bla.setMyStringMap(Maps.newHashMap(Maps.asMap(Sets.newHashSet("11"), s -> "v11")));
        bla.setMyByteMap(Maps.newHashMap(Maps.asMap(Sets.newHashSet((byte) 21), s -> "v21")));
        bla.setMyDoubleMap(Maps.newHashMap(Maps.asMap(Sets.newHashSet((double) 31), s -> "v31")));
        bla.setMyFloatMap(Maps.newHashMap(Maps.asMap(Sets.newHashSet((float) 41), s -> "v41")));
        bla.setMyIntegerMap(Maps.newHashMap(Maps.asMap(Sets.newHashSet((int) 51), s -> "v51")));
        bla.setMyLongMap(Maps.newHashMap(Maps.asMap(Sets.newHashSet((long) 61), s -> "v61")));
        bla.setMyShortMap(Maps.newHashMap(Maps.asMap(Sets.newHashSet((short) 71), s -> "v71")));
        bla.setMyBigDecimalMap(Maps.newHashMap(Maps.asMap(Sets.newHashSet(BigDecimal.valueOf(81)), s -> "v81")));
        bla.setMyBigIntegerMap(Maps.newHashMap(Maps.asMap(Sets.newHashSet(BigInteger.valueOf(91)), s -> "v91")));
        bla.setMyBlaMap(Maps.newHashMap(Maps.asMap(Sets.newHashSet(blaMember), s -> blaMember)));
        bla.setMyStringIntegerMap(Maps.newHashMap(Maps.asMap(Sets.newHashSet("121"), s -> 121)));

        bla.setMyStringByteMap(Maps.newHashMap(Maps.asMap(Sets.newHashSet("131"), s -> (byte) 126)));
        bla.setMyStringDoubleMap(Maps.newHashMap(Maps.asMap(Sets.newHashSet("141"), s -> (double) 141)));
        bla.setMyStringFloatMap(Maps.newHashMap(Maps.asMap(Sets.newHashSet("151"), s -> (float) 151)));
        bla.setMyStringIntegerMap(Maps.newHashMap(Maps.asMap(Sets.newHashSet("161"), s -> (int) 161)));
        bla.setMyStringLongMap(Maps.newHashMap(Maps.asMap(Sets.newHashSet("171"), s -> (long) 171)));
        bla.setMyStringShortMap(Maps.newHashMap(Maps.asMap(Sets.newHashSet("181"), s -> (short) 181)));
        bla.setMyStringBigDecimalMap(Maps.newHashMap(Maps.asMap(Sets.newHashSet("191"), s -> BigDecimal.valueOf(191))));
        bla.setMyStringBigIntegerMap(Maps.newHashMap(Maps.asMap(Sets.newHashSet("201"), s -> BigInteger.valueOf(201))));

        final String blaJson = Marshalling.toJSON(bla);
        final Bla3 unmarshaledBla = (Bla3) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, bla);
    }

    @Test
    public void testMapCaching() {

        final Bla keyBla = new Bla();
        keyBla.setMyString("bla1");

        final Bla valueBla = new Bla();
        valueBla.setMyString("bla2");

        final Map<Bla, Bla> map = new HashMap<>();
        map.put(keyBla, valueBla);

        final Map<Bla, Bla> map2 = new HashMap<>();
        map2.put(keyBla, valueBla);

        final RepeatedFieldsBla<Map<Bla, Bla>> bla = new RepeatedFieldsBla<>();
        bla.setField1(map);
        bla.setField2(map);

        final String blaJson = Marshalling.toJSON(bla);
        final RepeatedFieldsBla<Map<Bla, Bla>> unmarshaledBla = (RepeatedFieldsBla<Map<Bla, Bla>>) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, bla);
    }

    @Test
    public void testMapKeyCaching() {

        final Bla repeatedBla = new Bla();
        repeatedBla.setMyString("repeatedBla");

        final Map<Bla, String> map = new HashMap<>();
        map.put(repeatedBla, "bla");

        final List<Bla> list = new ArrayList<>();
        list.add(repeatedBla);

        final Bla input = new Bla();
        input.setMyBlaStrMap(map);
        input.setMyBlaList(list);

        final String blaJson = Marshalling.toJSON(input);
        final Bla unmarshaledBla = (Bla) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, input);
    }

    @Test
    public void testMapValueCaching() {

        final Bla repeatedBla = new Bla();
        repeatedBla.setMyString("repeatedBla");

        final Map<String, Bla> map = new HashMap<>();
        map.put("k1", repeatedBla);
        map.put("k2", repeatedBla);

        final String blaJson = Marshalling.toJSON(map);
        final Map<String, Bla> unmarshaledBla = (Map<String, Bla>) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, map);
    }

    @Test
    public void testEmptyMap() {

        final Map<String, String> input = new HashMap<>();

        final String blaJson = Marshalling.toJSON(input);
        final Map<String, String> unmarshaledBla = (Map<String, String>) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, input);
    }

    @Test
    public void testNullKeyAndValue() {

        final Map<String, String> input = new HashMap<>();
        input.put(null, null);

        final String blaJson = Marshalling.toJSON(input);
        final Map<String, String> unmarshaledBla = (Map<String, String>) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, input);
    }

    @Test
    public void testNullElementsSet() {

        final Set<String> input = new HashSet<>();
        input.add(null);

        final String blaJson = Marshalling.toJSON(input);
        final Set<String> unmarshaledBla = (Set<String>) Marshalling.fromJSON(blaJson);

        assertEquals(unmarshaledBla, input);
    }

    @Test
    public void testUnmarshallReceiveByteOnByteField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":{\"^EncodedType\": \"java.lang.Byte\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myDouble\":null,\"myFloat\":null,\"myInteger\":null,\"myLong\":null,\"myShort\":null,\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myByte().byteValue(), (byte) 5);
        assertNull(bla.myDouble());
        assertNull(bla.myFloat());
        assertNull(bla.myInteger());
        assertNull(bla.myLong());
        assertNull(bla.myShort());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveByteOnShortField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":null,\"myFloat\":null,\"myInteger\":null,\"myLong\":null,\"myShort\":{\"^EncodedType\": \"java.lang.Byte\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myShort().shortValue(), (short) 5);
        assertNull(bla.myDouble());
        assertNull(bla.myFloat());
        assertNull(bla.myInteger());
        assertNull(bla.myLong());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveByteOnIntField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":null,\"myFloat\":null,\"myInteger\":{\"^EncodedType\": \"java.lang.Byte\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myLong\":null,\"myShort\":null,\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myInteger().intValue(), 5);
        assertNull(bla.myDouble());
        assertNull(bla.myFloat());
        assertNull(bla.myShort());
        assertNull(bla.myLong());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveByteOnLongField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":null,\"myFloat\":null,\"myInteger\":null,\"myLong\":{\"^EncodedType\": \"java.lang.Byte\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myShort\":null,\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myLong().longValue(), (long) 5);
        assertNull(bla.myDouble());
        assertNull(bla.myFloat());
        assertNull(bla.myShort());
        assertNull(bla.myInteger());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveByteOnFloatField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":null,\"myFloat\":{\"^EncodedType\": \"java.lang.Byte\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myInteger\":null,\"myLong\":null,\"myShort\":null,\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myFloat().floatValue(), (float) 5, 0);
        assertNull(bla.myDouble());
        assertNull(bla.myLong());
        assertNull(bla.myShort());
        assertNull(bla.myInteger());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveByteOnDoubleField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":{\"^EncodedType\": \"java.lang.Byte\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myFloat\":null,\"myInteger\":null,\"myLong\":null,\"myShort\":null,\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myDouble().doubleValue(), (double) 5, 0);
        assertNull(bla.myFloat());
        assertNull(bla.myLong());
        assertNull(bla.myShort());
        assertNull(bla.myInteger());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveShortOnShortField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":null,\"myFloat\":null,\"myInteger\":null,\"myLong\":null,\"myShort\":{\"^EncodedType\": \"java.lang.Short\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myShort().shortValue(), (short) 5);
        assertNull(bla.myDouble());
        assertNull(bla.myFloat());
        assertNull(bla.myInteger());
        assertNull(bla.myLong());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveShortOnIntField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":null,\"myFloat\":null,\"myInteger\":{\"^EncodedType\": \"java.lang.Short\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myLong\":null,\"myShort\":null,\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myInteger().intValue(), 5);
        assertNull(bla.myDouble());
        assertNull(bla.myFloat());
        assertNull(bla.myShort());
        assertNull(bla.myLong());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveShortOnLongField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":null,\"myFloat\":null,\"myInteger\":null,\"myLong\":{\"^EncodedType\": \"java.lang.Short\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myShort\":null,\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myLong().longValue(), (long) 5);
        assertNull(bla.myDouble());
        assertNull(bla.myFloat());
        assertNull(bla.myShort());
        assertNull(bla.myInteger());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveShortOnFloatField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":null,\"myFloat\":{\"^EncodedType\": \"java.lang.Short\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myInteger\":null,\"myLong\":null,\"myShort\":null,\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myFloat().floatValue(), (float) 5, 0);
        assertNull(bla.myDouble());
        assertNull(bla.myLong());
        assertNull(bla.myShort());
        assertNull(bla.myInteger());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveShortOnDoubleField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":{\"^EncodedType\": \"java.lang.Short\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myFloat\":null,\"myInteger\":null,\"myLong\":null,\"myShort\":null,\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myDouble().doubleValue(), (double) 5, 0);
        assertNull(bla.myFloat());
        assertNull(bla.myLong());
        assertNull(bla.myShort());
        assertNull(bla.myInteger());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveIntOnIntField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":null,\"myFloat\":null,\"myInteger\":{\"^EncodedType\": \"java.lang.Integer\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myLong\":null,\"myShort\":null,\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myInteger().intValue(), 5);
        assertNull(bla.myDouble());
        assertNull(bla.myFloat());
        assertNull(bla.myShort());
        assertNull(bla.myLong());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveIntOnLongField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":null,\"myFloat\":null,\"myInteger\":null,\"myLong\":{\"^EncodedType\": \"java.lang.Integer\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myShort\":null,\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myLong().longValue(), (long) 5);
        assertNull(bla.myDouble());
        assertNull(bla.myFloat());
        assertNull(bla.myShort());
        assertNull(bla.myInteger());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveIntOnFloatField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":null,\"myFloat\":{\"^EncodedType\": \"java.lang.Integer\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myInteger\":null,\"myLong\":null,\"myShort\":null,\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myFloat().floatValue(), (float) 5, 0);
        assertNull(bla.myDouble());
        assertNull(bla.myLong());
        assertNull(bla.myShort());
        assertNull(bla.myInteger());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveIntOnDoubleField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":{\"^EncodedType\": \"java.lang.Integer\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myFloat\":null,\"myInteger\":null,\"myLong\":null,\"myShort\":null,\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myDouble().doubleValue(), (double) 5, 0);
        assertNull(bla.myFloat());
        assertNull(bla.myLong());
        assertNull(bla.myShort());
        assertNull(bla.myInteger());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveLongOnLongField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":null,\"myFloat\":null,\"myInteger\":null,\"myLong\":{\"^EncodedType\": \"java.lang.Long\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myShort\":null,\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myLong().longValue(), (long) 5);
        assertNull(bla.myDouble());
        assertNull(bla.myFloat());
        assertNull(bla.myShort());
        assertNull(bla.myInteger());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveLongOnFloatField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":null,\"myFloat\":{\"^EncodedType\": \"java.lang.Long\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myInteger\":null,\"myLong\":null,\"myShort\":null,\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myFloat().floatValue(), (float) 5, 0);
        assertNull(bla.myDouble());
        assertNull(bla.myLong());
        assertNull(bla.myShort());
        assertNull(bla.myInteger());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveLongOnDoubleField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":{\"^EncodedType\": \"java.lang.Long\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myFloat\":null,\"myInteger\":null,\"myLong\":null,\"myShort\":null,\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myDouble().doubleValue(), (double) 5, 0);
        assertNull(bla.myFloat());
        assertNull(bla.myLong());
        assertNull(bla.myShort());
        assertNull(bla.myInteger());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveFloatOnFloatField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":null,\"myFloat\":{\"^EncodedType\": \"java.lang.Float\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myInteger\":null,\"myLong\":null,\"myShort\":null,\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myFloat().floatValue(), (float) 5, 0);
        assertNull(bla.myDouble());
        assertNull(bla.myLong());
        assertNull(bla.myShort());
        assertNull(bla.myInteger());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveFloatOnDoubleField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":{\"^EncodedType\": \"java.lang.Float\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myFloat\":null,\"myInteger\":null,\"myLong\":null,\"myShort\":null,\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myDouble().doubleValue(), (double) 5, 0);
        assertNull(bla.myFloat());
        assertNull(bla.myLong());
        assertNull(bla.myShort());
        assertNull(bla.myInteger());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testUnmarshallReceiveDoubleOnDoubleField() {

        final String json = "{\"^EncodedType\":\"org.jboss.errai.enterprise.NumberBla\",\"^ObjectID\":\"1\",\"myByte\":null,\"myDouble\":{\"^EncodedType\": \"java.lang.Double\",\"^ObjectID\": \"-1\",\"^NumVal\": 5},\"myFloat\":null,\"myInteger\":null,\"myLong\":null,\"myShort\":null,\"myBigDecimal\":null,\"myBigInteger\":null}";

        final NumberBla bla = (NumberBla) Marshalling.fromJSON(json);

        assertEquals(bla.myDouble().doubleValue(), (double) 5, 0);
        assertNull(bla.myFloat());
        assertNull(bla.myLong());
        assertNull(bla.myShort());
        assertNull(bla.myInteger());
        assertNull(bla.myByte());
        assertNull(bla.myBigDecimal());
        assertNull(bla.myBigInteger());
    }

    @Test
    public void testNumberDoTiago() {

        final NumberBla bla = new NumberBla();
        bla.setMyNumber(BigDecimal.ONE);

        final String json = Marshalling.toJSON(bla);

        final Integer asdads = 1;

        Optional<Integer> o = Optional.ofNullable(null);

        o.get();
    }

    @Test
    public void nullRootObjectMarshalling() {

        final Map<String, String> input = null;

        final String json = Marshalling.toJSON(input);

        final Map<String, String> output = (Map<String, String>) Marshalling.fromJSON(json);

        assertEquals(output, input);
    }

    @Test
    public void inheritanceWithSharedFields() {

        final B input = new B();
        input.setSharedField("shared");
        input.setUniqueAField("AField");
        input.setUniqueBField("BField");

        final String json = Marshalling.toJSON(input);

        final B output = (B) Marshalling.fromJSON(json);

        assertEquals(input, output);
    }

    @Test
    public void optionalValueCaching() {

        final Pojo pojo = new Pojo();
        pojo.foo = "bar";
        pojo.foo2 = "bar2";
        pojo.foo3 = "bar3";
        pojo.foo4 = "bar4";
        pojo.foo5 = "bar5";

        final OtherPojo input = new OtherPojo();
        input.pojo = pojo;
        input.pojoOpt = Optional.of(pojo);

        final String json = Marshalling.toJSON(input);

        final OtherPojo output = (OtherPojo) Marshalling.fromJSON(json);

        assertEquals(input, output);
    }
}
