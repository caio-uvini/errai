package org.jboss.errai.enterprise;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class B extends A {

    private String uniqueBField;
    private String sharedField;

    public String uniqueBField() {
        return uniqueBField;
    }

    public void setUniqueBField(final String uniqueBField) {
        this.uniqueBField = uniqueBField;
    }

    @Override
    public String sharedField() {
        return sharedField;
    }

    @Override
    public void setSharedField(final String sharedField) {
        super.sharedField = "super - " + sharedField;
        this.sharedField = sharedField;
    }
}
