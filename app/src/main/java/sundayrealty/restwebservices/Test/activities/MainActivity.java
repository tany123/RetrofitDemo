package sundayrealty.restwebservices.Test.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import sundayrealty.restwebservices.AppController;
import sundayrealty.restwebservices.R;
import sundayrealty.restwebservices.Test.pojos.AgentContactCountPojo;
import sundayrealty.restwebservices.Test.pojos.AgentContactCountResponse;
import sundayrealty.restwebservices.common.MethodsEnum;
import sundayrealty.restwebservices.common.ResponseTypeEnum;
import sundayrealty.restwebservices.common.ServiceListner;
import sundayrealty.restwebservices.common.WebService;


public class MainActivity extends Activity implements ServiceListner {
    Button btnCall;
    TextView txtResp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResp = (TextView) findViewById(R.id.txtResp);

//


    }

    public void call_webservice(View v) {
//        call_webservice();
//        call_webservice_2();
//        call_webservice_3(); // aspx
//        call_webservice_4(); // asmx
//        call_webservice_5_svc(); //svc
//        request_web();
        call_webservice_4_retrofit();
    }

    private void call_webservice_2() {

        String url = "your_URL/Default.aspx";


        RequestParams params = new RequestParams();
        params.put("Type", "AgentContactCount");
        params.put("sMyAgentID", "35");
        params.put("sCount", "0");
        params.put("sMisType", "Call");

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, params, new AsyncHttpResponseHandler() {
            // When the response returned by REST has Http response code '200'
            @Override
            public void onSuccess(String response) {
                txtResp.setText("Res\n" + response);
            }

            // When the response returned by REST has Http response code other than '200'
            @Override
            public void onFailure(int statusCode, Throwable error,
                                  String content) {
                txtResp.setText("Error");
            }
        });
    }

    private void call_webservice() {

        String url = "your_URL/dumy.asmx/Default.aspx";

        StringRequest req = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                txtResp.setText("Res\n" + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                txtResp.setText("Error\n" + error.getMessage());
                VolleyLog.d("error", "Error: " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("Type", "AgentContactCount");
                params.put("sMyAgentID", "35");
                params.put("sCount", "0");
                params.put("sMisType", "Call");

                return params;
            }

        };

        req.setRetryPolicy(new DefaultRetryPolicy(20000, 0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(req, "ABC");
    }


    private void call_webservice_3() {
        String tag_json_obj = "json_obj_req";

        String url = "your_URL/Default.aspx";


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.POST,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        txtResp.setText("Res\n" + response.toString());
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("error", "Error: " + error.getMessage());
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("Type", "AgentContactCount");
                params.put("sMyAgentID", "35");
                params.put("sCount", "0");
                params.put("sMisType", "Call");

                return params;
            }

        };

        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(20000, 0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }


    private void call_webservice_4() {
        String tag_json_obj = "json_obj_req";

        String url = "your_URL/dumy.asmx/Count";


        StringRequest req = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                txtResp.setText("Res\n" + response.toString());
//                parse_data(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                txtResp.setText("Error\n" + error.getMessage());
                VolleyLog.d("error", "Error: " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("sMyAgentID", "35");
                params.put("sCount", "0");
                params.put("sMisType", "Call");


                return params;
            }

        };

        req.setRetryPolicy(new DefaultRetryPolicy(20000, 0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(req, tag_json_obj);
    }


    private void call_webservice_5_svc() {
        String tag_json_obj = "json_obj_req";

        String url = "your_URL/DiscoveryPortal.svc/Details";


        StringRequest req = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                txtResp.setText("Res\n" + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                txtResp.setText("Error\n" + error.getMessage());
                VolleyLog.d("error", "Error: " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("EmpID", "1");
                return params;
            }

        };

        req.setRetryPolicy(new DefaultRetryPolicy(20000, 0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(req, "ABC");
    }

    private void parse_data(String response) {
        try {
            DocumentBuilder db = null;

            db = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(response));

            Document doc = null;
            try {
                doc = db.parse(is);
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            NodeList nodes = doc.getElementsByTagName("string");

            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);

                txtResp.setText("Res\n" + getCharacterDataFromElement(element));

            }


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "";
    }


    public JSONObject request_web() {

        String URL = "your_URL/DiscoveryPortal.svc/Details";
        JSONObject json_obj = null;
//        try {
//            HttpPost req = new HttpPost(URL);
//            req.setHeader("Accept", "application/json");
//            req.setHeader("Content-type", "application/json");
//            DefaultHttpClient httpClient = new DefaultHttpClient();
//            HttpResponse Response = httpClient.execute(req);
//            HttpEntity resHttpEntity = Response.getEntity();
//            char[] buffer = new char[(int)resHttpEntity.getContentLength()];
//            InputStream stream = resHttpEntity.getContent();
//            InputStreamReader reader = new InputStreamReader(stream);
//            reader.read(buffer);
//            stream.close();
//            json_obj = new JSONObject(new String(buffer));
//        } catch (Exception e) {
//            Log.e("error",e.toString());
//        }

        RequestParams params = new RequestParams();
        params.put("EmpID", "1");

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(URL, params, new AsyncHttpResponseHandler() {
            // When the response returned by REST has Http response code '200'
            @Override
            public void onSuccess(String response) {
                txtResp.setText("Res\n" + response);
            }

            // When the response returned by REST has Http response code other than '200'
            @Override
            public void onFailure(int statusCode, Throwable error,
                                  String content) {
                txtResp.setText("Error");
            }
        });

        return json_obj;
    }


    private void call_webservice_4_retrofit() {
        AgentContactCountPojo loginPojo = new AgentContactCountPojo();
        loginPojo.setSMyAgentID("35");
        loginPojo.setSCount("0");
        loginPojo.setSMisType("Call");
        new WebService(loginPojo, this, MethodsEnum.AgentContactCount, this).execute();
    }


    @Override
    public void onResponse(Object obj, ResponseTypeEnum status) {
        final AgentContactCountResponse loginResponse = (AgentContactCountResponse) obj;
        if (loginResponse.getStatus()) {
            txtResp.setText(loginResponse.getStatus().toString());
        }
    }
}
