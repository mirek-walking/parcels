/*
 * Copyright (c) 2020, mirek. All rights reserved.
 * DO NOT ALTER OR REOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
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

import java.util.*;

/**
 * Parcel service app
 * <p>
 * the main method scans the system input and print the sorted list of parcels every 60 seconds
 * TODO input from a text file
 *
 * @author mirek
 */
public class Parcels {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in).useLocale(Locale.US);
        final ParcelFactory parcelFactory = new ParcelFactory();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                printList();
            }
        }, 0, TIMEOUT);
        try {
            Parcel parcel = null;
            do {
                parcel = parcelFactory.getParcel(keyboard);
                if (parcel != null) {
                    parcelList.add(parcel);
                }
            } while (parcel != null);
            parcelList.stream().sorted().forEach(p -> System.out.println(p.toString()));
        } finally {
            keyboard.close();
        }
    }

    private static final long TIMEOUT = 60 * 1000L;  // 60 seconds
    private static final Collection<Parcel> parcelList = Collections.synchronizedList(new ArrayList<Parcel>());

    private static final void printList() {
        parcelList.stream().sorted().forEach(p -> System.out.println(p.getPostalCode() + ' ' + p.getWeight()));
    }
}
