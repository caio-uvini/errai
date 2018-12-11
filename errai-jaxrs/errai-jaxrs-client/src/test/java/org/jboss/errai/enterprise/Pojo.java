package org.jboss.errai.enterprise;

import java.util.Objects;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class Pojo {

    public String foo;
    public String foo2;
    public String foo3;
    public String foo4;
    public String foo5;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pojo pojo = (Pojo) o;
        return Objects.equals(foo, pojo.foo) &&
                Objects.equals(foo2, pojo.foo2) &&
                Objects.equals(foo3, pojo.foo3) &&
                Objects.equals(foo4, pojo.foo4) &&
                Objects.equals(foo5, pojo.foo5);
    }

}
