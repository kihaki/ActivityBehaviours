package net.spritti.activitybehaviours.behaviour;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import net.spritti.activitybehaviours.base.SimpleBehaviour;


public class SetToolbarBehaviour extends SimpleBehaviour {

	@IdRes private int                    toolbarId;
	private        Pair<Boolean, Boolean> showTitle;
	private        Pair<Boolean, Boolean> homeButtonEnabled;
	private        Pair<Boolean, Boolean> displayShowHomeButtonEnabled;
	private        Pair<Boolean, Boolean> displayHomeAsUpEnabled;

	SetToolbarBehaviour(@IdRes int toolbarId) {
		this.toolbarId = toolbarId;
	}

	public static SetToolbarBehaviour with(@IdRes int toolbarId) {
		return new SetToolbarBehaviour(toolbarId);
	}

	private boolean shouldSet(@Nullable Pair<Boolean, Boolean> setParameter) {
		return setParameter != null && setParameter.first;
	}

	@Override
	protected void onPostCreate(@NonNull AppCompatActivity activity, @Nullable Bundle instanceState) {
		Toolbar toolbar = (Toolbar) activity.findViewById(toolbarId);
		activity.setSupportActionBar(toolbar);
		ActionBar actionBar = activity.getSupportActionBar();
		if (actionBar != null) {
			if (shouldSet(showTitle)) {
				actionBar.setDisplayShowTitleEnabled(showTitle.second);
			}
			if (shouldSet(homeButtonEnabled)) {
				actionBar.setHomeButtonEnabled(homeButtonEnabled.second);
			}
			if (shouldSet(displayShowHomeButtonEnabled)) {
				actionBar.setDisplayShowHomeEnabled(displayShowHomeButtonEnabled.second);
			}
			if (shouldSet(displayHomeAsUpEnabled)) {
				actionBar.setDisplayHomeAsUpEnabled(displayHomeAsUpEnabled.second);
			}
		}
	}

	public SetToolbarBehaviour setDisplayShowTitleEnabled(boolean show) {
		showTitle = new Pair<>(true, show);
		return this;
	}

	public SetToolbarBehaviour setHomeButtonEnabled(boolean show) {
		homeButtonEnabled = new Pair<>(true, show);
		return this;
	}

	public SetToolbarBehaviour setDisplayShowHomeEnabled(boolean show) {
		displayShowHomeButtonEnabled = new Pair<>(true, show);
		return this;
	}

	public SetToolbarBehaviour setDisplayHomeAsUpEnabled(boolean show) {
		displayHomeAsUpEnabled = new Pair<>(true, show);
		return this;
	}

	public SetToolbarBehaviour setDisplayHomeAsUpCompletely(boolean show) {
		setHomeButtonEnabled(show);
		setDisplayShowHomeEnabled(show);
		setDisplayHomeAsUpEnabled(show);
		return this;
	}
}
