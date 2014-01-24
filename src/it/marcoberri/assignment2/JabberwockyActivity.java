package it.marcoberri.assignment2;

import it.marcoberri.Assignment2.R;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class JabberwockyActivity extends Activity {

	MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jabberwocky);
		WebView webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/jabberwocky.html");
        this.setTitle(R.string.title_activity_jabberwocky);
        mp = MediaPlayer.create(this, R.raw.sample);
        mp.setLooping(true);
        mp.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.jabberwocky, menu);
		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		mp.stop();
		return super.onKeyDown(keyCode, event);
	}
	
	
	public void toWiki(View v){
		final Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://it.wikipedia.org/wiki/Jabberwocky"));
		startActivity(browserIntent);
	}
	
	public void changeImage(View v){

		WebView webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/Jabberwocky.jpg/250px-Jabberwocky.jpg");
	}
}
