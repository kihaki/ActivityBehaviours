package net.spritti.activitybehaviours.behaviour;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import net.spritti.activitybehaviours.base.SimpleBehaviour;


public class SetupDrawerToggleBehaviour extends SimpleBehaviour {

	@IdRes private final     int drawerId;
	private final            int drawerGravity;
	@StringRes private final int openDrawerContentDescRes;
	@StringRes private final int closeDrawerContentDescRes;
	private ActionBarDrawerToggle drawerToggle;

	SetupDrawerToggleBehaviour(
			@IdRes int drawerId,
			int drawerGravity,
			@StringRes int openDrawerContentDescRes,
			@StringRes int closeDrawerContentDescRes) {
		this.drawerId = drawerId;
		this.drawerGravity = drawerGravity;
		this.openDrawerContentDescRes = openDrawerContentDescRes;
		this.closeDrawerContentDescRes = closeDrawerContentDescRes;
	}

	public static SetupDrawerToggleBehaviour with(
			@IdRes int drawerId,
			int drawerGravity,
			@StringRes int openDrawerContentDescRes,
			@StringRes int closeDrawerContentDescRes) {
		return new SetupDrawerToggleBehaviour(drawerId, drawerGravity, openDrawerContentDescRes, closeDrawerContentDescRes);
	}

	@Override
	protected void onPostCreate(@NonNull AppCompatActivity activity, @Nullable Bundle instanceState) {
		DrawerLayout drawerLayout = (DrawerLayout) activity.findViewById(drawerId);
		drawerToggle =
				new ActionBarDrawerToggle(activity, drawerLayout, openDrawerContentDescRes, closeDrawerContentDescRes);
		drawerLayout.addDrawerListener(drawerToggle);
		drawerToggle.syncState();
	}

	@Override
	protected void onOptionsItemSelected(@NonNull AppCompatActivity activity, @NonNull MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				DrawerLayout drawerLayout = (DrawerLayout) activity.findViewById(drawerId);
				if(drawerToggle.isDrawerIndicatorEnabled()){
					setDrawerOpen(drawerLayout, !isDrawerOpen(drawerLayout));
				} else {
					activity.onBackPressed();
				}
		}
	}

	private boolean isDrawerOpen(@NonNull DrawerLayout drawerLayout) {
		return drawerLayout.isDrawerOpen(drawerGravity);
	}

	private void setDrawerOpen(@NonNull DrawerLayout drawerLayout, boolean open) {
		if (open) {
			drawerLayout.openDrawer(drawerGravity);
		} else {
			drawerLayout.closeDrawer(drawerGravity);
		}
	}

	public void showBackArrow(boolean showBackArrow){
		drawerToggle.setDrawerIndicatorEnabled(!showBackArrow);
	}
}
