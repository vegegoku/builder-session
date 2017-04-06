package com.progressoft.test;

import com.progressoft.test.fifth.StateListener;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SampleEntity se=new SampleEntity(1,"test");

        StateListener repository=
                state -> System.out.println(state.getId()+" : "+state.getValue());

        se.state.addListener(repository);

        se.persist();
    }
}
