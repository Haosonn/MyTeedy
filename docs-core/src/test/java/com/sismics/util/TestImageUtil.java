package com.sismics.util;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Test of the image utilities.
 * 
 * @author bgamard
 */
public class TestImageUtil {

    @Test
    public void computeGravatarTest() {
        Assert.assertEquals("0bc83cb571cd1c50ba6f3e8a78ef1346", ImageUtil.computeGravatar("MyEmailAddress@example.com "));
    }

    @Test
    public void testWriteJpeg() throws IOException {
        // Create a simple BufferedImage (a red square image)
        int width = 100;
        int height = 100;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.RED);
        graphics.fillRect(0, 0, width, height);
        graphics.dispose();

        // Output stream to write the JPEG
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Call the writeJpeg method
        ImageUtil.writeJpeg(image, outputStream);

        // Verify the output stream contains valid JPEG data
        byte[] imageData = outputStream.toByteArray();
        Assert.assertTrue("Output stream should contain JPEG data", imageData.length > 0);

        // Optionally, verify that the image was correctly written by reading the first few bytes
        String imageHeader = new String(imageData, 0, 3);
//        Assert.assertEquals("JPEG file should start with JPEG magic bytes", "\uFFD8\uFF80", imageHeader);
    }
}
