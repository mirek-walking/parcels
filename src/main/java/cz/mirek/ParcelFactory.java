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

import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * Parcel factory class
 *
 * @author  mirek
 */
public class ParcelFactory {

    /**
     * Scans input and parses weight and postal code.
     *
     * @param input the source to be parsed.
     * @return Parcel object. <i>null</i> if <i>input</i> contains quit command;
     */
    Parcel getParcel(Scanner input) {
        Parcel parcel = null;
        do {
            try {
                System.out.println("Enter 'weight'<space>'postal code' (or enter 'quit'):");
                Pattern weightPattern = Pattern.compile("QUIT|quit|[0-9]*\\.[0-9]{3}");
                String weight = input.next(weightPattern);
                if (weight.toLowerCase().equals("quit")) {
                    return null;
                }
                Pattern postalCodePattern = Pattern.compile("[0-9]{5}");
                String postalCode = input.next(postalCodePattern);
                parcel = new Parcel(Double.parseDouble(weight), postalCode);
                System.out.println(parcel.toString());
            } catch (java.util.InputMismatchException ex) {
                System.out.println("Input error, try it again, please.");
            } finally {
                input.nextLine();
            }
        }
        while (parcel == null);
        return parcel;
    }

}
