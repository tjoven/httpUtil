import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


public class HttpRequest {

	public static void main(String[] args) {
		String url = "https://www.baidu.com";
		String result = download(url);
		System.out.println("result£º"+result);
	}
	public static String download(String urlStr){
		String result = null;
		HttpGet request = new HttpGet(urlStr);
		HttpClient httpClient =new DefaultHttpClient();
		try {
			HttpResponse response = httpClient.execute(request);
			if (response.getStatusLine().getStatusCode() == org.apache.http.HttpStatus.SC_OK) {
                result= EntityUtils.toString(response.getEntity(),"utf-8");
            } 
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("http ÉÏ´«dapiÊ§°Ü£º"+e1.getMessage());
		} 
		return result;
	}
}
