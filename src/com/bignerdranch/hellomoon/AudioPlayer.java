package com.bignerdranch.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
	
	private MediaPlayer mPlayer;

	public void stop() {
		if( mPlayer != null ){
			mPlayer.release();
			mPlayer = null;
		}
	}
	
	public void pause(){
		if ( mPlayer != null ){
			mPlayer.pause();
		}
	}
	
	public void play(Context c){
		if( mPlayer !=null && mPlayer.isPlaying() ){
			stop();
		}
		
		// Only create a new one if we need to
		if ( mPlayer == null) {
			mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
		}
		
		// Ensure we don't have too many instances of Media Player
		mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				stop();
			}
		});
		
		mPlayer.start();
	}
	
}
