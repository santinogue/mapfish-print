/*
 * Copyright (C) 2013  Camptocamp
 *
 * This file is part of MapFish Print
 *
 * MapFish Print is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MapFish Print is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MapFish Print.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.mapfish.print;

import java.io.IOException;

import org.json.JSONException;
import org.junit.Test;
import org.mapfish.print.config.layout.Block;
import org.mapfish.print.config.layout.ScalebarBlock;
import org.mapfish.print.scalebar.Direction;
import org.mapfish.print.scalebar.Type;
import org.mapfish.print.utils.DistanceUnit;
import org.mapfish.print.utils.PJsonObject;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;

/**
 * This is not an automated test. You have to look at the generated PDF file.
 */
public class ScalebarTest extends PdfTestCase {

    @Test
    public void testBars() throws IOException, DocumentException, JSONException {
        PJsonObject page1 = context.getGlobalParams().getJSONArray("pages").getJSONObject(0);

        /*final PdfContentByte dc = writer.getDirectContent();
        float height = writer.getPageSize().getHeight();
        for (int i = 0; i <= 3; ++i) {
            dc.moveTo(MARGIN + 100 * i, 0);
            dc.lineTo(MARGIN + 100 * i, height);
        }
        dc.stroke();*/
    }

    private ScalebarBlock createSmallBlock() {
        ScalebarBlock block;
        block = createBaseBlock();
        block.setSubIntervals(true);
        block.setType(Type.BAR);
        block.setUnits(DistanceUnit.IN);
        block.setMaxSize(150);
        return block;
    }

    private ScalebarBlock createBaseBlock() {
        ScalebarBlock block = new ScalebarBlock();
        block.setMaxSize(300);
        block.setType(Type.LINE);
        block.setSpacingAfter(30);
        return block;
    }

    private void draw(PJsonObject page1, final Document doc, RenderingContext context, ScalebarBlock block) throws DocumentException {
        block.render(page1, new Block.PdfElement() {
            public void add(Element element) throws DocumentException {
                doc.add(element);
            }
        }, context);
    }
}
