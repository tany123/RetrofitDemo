package sundayrealty.restwebservices.Test.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import sundayrealty.restwebservices.R;
import sundayrealty.restwebservices.Test.pojos.AgentContactCountPojo;
import sundayrealty.restwebservices.Test.pojos.AgentContactCountResponse;
import sundayrealty.restwebservices.common.MethodsEnum;
import sundayrealty.restwebservices.common.ResponseTypeEnum;
import sundayrealty.restwebservices.common.ServiceListner;
import sundayrealty.restwebservices.common.WebService;


public class MainActivity_2 extends Activity implements ServiceListner {
    TextView txtResp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResp = (TextView) findViewById(R.id.txtResp);
    }

    public void call_webservice(View v) {
        call_webservice_4_retrofit();
    }

    private void call_webservice_4_retrofit() {
        AgentContactCountPojo agentContactCountPojo = new AgentContactCountPojo();
        agentContactCountPojo.setSMyAgentID("35");
        agentContactCountPojo.setSCount("0");
        agentContactCountPojo.setSMisType("Call");
        new WebService(agentContactCountPojo, this, MethodsEnum.AgentContactCount, this).execute();
    }


    @Override
    public void onResponse(Object obj, ResponseTypeEnum status) {
        final AgentContactCountResponse agentContactCountResponse = (AgentContactCountResponse) obj;
        if (agentContactCountResponse.getStatus()) {
            txtResp.setText(agentContactCountResponse.getStatus().toString());
        }
    }
}
