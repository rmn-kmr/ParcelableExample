package com.rmn.javaprac;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> stringList = Arrays.asList("A", "b", "c", "d", "e", "f", "g", "h");

        List<String> resultList = stringList.stream()
                .filter(item ->
                    item.equals("a"))
                .sorted()
                .collect(Collectors.toList());

        UsbManager manager = (UsbManager) getSystemService(Context.USB_SERVICE);
        UsbAccessory[] accessoryList = manager.getAccessoryList();


        Consumer<String> action = System.out::print;
        resultList.forEach(action);
    }
}
