/**
 * Author: sandy
 * QQ��������Ⱥ��439261058
 * ΢�Ź��ںţ�����֮��(codestravel)
**/
package com.example.ct_text2speechdemo;

import java.util.Locale;
import android.os.Bundle;
import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnInitListener{
	//����ؼ�
	private Button speechButton;  
    private TextView speechText;  
    private TextToSpeech tts;
	
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//��ʼ��TTS
		tts = new TextToSpeech(this, this);
		//��ȡ�ؼ�
		speechText = (TextView)findViewById(R.id.speechTextView);  
        speechButton = (Button)findViewById(R.id.speechButton);  
        //Ϊbutton��Ӽ���
        speechButton.setOnClickListener(new OnClickListener(){   
            @Override  
            public void onClick(View v){  
                // TODO Auto-generated method stub  
                tts.speak(speechText.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);  
            }  
        });  
		
	}
    
    @Override  
    public void onInit(int status){  
        // �ж��Ƿ�ת���ɹ�  
        if (status == TextToSpeech.SUCCESS){  
            //Ĭ���趨����Ϊ���ģ�ԭ����androidò�Ʋ�֧�����ġ�
            int result = tts.setLanguage(Locale.CHINESE);  
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){  
                Toast.makeText(MainActivity.this, R.string.notAvailable, Toast.LENGTH_SHORT).show();  
            }else{
                //��֧�����ľͽ���������ΪӢ��
                tts.setLanguage(Locale.US);
            }  
        }  
    }  

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
