package net.spritti.activitybehaviours.behaviour;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import net.spritti.activitybehaviours.base.SimpleBehaviour;


public class ToolbarHomeAsUpBehaviour extends SimpleBehaviour {

	@Override
	protected void onPostCreate(@NonNull AppCompatActivity activity, @Nullable Bundle instanceState) {
		ActionBar actionBar = activity.getSupportActionBar();
		if (actionBar != null) {
			actionBar.setHomeButtonEnabled(true);
			actionBar.setDisplayShowHomeEnabled(true);
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
	}
}
