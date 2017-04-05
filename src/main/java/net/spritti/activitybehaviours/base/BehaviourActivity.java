package net.spritti.activitybehaviours.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BehaviourActivity extends AppCompatActivity {
	private List<Behaviour> behaviours = new ArrayList<>();

	public void addBehaviourOnTop(@NonNull Behaviour... behaviour) {
		behaviours.addAll(0, Arrays.asList(behaviour));
	}

	public void addBehaviour(@NonNull Behaviour... behaviour) {
		behaviours.addAll(Arrays.asList(behaviour));
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		for (Behaviour behaviour : behaviours) {
			behaviour.onLifeCycleEvent(Behaviour.Event.ON_PRECREATE, this, savedInstanceState);
		}
		super.onCreate(savedInstanceState);
		for (Behaviour behaviour : behaviours) {
			behaviour.onLifeCycleEvent(Behaviour.Event.ON_CREATE, this, savedInstanceState);
		}
	}

	@Override
	protected void onPostCreate(@Nullable Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		for (Behaviour behaviour : behaviours) {
			behaviour.onLifeCycleEvent(Behaviour.Event.ON_POST_CREATE, this, savedInstanceState);
		}
	}

	@Override
	protected void onStart() {
		super.onStart();
		for (Behaviour behaviour : behaviours) {
			behaviour.onLifeCycleEvent(Behaviour.Event.ON_START, this, null);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		for (Behaviour behaviour : behaviours) {
			behaviour.onLifeCycleEvent(Behaviour.Event.ON_RESUME, this, null);
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		for (Behaviour behaviour : behaviours) {
			behaviour.onLifeCycleEvent(Behaviour.Event.ON_PAUSE, this, null);
		}
	}

	@Override
	protected void onStop() {
		super.onStop();
		for (Behaviour behaviour : behaviours) {
			behaviour.onLifeCycleEvent(Behaviour.Event.ON_STOP, this, null);
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		for (Behaviour behaviour : behaviours) {
			behaviour.onLifeCycleEvent(Behaviour.Event.ON_DESTROY, this, null);
		}
		behaviours.clear();
	}
}
