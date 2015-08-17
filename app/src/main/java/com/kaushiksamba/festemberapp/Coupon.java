package com.kaushiksamba.festemberapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class Coupon extends Activity implements CouponFragment.OnClickListener,GenderSelectFragment.OnClickListener, SizeSelectFragment.OnClickListener
{
    FragmentManager fm;
    TextView instruction;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);
        instruction = (TextView) findViewById(R.id.instructionText);
        CouponFragment fragment = new CouponFragment();
        fm = getFragmentManager();
        fm.beginTransaction().add(R.id.frameLayout, fragment, "CouponSelect").commit();
    }

    @Override
    public void CouponToGender()
    {
        GenderSelectFragment genderSelectFragment= new GenderSelectFragment();
        fm.beginTransaction().replace(R.id.frameLayout,genderSelectFragment,"GenderSelect").addToBackStack(null).commit();
        instruction.setText("Select gender");
    }

    @Override
    public void GenderToShirtSize()
    {
        SizeSelectFragment sizeSelectFragment = new SizeSelectFragment();
        fm.beginTransaction().replace(R.id.frameLayout, sizeSelectFragment, "SizeSelect").addToBackStack(null).commit();
        instruction.setText("Select shirt size");
    }

    @Override
    public void OpenConfirmPage()
    {
        Intent intent = new Intent(getBaseContext(),ConfirmPage.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed()
    {
        if(fm.getBackStackEntryCount()>0) fm.popBackStackImmediate();
        else super.onBackPressed();
    }
}