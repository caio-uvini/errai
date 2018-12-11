package org.jboss.errai.enterprise;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
enum MinhaEnum {

    V1("asdasd"),
    V2("ascuasdas"),
    V3("isubdaiusbdanalaisuhda");

    private String s;

    MinhaEnum(final String s) {
        this.s = s;
    }

    public String getS() {
        return this.s;
    }
}
