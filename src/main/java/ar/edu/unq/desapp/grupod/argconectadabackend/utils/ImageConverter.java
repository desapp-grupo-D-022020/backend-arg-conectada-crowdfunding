package ar.edu.unq.desapp.grupod.argconectadabackend.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageConverter {

	private String imgUrl;
	private String imgFormat;
	
	public ImageConverter(String imgUrl, String imgFormat) {
		this.imgUrl = imgUrl;
		this.imgFormat = imgFormat;
	}
	
	public byte[] imageToByteArray() throws IOException {
		BufferedImage bImage = ImageIO.read(new File(imgUrl));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(bImage, imgFormat, bos);
		return bos.toByteArray();
	}
}
