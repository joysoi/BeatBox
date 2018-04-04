package com.bignerdranch.android.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BeatBox {
    public static final String TAG = "BeatBox";
    public static final String SOUND_FOLDERS = "sample_sounds";
    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<>();

    public BeatBox(Context context) {
        mAssets = context.getAssets();
        loadSound();
    }

    private void loadSound() {
        String[] soundNames = new String[0];
        try {
            soundNames = mAssets.list(SOUND_FOLDERS);
            Log.i(TAG, "Found " + soundNames.length + " sounds");
        } catch (IOException e) {
            Log.i(TAG, "Could not list assets", e);
        }

        for (String filename : soundNames) {
            String assetPath = SOUND_FOLDERS + "/" + filename;
            Sound sound = new Sound(assetPath);
            mSounds.add(sound);
        }
    }

    public List<Sound> getSounds() {
        return mSounds;
    }
}
