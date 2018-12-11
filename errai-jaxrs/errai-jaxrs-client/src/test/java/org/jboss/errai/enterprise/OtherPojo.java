package org.jboss.errai.enterprise;

import java.util.Objects;
import java.util.Optional;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class OtherPojo {

    public Pojo pojo;
    public Optional<Pojo> pojoOpt;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OtherPojo otherPojo = (OtherPojo) o;
        return Objects.equals(pojo, otherPojo.pojo) &&
                Objects.equals(pojoOpt, otherPojo.pojoOpt);
    }

}
