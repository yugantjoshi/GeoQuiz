package com.example.yugantjoshi.geoquiz;

/**
 * Created by yugantjoshi on 2/1/16.
 */
public class Question
{
    private int resId;
    boolean isTrue;
    public Question(int resId, boolean isTrue)
    {
        this.resId = resId;
        this.isTrue = isTrue;
    }

    public int getResId()
    {
        return this.resId;
    }
    public boolean getIsTrue()
    {
        return this.isTrue;
    }
    public void setResId(int resId)
    {
        this.resId = resId;
    }
    public void setIsTrue(boolean isTrue)
    {
        this.isTrue = isTrue;
    }
}
