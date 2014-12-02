import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

@SuppressWarnings("deprecation")
public class ImageDownloader {
	public static void main(String[] args) {
		String user = "hoff";
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet imGet = new HttpGet("http://1-dot-pelagic-quanta-690.appspot.com/_ah/getPic/?userid="
				+ user);
		HttpResponse response = null;
		try {
			response = client.execute(imGet);
			toImage(user, response.getEntity().getContent());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			imGet.releaseConnection();
			client.close();
		}
		// convert byte array back to BufferedImage

	}

	private static void toImage(String fileName, InputStream imageBytes)
			throws Exception {
		BufferedImage bImageFromConvert = ImageIO.read(imageBytes);
		ImageIO.write(bImageFromConvert, "jpg", new File("/Users/iRock/robePics/" + fileName + ".jpg"));
		imageBytes.close();
	}
}
