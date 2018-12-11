package org.jboss.errai.enterprise;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class A {

    protected String uniqueAField;
    protected String sharedField;

    public String uniqueAField() {
        return uniqueAField;
    }

    public void setUniqueAField(String uniqueAField) {
        this.uniqueAField = uniqueAField;
    }

    public String sharedField() {
        return sharedField;
    }

    public void setSharedField(String sharedField) {
        this.sharedField = sharedField;
    }
}
