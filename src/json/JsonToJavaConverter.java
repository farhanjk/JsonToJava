package json;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.latest.items.Latest;
import com.squareup.okhttp.OkHttpClient;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;

/**
 * Created by fkhan on 2013-08-22.
 */
public class JsonToJavaConverter {

    public static void main(String argv[]) throws IOException {
        JsonToJavaConverter jsonToJavaConverter=new JsonToJavaConverter();
        String json = jsonToJavaConverter.getJsonFromURL("http://arc.nick-q.mtvi.com/api/v2/editorial-content-categories/stars?apiKey=gve7v8ti");
        jsonToJavaConverter.parseJSON(json.getBytes());
    }

    private void parseJSON(byte[] json)
    {
        try {
            JsonFactory jfactory = new JsonFactory();

            JsonParser jp = jfactory.createParser(json);

            LinkedHashMap<String, Object> hashMap = new LinkedHashMap<String, Object>();

            handleToken(hashMap, jp, jp.nextToken());

            System.out.println(hashMap);
            jp.close();

        } catch (JsonGenerationException e) {

            e.printStackTrace();

        } catch (JsonMappingException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    private void handleToken(LinkedHashMap<String, Object> hashMap, JsonParser jp, JsonToken token) throws IOException {
        if (token==null)
            return;
        else
        {
            if (token==JsonToken.START_ARRAY)
                handleArray("Objects", hashMap, jp);
            if (token==JsonToken.START_OBJECT)
                handleObject(hashMap, jp);
            handleToken(hashMap, jp, jp.nextToken());

        }
    }

    private void handleObject(LinkedHashMap<String, Object> hashMap, JsonParser jp) throws IOException {
        JsonToken current =jp.nextToken();
        while (current!= JsonToken.END_OBJECT)
        {
            String fieldname = jp.getCurrentName();
            current = jp.nextToken();
            if (current==JsonToken.VALUE_STRING)
            {
                String value = jp.getText();
                System.out.println(fieldname + ":" + value);
                hashMap.put(fieldname,value);
            }
            else
            {
                System.out.println(fieldname + ":");
                //hashMap.put(fieldname,hashMap);
            }
            if (current==JsonToken.START_ARRAY)
                handleArray(fieldname, hashMap, jp);
            if (current==JsonToken.START_OBJECT)
                handleObject(hashMap, jp);
            current = jp.nextToken();
        }
    }


    private void handleArray(String name, LinkedHashMap<String, Object> hashMap, JsonParser jp) throws IOException {
        JsonToken current = jp.nextToken();
        LinkedHashMap<String, Object> hmMain = new LinkedHashMap<String, Object>();
        hashMap.put(name, hmMain );
        int index =0;
        while (current!= JsonToken.END_ARRAY)
        {
            LinkedHashMap<String, Object> hm = new LinkedHashMap<String, Object>();
            hmMain.put(String.valueOf(index), hm);
            if (current==JsonToken.START_ARRAY)
                handleArray(String.valueOf(index), hm, jp);
            if (current==JsonToken.START_OBJECT)
                handleObject(hm, jp);
            current = jp.nextToken();
            index++;
        }
    }

    private String getJsonFromURL(String url) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        HttpURLConnection httpURLConnection = okHttpClient.open(new URL(url));
        httpURLConnection.setRequestMethod("GET");
        InputStream is = httpURLConnection.getInputStream();
        byte[] bytes = IOUtils.toByteArray(is);
        String json = new String(bytes, "UTF-8");

        return json;
    }

    public Object fromJson(String json) throws JsonParseException
            , JsonMappingException, IOException{
        Latest latest = new ObjectMapper().readValue(json, Latest.class);
        return latest;
    }

}
