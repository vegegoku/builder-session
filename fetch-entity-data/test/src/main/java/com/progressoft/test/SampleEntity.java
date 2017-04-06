package com.progressoft.test;

import com.progressoft.test.fifth.HasState;
import com.progressoft.test.fifth.StateListener;

import java.util.ArrayList;
import java.util.List;

public class SampleEntity implements StateListener<SampleDs>{

    private long id;
    private String value;

    private SampleDs sampleDs;

    private interface  Something{
        void doSomething();
    }

    private Something something= () -> System.out.println("test");

    @Override
    public void onStateUpdated(SampleDs state) {
        this.sampleDs=state;
    }

    private List<StateListener> stateListeners=new ArrayList<StateListener>();

    public HasState<SampleDs> state= stateListener -> stateListeners.add(stateListener);

    public SampleEntity(long id, String value) {
        this.id = id;
        this.value = value;
    }

    public void manipulateThings(){
        //do something here
        publishState();
    }

    public void publishState(){
        stateListeners.forEach(s->s.onStateUpdated(new SampleDs(id, value)));
    }

    public SampleDs getSampleDs() {
        return sampleDs;
    }
}
