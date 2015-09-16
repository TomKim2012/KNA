package com.wira.mms.client;

import com.google.gwt.junit.client.GWTTestCase;

public class SandboxGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "com.wira.mms.KNA2";
    }

    public void testSandbox() {
        assertTrue(true);
    }
}