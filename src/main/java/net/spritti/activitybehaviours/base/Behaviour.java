package net.spritti.activitybehaviours.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


public abstract class Behaviour {

	void onLifeCycleEvent(
			@NonNull Event event, @NonNull AppCompatActivity activity,
			@Nullable Bundle instanceState, @Nullable Object args) {
		switch (event) {
			case ON_PRECREATE:
				onPreCreate(activity, instanceState);
				break;
			case ON_CREATE:
				onCreate(activity, instanceState);
				break;
			case ON_POST_CREATE:
				onPostCreate(activity, instanceState);
				break;
			case ON_START:
				onStart(activity);
				break;
			case ON_RESUME:
				onResume(activity);
				break;
			case ON_PAUSE:
				onPause(activity);
				break;
			case ON_STOP:
				onStop(activity);
				break;
			case ON_DESTROY:
				onDestroy(activity);
				break;
			case ON_OPTIONS_ITEM_SELECTED:
				if (args != null) {
					onOptionsItemSelected(activity, (MenuItem) args);
				}
				break;
		}
	}

	protected abstract void onOptionsItemSelected(@NonNull AppCompatActivity activity, @NonNull MenuItem item);

	abstract protected void onPreCreate(@NonNull AppCompatActivity activity, @Nullable Bundle instanceState);

	abstract protected void onCreate(@NonNull AppCompatActivity activity, @Nullable Bundle instanceState);

	abstract protected void onPostCreate(@NonNull AppCompatActivity activity, @Nullable Bundle instanceState);

	abstract protected void onStart(@NonNull AppCompatActivity activity);

	abstract protected void onResume(@NonNull AppCompatActivity activity);

	abstract protected void onPause(@NonNull AppCompatActivity activity);

	abstract protected void onStop(@NonNull AppCompatActivity activity);

	abstract protected void onDestroy(@NonNull AppCompatActivity activity);

	public enum Event {
		ON_PRECREATE, ON_CREATE, ON_POST_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_OPTIONS_ITEM_SELECTED, ON_DESTROY
	}
}
