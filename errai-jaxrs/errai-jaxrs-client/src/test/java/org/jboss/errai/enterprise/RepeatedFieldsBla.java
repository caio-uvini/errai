package org.jboss.errai.enterprise;

import java.util.Objects;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class RepeatedFieldsBla<T> {

    private T field1;
    private T field2;

    public T field1() {
        return field1;
    }

    public void setField1(T field1) {
        this.field1 = field1;
    }

    public T field2() {
        return field2;
    }

    public void setField2(T field2) {
        this.field2 = field2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RepeatedFieldsBla<?> that = (RepeatedFieldsBla<?>) o;
        return Objects.equals(field1, that.field1) &&
                Objects.equals(field2, that.field2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(field1, field2);
    }

    @Override
    public String toString() {
        return "RepeatedFieldsBla{" +
                "field1=" + field1 +
                ", field2=" + field2 +
                '}';
    }
}
