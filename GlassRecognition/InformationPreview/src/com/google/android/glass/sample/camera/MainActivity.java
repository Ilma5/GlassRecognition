/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.glass.sample.camera;

import java.io.ByteArrayOutputStream;

import com.example.informationpreview.MainManuActivity;
import com.example.informationpreview.R;
import com.github.barcodeeye.scan.CaptureActivity;
import com.google.android.glass.touchpad.GestureDetector;
import com.google.android.glass.touchpad.Gesture;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 * Shows a simple camera preview and takes a picture on tap.
 */
public class MainActivity extends Activity implements GestureDetector.BaseListener {

    private static final String TAG = "MainActivity";

    private CameraPreview mPreview;
    private Camera mCamera;
    public String capturedPhoto;

    private GestureDetector mDetector;

    private final PictureCallback mPictureCallback = new PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            Log.d(TAG, "Picture taken!");
            // TODO: process the picture.
            String s = new String(Base64.encode(data,0));
	   		byte[] decodedString = Base64.decode(s, Base64.DEFAULT);
			Bitmap b = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
			//Bitmap sbitmap = scaleDownBitmap(b, 100, MainActivity.this);
			Bitmap sbitmap;
			sbitmap=Bitmap.createScaledBitmap(b,600,442,false);
			capturedPhoto=encodeTobase64(sbitmap);
            
// Sending result (onActivityResult from InformationPreview):
            Intent intent = new Intent();
            intent.putExtra("Captured_photo",capturedPhoto);
            setResult(RESULT_OK, intent);
            finish();
        }
    };

//    @Override
//	public void finish() {
//    	   Intent intent = new Intent();
//    	setResult(RESULT_CANCELED, intent);
//		super.finish();
//	}

	public static String encodeTobase64(Bitmap image)
    {
        Bitmap immagex=image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
        immagex.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b,Base64.DEFAULT);

        //Log.e("LOOK", imageEncoded);
        //System.out.print(imageEncoded);
        return imageEncoded;
    }
    
//scale down method
    public static Bitmap scaleDownBitmap(Bitmap photo, int newHeight, Context context) {

    	final float densityMultiplier = context.getResources().getDisplayMetrics().density;        

    	int h= (int) (newHeight*densityMultiplier);
    	int w= (int) (h * photo.getWidth()/((double) photo.getHeight()));

    	photo=Bitmap.createScaledBitmap(photo, w, h, true);

    	return photo;
    	}
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCamera = getCameraInstance();

        setContentView(R.layout.activity_camera);
        mPreview = (CameraPreview) findViewById(R.id.preview);
        Toast.makeText(getApplicationContext(), "    Tap to take a picture  \nLong press for options menu", Toast.LENGTH_LONG).show();


        mDetector = new GestureDetector(this).setBaseListener(this);
        

    }

    @Override
    public void onResume() {
        super.onResume();
        mPreview.setCamera(mCamera);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPreview.setCamera(null);
        mCamera.release();
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        return mDetector.onMotionEvent(event);
    }

    @Override
    public boolean onGesture(Gesture gesture) {
        if (gesture == Gesture.TAP) {
            mCamera.takePicture(null, null, mPictureCallback);
            return true;
        }
        if (gesture == Gesture.LONG_PRESS){
    		Intent intent = new Intent(MainActivity.this, MainManuActivity.class);
    		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);		
    		startActivity(intent);
    		finish();
        	return true;
        }
        return false;
    }

    private Camera getCameraInstance() {
        Camera camera = null;
        try {
            camera = Camera.open();
            // Work around for Camera preview issues.
            Camera.Parameters params = camera.getParameters();
            params.setPreviewFpsRange(30000, 30000);
            camera.setParameters(params);
        } catch (Exception e) {
            // cannot get camera or does not exist
        }
        return camera;
    }
}
