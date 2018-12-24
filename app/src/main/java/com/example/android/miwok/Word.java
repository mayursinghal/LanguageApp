package com.example.android.miwok;

public class Word {
    private String mDefaultTransition;
    private String mMiwokTransition;
    private int no_images=-1;
    private int mimageResourceId=no_images;
    private int mAudioPosition;

    public  Word(String defaultTransition,String miwokTransition,int audioPosition)
    {
        mDefaultTransition=defaultTransition;
        mMiwokTransition=miwokTransition;
        mAudioPosition=audioPosition;
    }
    public Word(String defaultTransition,String miwokTransition,int imageResourceId,int audioPosition)
    {
        mDefaultTransition=defaultTransition;
        mMiwokTransition=miwokTransition;
        mimageResourceId=imageResourceId;
        mAudioPosition=audioPosition;

    }

    public String getDefaultTransition()
    {
        return mDefaultTransition;
    }
    public String getMiwokTransition()
    {
        return mMiwokTransition;
    }

    public int getImageResourceId() {
        return mimageResourceId;
    }

    public int getAudioPosition(){
        return mAudioPosition;
    }

    public boolean hasImage()
    {
            return mimageResourceId!=no_images;
    }
}
