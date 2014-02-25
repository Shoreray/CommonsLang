/*
 * Copyright 2002-2005 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.lang.mutable;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * JUnit tests.
 * 
 * @version $Id: MutableShortTest.java 161244 2005-04-14 06:16:36Z ggregory $
 * @see MutableShort
 */
public class MutableShortTest extends TestCase {

    public MutableShortTest(String testName) {
        super(testName);
    }

    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static Test suite() {
        return new TestSuite(MutableShortTest.class);
    }

    // ----------------------------------------------------------------
    public void testConstructors() {
        assertEquals((short) 0, new MutableShort().shortValue());
        
        assertEquals((short) 1, new MutableShort((short) 1).shortValue());
        
        assertEquals((short) 2, new MutableShort(new Short((short) 2)).shortValue());
        assertEquals((short) 3, new MutableShort(new MutableShort((short) 3)).shortValue());
        try {
            new MutableShort(null);
            fail();
        } catch (NullPointerException ex) {}
    }

    public void testGetSet() {
        final MutableShort mutNum = new MutableShort((short) 0);
        assertEquals((short) 0, new MutableShort().shortValue());
        assertEquals(new Short((short) 0), new MutableShort().getValue());
        
        mutNum.setValue((short) 1);
        assertEquals((short) 1, mutNum.shortValue());
        assertEquals(new Short((short) 1), mutNum.getValue());
        
        mutNum.setValue(new Short((short) 2));
        assertEquals((short) 2, mutNum.shortValue());
        assertEquals(new Short((short) 2), mutNum.getValue());
        
        mutNum.setValue(new MutableShort((short) 3));
        assertEquals((short) 3, mutNum.shortValue());
        assertEquals(new Short((short) 3), mutNum.getValue());
        try {
            mutNum.setValue(null);
            fail();
        } catch (NullPointerException ex) {}
        try {
            mutNum.setValue("0");
            fail();
        } catch (ClassCastException ex) {}
    }

    public void testEquals() {
        final MutableShort mutNumA = new MutableShort((short) 0);
        final MutableShort mutNumB = new MutableShort((short) 0);
        final MutableShort mutNumC = new MutableShort((short) 1);

        assertEquals(true, mutNumA.equals(mutNumA));
        assertEquals(true, mutNumA.equals(mutNumB));
        assertEquals(true, mutNumB.equals(mutNumA));
        assertEquals(true, mutNumB.equals(mutNumB));
        assertEquals(false, mutNumA.equals(mutNumC));
        assertEquals(false, mutNumB.equals(mutNumC));
        assertEquals(true, mutNumC.equals(mutNumC));
        assertEquals(false, mutNumA.equals(null));
        assertEquals(false, mutNumA.equals(new Short((short) 0)));
        assertEquals(false, mutNumA.equals("0"));
    }

    public void testHashCode() {
        final MutableShort mutNumA = new MutableShort((short) 0);
        final MutableShort mutNumB = new MutableShort((short) 0);
        final MutableShort mutNumC = new MutableShort((short) 1);

        assertEquals(true, mutNumA.hashCode() == mutNumA.hashCode());
        assertEquals(true, mutNumA.hashCode() == mutNumB.hashCode());
        assertEquals(false, mutNumA.hashCode() == mutNumC.hashCode());
        assertEquals(true, mutNumA.hashCode() == new Short((short) 0).hashCode());
    }

    public void testCompareTo() {
        final MutableShort mutNum = new MutableShort((short) 0);

        assertEquals((short) 0, mutNum.compareTo(new MutableShort((short) 0)));
        assertEquals((short) +1, mutNum.compareTo(new MutableShort((short) -1)));
        assertEquals((short) -1, mutNum.compareTo(new MutableShort((short) 1)));
        try {
            mutNum.compareTo(null);
            fail();
        } catch (NullPointerException ex) {}
        try {
            mutNum.compareTo(new Short((short) 0));
            fail();
        } catch (ClassCastException ex) {}
        try {
            mutNum.compareTo("0");
            fail();
        } catch (ClassCastException ex) {}
    }

    public void testPrimitiveValues() {
        MutableShort mutNum = new MutableShort( (short) 1 );
        
        assertEquals( 1.0F, mutNum.floatValue(), 0 );
        assertEquals( 1.0, mutNum.doubleValue(), 0 );
        assertEquals( (byte) 1, mutNum.byteValue() );
        assertEquals( (short) 1, mutNum.shortValue() );
        assertEquals( 1, mutNum.intValue() );
        assertEquals( 1L, mutNum.longValue() );
    }

    public void testToString() {
        assertEquals("0", new MutableShort((short) 0).toString());
        assertEquals("10", new MutableShort((short) 10).toString());
        assertEquals("-123", new MutableShort((short) -123).toString());
    }

}
