package net.spritti.activitybehaviours.behaviour;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import net.spritti.activitybehaviours.base.SimpleBehaviour;


public class SetLayoutIdBehaviour extends SimpleBehaviour {

	private final int layoutResId;

	public SetLayoutIdBehaviour(int layoutResId) {
		this.layoutResId = layoutResId;
	}

	@Override
	protected void onCreate(@NonNull AppCompatActivity activity, @Nullable Bundle instanceState) {
		activity.setContentView(layoutResId);
	}
}
