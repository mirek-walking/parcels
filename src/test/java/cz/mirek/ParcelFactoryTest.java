/*
 * Copyright (c) 2020, mirek. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package cz.mirek;

import junit.framework.TestCase;

import java.util.Locale;
import java.util.Scanner;

/**
 * Unit test for ParcelFactory.
 */

public class ParcelFactoryTest extends TestCase {

    private static final ParcelFactory FACTORY = new ParcelFactory();
    private static final Parcel PARCEL = new Parcel(0.123, "12345");

    /**
     * Unit test for well formatted input.
     */
    public void testGetParcel() {
        Parcel parcel = FACTORY.getParcel(new Scanner("0.123 12345\n").useLocale(Locale.US));
        assertEquals(parcel.getWeight(), PARCEL.getWeight());
        assertEquals(parcel.getPostalCode(), PARCEL.getPostalCode());
    }

    /**
     * Unit test for <i>quit command</i>.
     */
    public void testGetParcelQuit() {
        Parcel parcel = FACTORY.getParcel(new Scanner("quit\n").useLocale(Locale.US));
        assertNull(parcel);
    }
}