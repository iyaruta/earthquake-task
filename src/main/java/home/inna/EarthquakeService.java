package home.inna;

import com.google.gson.Gson;
import model.FeaturesCollection;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EarthquakeService {

    public static void main(String[] args) throws IOException {
        String content = getContent("http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson");
        Gson gson = new Gson();
        FeaturesCollection features = gson.fromJson(content, FeaturesCollection.class);
        System.out.println(content);

    }

    private static String getContent(String uri) throws IOException {
        HttpGet request = new HttpGet(uri);
        try (CloseableHttpClient client = HttpClients.createDefault(); CloseableHttpResponse response = client.execute(request) ) {
            InputStream inputStream = response.getEntity().getContent();

            final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }

            return json.toString();
        }
    }

}
