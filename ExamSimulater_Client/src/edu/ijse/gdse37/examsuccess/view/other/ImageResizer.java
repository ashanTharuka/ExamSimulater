/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.view.other;

/**
 *
 * @author Ashan Tharuka
 */
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Ashan Tharuka
 */
public class ImageResizer {

    /**
     *
     * @param inputImagePath
     * @param outputImagePath
     * @param percent
     * @throws IOException resize image
     */
    public static void resize(String inputImagePath,
            String outputImagePath, double percent) throws IOException {
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
        int scaledWidth = (int) (inputImage.getWidth() * percent);
        int scaledHeight = (int) (inputImage.getHeight() * percent);
        resize(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
    }

    /**
     *
     * @param inputImagePath
     * @param outputImagePath
     * @param scaledWidth
     * @param scaledHeight
     * @throws IOException
     */
    public static void resize(String inputImagePath,
            String outputImagePath, int scaledWidth, int scaledHeight)
            throws IOException {
        // reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);

        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());

        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);

        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath));

    }

    /**
     *
     * @param path
     * @param width
     * @param height
     * @param name
     * @return
     */
    public String setImage(String path, int width, int height, String name) {
        String inputImagePath = path;
        String outputImagePath3 = "C:\\Users\\Ashan Tharuka\\Desktop\\NetBean 8.0.2\\ExamSimulater_Server\\Database\\Student/StudentImage/" + name + "";

        try {
            // resize to a fixed width (not proportional)
            int scaledWidth = width;
            int scaledHeight = height;
            ImageResizer.resize(inputImagePath, outputImagePath3, scaledWidth, scaledHeight);

//            // resize smaller by 50%
//            double percent = 3;
//            ImageResizer.resize(inputImagePath, outputImagePath2, percent);
//
//            // resize bigger by 50%
//            percent = 0.2;
//            ImageResizer.resize(inputImagePath, outputImagePath3, percent);
        } catch (IOException ex) {
            System.out.println("Error resizing the image.");
            ex.printStackTrace();
        }
        return outputImagePath3;
    }
}
