package ch.fhnw.oop2.tasky.part4.ui.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Status {
    Todo, Doing, Done;

    Status(){

    }

    public static List<Status> getAllStati(){
        return Stream.of(Status.Todo, Status.Doing, Status.Done)
                .collect(Collectors.toList());
    }
}
